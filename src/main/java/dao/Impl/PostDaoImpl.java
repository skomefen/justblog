package dao.Impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import util.IntHandler;
import util.JdbcUtil;
import model.PostModel;
import model.QueryInfo;
import model.QueryResult;
import dao.PostDao;

public class PostDaoImpl implements PostDao {

	public void add(PostModel post) {
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			JdbcUtil.starTransacion();

			QueryRunner runner = new QueryRunner();
			String sql = "insert into post (id,title,thumbnail,postClass,description,udate,user_id,contextAddress,author)value(?,?,?,?,?,?,?,?,?)";
			Object[] params = { post.getId(), post.getTitle(),
					post.getThumbnail(), post.getPostClass(),
					post.getDescription(), post.getUdate(), post.getUser_id(),
					post.getContextAddress(),post.getAuthor() };

			runner.update(conn, sql, params);
			List<String> list = post.getPost_tag();
			if(list==null){
				JdbcUtil.commitTransaction();
				return;
			}	
			sql = "insert into post_tag(post_id,tag)value(?,?)";
			Object[][] paramss = new Object[list.size()][2];
			for (int i = 0; i < list.size(); i++) {
				paramss[i][0] = post.getId();
				paramss[i][1] = list.get(i);
			}
			runner.batch(conn, sql, paramss);
			JdbcUtil.commitTransaction();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.closeConnection();
		}
	}

	public void delete(String id) {
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			JdbcUtil.starTransacion();

			QueryRunner runner = new QueryRunner();
			
			String sql = "delete from post_tag where post_id = ?";
			runner.update(conn, sql, id);
			
			sql = "delete from post where id = ?";
			runner.update(conn, sql, id);

			JdbcUtil.commitTransaction();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.closeConnection();
		}
	}

	public void update(PostModel post) {
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			JdbcUtil.starTransacion();

			QueryRunner runner = new QueryRunner();
			String sql = "update post set title=?,thumbnail=?,postClass=?,description=?,udate=?,user_id=?,contextAddress=?,author=? where id=? ";
			Object params[] = { post.getTitle(), post.getThumbnail(),
					post.getPostClass(), post.getDescription(),
					post.getUdate(), post.getUser_id(),
					post.getContextAddress(), post.getAuthor(),post.getId() };
			runner.update(conn, sql, params);

			sql = "delete from post_tag where post_id=?";
			runner.update(conn,sql,post.getId());
			
			sql = "insert into post_tag (tag,post_id) value(?,?)";
			List<String> list = post.getPost_tag();
			if(list==null){
				JdbcUtil.commitTransaction();
				return;
			}
			Object paramss[][] = new Object[list.size()][2];
			for (int i = 0; i < list.size(); i++) {
				paramss[i][0] = list.get(i);
				paramss[i][1] = post.getId();
			}
			runner.batch(conn, sql, paramss);

			JdbcUtil.commitTransaction();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.closeConnection();
		}
	}

	public PostModel find(String id) {
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			JdbcUtil.starTransacion();

			QueryRunner runner = new QueryRunner();
			String sql = "select * from post where id = ?";
			PostModel post = runner.query(conn, sql,
					new BeanHandler<PostModel>(PostModel.class), id);

			if (post == null) {
				return null;
			}

			sql = "select tag from post_tag where post_id=?";
			List<Object[]> object = runner.query(conn, sql, new ArrayListHandler(), id);
			List<String> post_tag = new ArrayList<String>();
			
			if(object==null){
				JdbcUtil.commitTransaction();
				return post;
			}
			
			for(Object[] o:object){
				post_tag.add((String)o[0]);
			}
			
			post.setPost_tag(post_tag);

			JdbcUtil.commitTransaction();
			return post;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.closeConnection();
		}
	}

	public QueryResult findList(QueryInfo info) {
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			JdbcUtil.starTransacion();

			QueryRunner runner = new QueryRunner();
			String sql = "select * from post limit ?,?";
			Object params[] = { info.getStartIndex(), info.getPageSize() };
			List<PostModel> postList = runner.query(conn, sql,
					new BeanListHandler<PostModel>(PostModel.class), params);

			if (postList.isEmpty()) {
				return null;
			}

			sql = "select count(*) from post";
			int count = runner.query(conn, sql, new IntHandler());

			sql = "select tag from post_tag where post_id = ?";
			for (int i = 0; i < postList.size(); i++) {
				
				List<Object[]> object = runner.query(conn, sql, new ArrayListHandler(),
						postList.get(i).getId());		
				if(object==null){
					continue;
				}
				List<String> post_tag = new ArrayList<String>();
				for(Object[] o:object){
					post_tag.add((String)o[0]);
				}
				
				postList.get(i).setPost_tag(post_tag);
			}

			JdbcUtil.commitTransaction();

			QueryResult qr = new QueryResult();
			qr.setResult(postList);
			qr.setTotal(count);
			return qr;

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.closeConnection();
		}
	}

}
