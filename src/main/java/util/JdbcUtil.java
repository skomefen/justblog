package util;

import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtil {
	private static DataSource ds;
	private static ThreadLocal<Connection> t1 = new ThreadLocal<Connection>();

	static {
		try {
			ds = new ComboPooledDataSource();
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Connection getConnection() {

		try {
			Connection conn = t1.get();
			if (conn == null) {
				conn = ds.getConnection();
				t1.set(conn);
			}
			return conn;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void starTransacion() {
		try {
			Connection conn = t1.get();
			if (conn == null) {
				conn = ds.getConnection();
				t1.set(conn);
			}
			conn.setAutoCommit(false);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void closeConnection() {
		try {
			Connection conn = t1.get();
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			t1.remove();
		}
	}
	public static void commitTransaction(){
		try{
			Connection conn = t1.get();
			if(conn!=null){
				conn.commit();		
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

}
