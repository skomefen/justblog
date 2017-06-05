package service.impl;

import dao.UserDao;
import dao.Impl.UserDaoImpl;
import model.UserModel;
import service.ClientBusiness;

public class ClientBusinessImpl implements ClientBusiness{

	UserDao dao = new UserDaoImpl();
	public UserModel login(String username,String password) {
		// TODO Auto-generated method stub
		try{
			return dao.login(username, password);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
}
