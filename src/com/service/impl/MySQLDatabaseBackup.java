package com.service.impl;

import java.io.BufferedReader;  
import java.io.File;  
import java.io.FileOutputStream;  
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;  
import java.io.OutputStreamWriter;  
import java.io.PrintWriter;
import java.rmi.registry.LocateRegistry;

public class MySQLDatabaseBackup {  
	
    public static boolean exportDatabaseTool(String hostIP, String userName, String password, String savePath, String fileName, String databaseName) throws InterruptedException {  
        File saveFile = new File(savePath);  
        if (!saveFile.exists()) {// 如果目录不存在  
            saveFile.mkdirs();// 创建文件夹  
        }  
        if(!savePath.endsWith(File.separator)){  
            savePath = savePath + File.separator;  
        }  
        Process process=null;  
        InputStream is=null;
        InputStreamReader isr=null;
        PrintWriter pw = null;   
        try {
			String filePath=savePath.replaceAll("\\\\", "/")+fileName.replaceAll("\\\\", "/");
        	String cmd="cmd /c mysqldump"+" --column-statistics=0 -h" + hostIP + " -u" + userName + " -p" + password + " "+databaseName+" --set-charset=UTF-8";
            pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filePath), "utf8"));  
            process = Runtime.getRuntime().exec(cmd);  
            is=process.getInputStream();
            isr=new InputStreamReader(is,"utf-8");
            BufferedReader br2=new BufferedReader(isr);
            String line; 
            while((line=br2.readLine())!=null) {
            	pw.println(line);
            }  
            pw.flush();   
            pw.close();
            br2.close();
            isr.close();
            is.close();
            if(process.waitFor()==0&&process!=null){ // 表示线程正常终止
            	process.getOutputStream().close();
                return true;  
            }  

        }catch (IOException e) {  
            e.printStackTrace();  
        } 
        return false;  
    }  
      /*
    public static void main(String[] args){   
        try {
			//if (exportDatabaseTool("rm-wz947lnq4xhk7b1f4so.mysql.rds.aliyuncs.com", "root", "123456789Aa", "D:", "test.sql", "ordermanager")) {  
        	if (MySQLDatabaseBackup.exportDatabaseTool("127.0.0.1", "root", "123456", "E:/hahahaha", "test2.sql",
					"ordermanager")) {
			    System.out.println("Success");  
			} else {  
			    System.out.println("Failure");  
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}  
    } */
}  
