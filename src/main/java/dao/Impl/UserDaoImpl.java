package dao.Impl;

import java.sql.Connection;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import util.JdbcUtil;
import dao.UserDao;
import exception.DaoException;
import model.UserModel;

public class UserDaoImpl implements UserDao {
	public void add(UserModel user) {
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			JdbcUtil.starTransacion();
			QueryRunner runner = new QueryRunner();
			String sql = "insert into user (id,username,password,nickname,email,phone)value(?,?,?,?,?,?)";
			Object param[] = { user.getId(), user.getUsername(),
					user.getPassword(), user.getNickname(), user.getEmail(),
					user.getPhone() };
			runner.update(conn, sql, param);
			JdbcUtil.commitTransaction();
		} catch (Exception e) {
			throw new DaoException(e);
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
			String sql = "delete from user where id=?";
			runner.update(conn, sql, id);
			JdbcUtil.commitTransaction();

		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.closeConnection();
		}
	}

	public void update(UserModel user) {
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			JdbcUtil.starTransacion();
			QueryRunner runner = new QueryRunner();
			String sql = "update user set username=?,password=?,nickname=?,email=?,phone=? where id=?";
			Object param[] = { user.getUsername(), user.getPassword(),
					user.getNickname(), user.getEmail(), user.getPhone(),
					user.getId() };
			runner.update(conn, sql, param);
			JdbcUtil.commitTransaction();

		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.closeConnection();
		}
	}

	public UserModel find(String id) {
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			JdbcUtil.starTransacion();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from user where id=?";
			UserModel result = runner.query(conn, sql,
					new BeanHandler<UserModel>(UserModel.class),id);
			JdbcUtil.commitTransaction();

			return result;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.closeConnection();
		}
	}

	public UserModel login(String username, String password) {
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			JdbcUtil.starTransacion();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from user where username=?and password=?";
			Object[] params = { username, password };
			UserModel result = runner.query(conn, sql,
					new BeanHandler<UserModel>(UserModel.class), params);
			JdbcUtil.commitTransaction();

			return result;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.closeConnection();
		}
	}
}
