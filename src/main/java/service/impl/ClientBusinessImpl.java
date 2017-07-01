package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

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

@Scope(value="prototype")
@Service(value="clientBusiness")
public class ClientBusinessImpl implements ClientBusiness{

	@Autowired
	UserDao userdao ;
	
	@Autowired
	PostDao postdao = new PostDaoImpl();
	public UserModel login(String username,String password) {
		// TODO Auto-generated method stub
		try{
			return userdao.login(username, ServiceUtils.makePassword(password));
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public void addUser(UserModel user){
		try{
			user.setPassword(ServiceUtils.makePassword(user.getPassword()));
			userdao.add(user);
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
