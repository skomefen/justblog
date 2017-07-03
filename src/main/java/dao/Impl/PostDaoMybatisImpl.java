package dao.Impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import model.PostModel;
import model.QueryInfo;
import model.QueryResult;
import dao.PostDao;

@Scope("prototype")
@Repository(value="postdao")
public class PostDaoMybatisImpl implements PostDao{

	static SqlSessionFactory sqlSessionFactory = null;
	
	static{
		String resource = "dao/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}finally{
			try {
				inputStream.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public void add(PostModel post) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try{
			
			session.insert("dao.PostMapper.insertPost", post);
			
			Map<String,Object> paramter = new HashMap<String, Object>();
			paramter.put("id", post.getId());
			paramter.put("tag", post.getPost_tag());
			
			session.insert("dao.PostMapper.insertTagByPost", paramter);
			
			session.commit();
		}finally{
			session.close();
		}
	}

	public void delete(String id) {
		SqlSession session = sqlSessionFactory.openSession();
		try{
			session.delete("dao.PostMapper.deleteTagByPost", id);
			session.delete("dao.PostMapper.deletePost", id);
		}finally{
			session.close();
		}
	}

	public void update(PostModel post) {
		SqlSession session = sqlSessionFactory.openSession();
		try{
			session.update("dao.PostMapper.updatePost", post);
			
			String id = post.getId();
			
			session.delete("dao.PostMapper.deleteTagByPost", id);
			
			Map<String,Object> paramter = new HashMap<String, Object>();
			
			paramter.put("id", post.getId());
			paramter.put("tag", post.getPost_tag());
			
			session.insert("dao.PostMapper.insertTagByPost", paramter);
			
			session.commit();
			
		}finally{
			session.close();
		}
		
	}

	public PostModel find(String id) {
		
		SqlSession session =  sqlSessionFactory.openSession();
		PostModel post = null;
		try{
			post = session.selectOne("dao.PostMapper.selectPost", id);
			
		}finally{
			session.close();
		}
		return post;
	}

	public QueryResult findList(QueryInfo info) {
		SqlSession session = sqlSessionFactory.openSession();
		QueryResult qr = new QueryResult();
		try{
			List posts = session.selectList("dao.PostMapper.selectPostList", info);
			int count = session.selectOne("dao.PostMapper.postCount");
			qr.setResult(posts);
			qr.setTotal(count);
		}finally{
			session.close();
		}
		return qr;
	}

}
