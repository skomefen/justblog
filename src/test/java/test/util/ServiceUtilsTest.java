package test.util;

import static org.junit.Assert.*;

import java.io.File;

import model.PostContext;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import util.JdbcUtil;
import util.ServiceUtils;

public class ServiceUtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMd5() {
		Assert.assertEquals("ICy5YqxZB1uWSwcVLSNLcA==", ServiceUtils.md5("123"));
	}

	@Test
	public void testMakePassword(){
		Assert.assertEquals("t3JRbEcxZimzUfuN2CwXiw==", ServiceUtils.makePassword("123"));
	}
}
