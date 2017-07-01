package service;

import model.PostModel;
import model.QueryInfo;
import model.QueryResult;
import model.UserModel;


public interface ClientBusiness {
	/**************************
	 *     user
	 * *************************/
	public UserModel login(String username,String password);
	
	public void addUser(UserModel user);
	
	/**************************
	 *     post
	 * *************************/
	public void addPost(PostModel post);
	
	public QueryResult listPost(QueryInfo info);

	public PostModel findPost(String id);

	
}
