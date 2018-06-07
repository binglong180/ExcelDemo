package com.niu.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件操作
 * 
 * @author bsr
 * @version 6.0
 * @created 2014-5-5 上午11:47:05
 */
public class FileUtil {
    public static File strToFile(byte[] b, String path)  {  
    	File file = new File(path);  
    	FileOutputStream fis = null;  
    	BufferedOutputStream bos = null;  
    	try {  
    		fis = new FileOutputStream(file);  
    		bos = new BufferedOutputStream(fis);  
    		bos.write(b);  
    	} catch (Exception e) {  
    		e.printStackTrace();  
    	} finally {  
    		if (bos != null) {  
    			try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
    		}  
    
    		if (fis != null) {  
    			try {
    				fis.close();
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}  
    		}
    	}
    	
    	return file;
    }
	
	/**
	 * 创建文件夹
	 * @param path
	 */
	public static void mkDir(String path){
		File file = new File(path);
		if(!file.exists()){
			file.mkdirs();
		}
	}
	/**创建文件*/
	public static File createExcelFile(String name){
		File file=null;
		try {
			file=new File(name);
			if(!file.exists()){
				ExcelUtils.createExcel(file);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return file;
	}
}
