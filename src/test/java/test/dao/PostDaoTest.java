package test.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import model.PostContext;
import model.PostModel;
import model.QueryInfo;
import model.QueryResult;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.Impl.PostDaoImpl;
import dao.Impl.PostDaoMybatisImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PostDaoTest {

	static PostModel p1 = new PostModel();
	static PostModel p2 = new PostModel();

	@BeforeClass
	public static void setClassUp() throws Exception {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(123345123542111l);
		p1.setId("1233312113");
		p1.setTitle("helloworld");
		p1.setThumbnail("https://img6.bdstatic.com/img/image/smallpic/xingkonhyingchunh.jpg");
		p1.setUser_id("123");
		p1.setAuthor("abc");
		p1.setDescription("aaa");
		p1.setContextAddress("aaa123");
		p1.setUdate(c.getTime());
		List<String> post_tag = new ArrayList<String>();
		post_tag.add("aaaa");
		post_tag.add("bbb");
		p1.setPost_tag(post_tag);
		p1.setPostClass("ccc");

		p2.setId("12343312123");
		p2.setTitle("hellohellowworld");
		p2.setThumbnail("https://img6.bdstatic.com/img/image/smallpic/xingkonhyingchunh.jpg");
		p2.setUser_id("123");
		p2.setDescription("aaa");
		p2.setAuthor("abc");
		p2.setContextAddress("aaa123");
		p2.setUdate(c.getTime());
		p2.setPostClass("ccc");
	}

	@Test
	public void test1Add() {
		PostDaoImpl dao = new PostDaoImpl();
		dao.add(p1);
		dao.add(p2);
	}

	@Test
	public void test2Find() {
		PostDaoImpl dao = new PostDaoImpl();
		PostModel dp1 = dao.find(p1.getId());
		PostModel dp2 = dao.find(p2.getId());
		dao.find("asdadwsssxx");

		Assert.assertEquals(p1.getId(), dp1.getId());
		Assert.assertEquals(p1.getPostClass(), dp1.getPostClass());
		Assert.assertEquals(p1.getThumbnail(), dp1.getThumbnail());
		Assert.assertEquals(p1.getContextAddress(), dp1.getContextAddress());
		Assert.assertEquals(p1.getDescription(), dp1.getDescription());
		Assert.assertEquals(p1.getTitle(), dp1.getTitle());
		Assert.assertEquals(p1.getUdate().getSeconds(), dp1.getUdate()
				.getSeconds());
		Assert.assertEquals(p1.getUser_id(), dp1.getUser_id());

		Assert.assertEquals(p2.getId(), dp2.getId());
		Assert.assertEquals(p2.getPostClass(), dp2.getPostClass());
		Assert.assertEquals(p2.getThumbnail(), dp2.getThumbnail());
		Assert.assertEquals(p2.getContextAddress(), dp2.getContextAddress());
		Assert.assertEquals(p2.getDescription(), dp2.getDescription());
		Assert.assertEquals(p2.getTitle(), dp2.getTitle());
		Assert.assertEquals(p2.getUdate().getSeconds(), dp2.getUdate()
				.getSeconds());
		Assert.assertEquals(p2.getUser_id(), dp2.getUser_id());

	}

	@Test
	public void test3FindList() {
		PostDaoImpl dao = new PostDaoImpl();

		QueryInfo qi = new QueryInfo();
		qi.setPageSize(5);
		qi.setCurrent(1);

		QueryResult qr = dao.findList(qi);

		List list = qr.getResult();
		PostModel dp1 = null;
		PostModel dp2 = null;
		for (Object o : list) {
			PostModel p = (PostModel) o;
			if (p.getId().equals( p1.getId())) {
				dp1 = p;
			}
			if (p.getId().equals( p2.getId())) {
				dp2 = p;
			}
		}

		Assert.assertEquals(p1.getId(), dp1.getId());
		Assert.assertEquals(p1.getPostClass(), dp1.getPostClass());
		Assert.assertEquals(p1.getThumbnail(), dp1.getThumbnail());
		Assert.assertEquals(p1.getContextAddress(), dp1.getContextAddress());
		Assert.assertEquals(p1.getDescription(), dp1.getDescription());
		Assert.assertEquals(p1.getTitle(), dp1.getTitle());
		Assert.assertEquals(p1.getUdate().getSeconds(), dp1.getUdate()
				.getSeconds());
		Assert.assertEquals(p1.getUser_id(), dp1.getUser_id());

		Assert.assertEquals(p2.getId(), dp2.getId());
		Assert.assertEquals(p2.getPostClass(), dp2.getPostClass());
		Assert.assertEquals(p2.getThumbnail(), dp2.getThumbnail());
		Assert.assertEquals(p2.getContextAddress(), dp2.getContextAddress());
		Assert.assertEquals(p2.getDescription(), dp2.getDescription());
		Assert.assertEquals(p2.getTitle(), dp2.getTitle());
		Assert.assertEquals(p2.getUdate().getSeconds(), dp2.getUdate()
				.getSeconds());
		Assert.assertEquals(p2.getUser_id(), dp2.getUser_id());
	}

	@Test
	public void test4Update() {
		PostDaoImpl dao = new PostDaoImpl();

		p1.setPostClass("444");
		List<String> post_tag = new ArrayList<String>();
		post_tag.add("ccc");
		post_tag.add("ddd");
		p1.setPost_tag(post_tag);

		dao.update(p1);
		dao.update(p2);

		PostModel dp1 = dao.find(p1.getId());
		PostModel dp2 = dao.find(p2.getId());
		Assert.assertEquals(p1.getId(), dp1.getId());
		Assert.assertEquals(p1.getPostClass(), dp1.getPostClass());
		Assert.assertEquals(p1.getThumbnail(), dp1.getThumbnail());
		Assert.assertEquals(p1.getContextAddress(), dp1.getContextAddress());
		Assert.assertEquals(p1.getDescription(), dp1.getDescription());
		Assert.assertEquals(p1.getTitle(), dp1.getTitle());
		Assert.assertEquals(p1.getUdate().getSeconds(), dp1.getUdate()
				.getSeconds());
		Assert.assertEquals(p1.getUser_id(), dp1.getUser_id());

		Assert.assertEquals(p2.getId(), dp2.getId());
		Assert.assertEquals(p2.getPostClass(), dp2.getPostClass());
		Assert.assertEquals(p2.getThumbnail(), dp2.getThumbnail());
		Assert.assertEquals(p2.getContextAddress(), dp2.getContextAddress());
		Assert.assertEquals(p2.getDescription(), dp2.getDescription());
		Assert.assertEquals(p2.getTitle(), dp2.getTitle());
		Assert.assertEquals(p2.getUdate().getSeconds(), dp2.getUdate()
				.getSeconds());
		Assert.assertEquals(p2.getUser_id(), dp2.getUser_id());
	}

	@Test
	public void test5Delete() {
		PostDaoImpl dao = new PostDaoImpl();
		dao.delete(p1.getId());
		dao.delete(p2.getId());
		dao.delete("asdasdasdasdasdasd");
		Assert.assertNull(dao.find(p1.getId()));
		Assert.assertNull(dao.find(p2.getId()));

	}
	
	/***********************************
	 * mabatis
	 ***********************************/
	@Test
	public void test6add(){
		
		p1.setId("1232121222");
		p1.setTitle("hahaha");
		
		PostDaoMybatisImpl dao = new PostDaoMybatisImpl();
		dao.add(p1);
	}
	
	@Test
	public void test7update(){
		PostDaoMybatisImpl dao = new PostDaoMybatisImpl();
		PostModel p = dao.find("123333");
		p.setTitle("helloworld!!!");
		
		List<String> post_tag = new ArrayList<String>();
		post_tag.add("ccc");
		post_tag.add("ddd");
		
		p.setPost_tag(post_tag);
		
		dao.update(p);
		
		p = dao.find("123333");
		System.out.println(p);
	}
	@Test
	public void test8find(){
		PostDaoMybatisImpl dao = new PostDaoMybatisImpl();
		PostModel p = dao.find("123333");
		System.out.println(p);
	}
	@Test
	public void test9delete(){
		PostDaoMybatisImpl dao = new PostDaoMybatisImpl();
		dao.delete("1232121222");
	}
	@Test
	public void test9findList(){
		PostDaoMybatisImpl dao = new PostDaoMybatisImpl();
		QueryInfo info = new QueryInfo(1, 5);
		QueryResult qr = dao.findList(info);
		System.out.println(qr);
	}
}
