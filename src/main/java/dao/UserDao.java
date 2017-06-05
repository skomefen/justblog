package dao;

import model.UserModel;

public interface UserDao {

	void add(UserModel user);

	void delete(String id);

	void update(UserModel user);

	UserModel find(String id);

	UserModel login(String username, String password);

}