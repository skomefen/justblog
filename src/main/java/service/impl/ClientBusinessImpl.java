package service.impl;

import dao.PostDao;
import dao.UserDao;
import dao.Impl.PostDaoImpl;
import dao.Impl.UserDaoImpl;
import model.PostContext;
import model.PostModel;
import model.QueryInfo;
import model.QueryResult;
import model.UserModel;
import service.ClientBusiness;
import util.ServiceUtils;

public class ClientBusinessImpl implements ClientBusiness{

	UserDao userdao = new UserDaoImpl();
	PostDao postdao = new PostDaoImpl();
	public UserModel login(String username,String password) {
		// TODO Auto-generated method stub
		try{
			return userdao.login(username, ServiceUtils.md5(password));
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public void addPost(PostModel post) {
		// TODO Auto-generated method stub
		try{
			postdao.add(post);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	public QueryResult listPost(QueryInfo info) {
		try{
			return postdao.findList(info);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	public PostModel findPost(String id) {
		try{
			return postdao.find(id);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	

	
}
