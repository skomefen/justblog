package test.dao;

import model.UserModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.UserDao;
import dao.Impl.UserDaoImpl;

public class UserDaoTest {

	UserDao dao = new UserDaoImpl();
	UserModel user = new UserModel();
	@Before
	public void setUp() throws Exception {
		user.setId("a123");
		user.setUsername("xiaoming");
		user.setPassword("123");
		user.setEmail("asd123@qq.com");
		user.setNickname("xiaoxiaoming");
		user.setPhone("123456");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		dao.add(user);
	}

	@Test
	public void testUpdate() {
		user.setEmail("asd@qq.com");
		dao.update(user);
	}
	
	@Test
	public void testFind() {
		dao.find("a123");
	}
	
	@Test
	public void testLogin() {
		dao.login("xiaoming", "123");
	}

	@Test
	public void testDelete() {
		dao.delete("a123");
	}

	

	


}
