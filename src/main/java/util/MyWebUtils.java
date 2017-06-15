package util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;


import model.PostContext;

public class MyWebUtils {

	public static String generateID() {
		// TODO Auto-generated method stub
		return UUID.randomUUID().toString();
	}

	public static String savePostContext(String rootpath,String title,String context) {
		// TODO Auto-generated method stub
		String path = createPath(rootpath,title,context);
		saveContext(path,context.getBytes());
		return path;
	}
	private static String createPath(String path,String title,String context) {
		// TODO Auto-generated method stub
		int hashcode =  context.hashCode();
		int dir1 = hashcode & 0xf;
		int dir2 = hashcode >> 4 &0xf;
		path = path+File.separator+dir1+File.separator+dir2;
		File f = new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		String filename = generateID()+".md"; 
		return path+File.separator+filename;
	}

	private static void saveContext(String contextAdress,byte[]contextByte) {
		// TODO Auto-generated method stub
		FileOutputStream out = null;
		try{

			if(contextAdress==null){
				throw new RuntimeException();
			}
			if(contextByte==null){
				throw new RuntimeException();
			}
			File file = new File(contextAdress);
			if(!file.exists()){
				file.createNewFile();
			}
			out = new FileOutputStream(file);
			out.write(contextByte);
		}catch(Exception e){
			throw new RuntimeException();
		}finally{
			try {
				out.close();
			} catch (IOException e) {
				throw new RuntimeException();
			}
		}
	}

}
