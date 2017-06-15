package util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import model.PostContext;
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
