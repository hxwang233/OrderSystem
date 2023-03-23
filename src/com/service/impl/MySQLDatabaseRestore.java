package com.service.impl;


import java.io.File;
import java.io.IOException;


public class MySQLDatabaseRestore {
		
	public static boolean importDatabaseTool(String hostIP, String userName, String password, String savePath, String fileName, String databaseName) throws InterruptedException {
        if(!savePath.endsWith(File.separator)){  
            savePath = savePath + File.separator;  
        }  
		File f = new File(savePath+fileName);  
        if (!f.exists()) {// 如果文件不存在  
        	return false;
        } 
		Process process=null;
		try {
			String filePath=savePath.replaceAll("\\\\", "/")+fileName.replaceAll("\\\\", "/");
        	String cmd="cmd /c mysql -h" + hostIP  + " -u" + userName + " -p" + password +" --default-character-set=utf8 "+databaseName+"<"+filePath;
        	process = Runtime.getRuntime().exec(cmd);    
			if(process != null){
				process.getOutputStream().close();
			}
	        return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;   
	}
	/*
	public static void main(String[] args){   
		try {
			//if (importDatabaseTool("rm-wz947lnq4xhk7b1f4so.mysql.rds.aliyuncs.com", "root", "123456789Aa", "E:/hahahaha", "test2.sql", "ordermanager")) {
			if (importDatabaseTool("127.0.0.1", "root", "123456", "E:/hahahaha", "test2.sql", "ordermanager")) {  
			    System.out.println("Success");  
			} else {  
			    System.out.println("Failure");  
			}
	     } catch (Exception e) {
	         e.printStackTrace();
	         
	     }	 
    }*/
}
