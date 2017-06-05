package service;

import model.UserModel;

public interface ClientBusiness {
	public UserModel login(String username,String password);
}
