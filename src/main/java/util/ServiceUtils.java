package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;



public class ServiceUtils {
	public static String md5(String message){
		
		try {
			return new BASE64Encoder().encode(MessageDigest.getInstance("md5").digest(message.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
}
