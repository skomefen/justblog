package test.justTest;

import java.util.Calendar;

import org.junit.Test;

public class JustTest {

	@Test
	public void test1(){
		Calendar c = Calendar.getInstance();
		System.out.println(c.getTime());
	}
	
}
