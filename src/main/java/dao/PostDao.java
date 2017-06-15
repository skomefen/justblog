package dao;

import java.util.List;

import model.PostModel;
import model.QueryInfo;
import model.QueryResult;

public interface PostDao {
	public void add(PostModel post);
	public void delete(String id);
	public void update(PostModel post);
	public PostModel find(String id);
	public QueryResult findList(QueryInfo info);
}
