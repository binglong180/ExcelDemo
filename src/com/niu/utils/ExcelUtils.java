package com.niu.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelUtils {
	    // 总行数
	    private static int totalRows = 0;
	    // 总条数
	    private static int totalCells = 0;
	    // 错误信息接收器
	    private static String errorMsg;


	    // 获取总行数
	    public int getTotalRows() {
	        return totalRows;
	    }

	    // 获取总列数
	    public int getTotalCells() {
	        return totalCells;
	    }

	    // 获取错误信息
	    public String getErrorInfo() {
	        return errorMsg;
	    }

	    /**
	     * 读EXCEL文件，获取信息集合
	     * 
	     * @param fielName
	     * @return
	     * @throws FileNotFoundException 
	     */
	    public static List<Row> importExcel(File  file) throws Exception {
	    	String fileName = file.getName();// 获取文件名
	        //List<Map<String, Object>> userList = new LinkedList<Map<String, Object>>();
	        if (!validateExcel(fileName)) {// 验证文件名是否合格
	                return null;
	        }
	        boolean isExcel2003 = true;// 根据文件名判断文件是2003版本还是2007版本
	        if (isExcel2007(fileName)) {
	                isExcel2003 = false;
	        }
	        return createExcel(new FileInputStream(file), isExcel2003);
	    }
	    /**
	     * 根据excel里面的内容读取客户信息
	     * 
	     * @param is      输入流
	     * @param isExcel2003   excel是2003还是2007版本
	     * @return
	     * @throws IOException
	     */
	    public static List<Row> createExcel(InputStream is, boolean isExcel2003) throws IOException {
	            Workbook wb = null;
	            if (isExcel2003) {// 当excel是2003时,创建excel2003
	                wb = new HSSFWorkbook(is);
	            } else {// 当excel是2007时,创建excel2007
	                wb = new XSSFWorkbook(is);
	            }
	            return readExcelValue(wb);// 读取Excel里面客户的信息
	    }

	    /**
	     * 读取Excel里面客户的信息
	     * 
	     * @param wb
	     * @return
	     */
	   private static List<Row> readExcelValue(Workbook wb) {
		   int totalSheets = wb.getNumberOfSheets();
		   List<Row> list = new ArrayList<Row>();
		   if(totalSheets>0){
			   for(int i=0;i<totalSheets;i++){
				    org.apache.poi.ss.usermodel.Sheet sheet =  wb.getSheetAt(i);
				    // 得到Excel的行数
			        totalRows = sheet.getPhysicalNumberOfRows();
			        // 得到Excel的列数(前提是有行数)
			        if (totalRows > 1 && sheet.getRow(0) != null) {
			            totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
			        }
			        // 循环Excel行数
			        for (int r = 0; r < totalRows; r++) {
			            Row row = sheet.getRow(r);
			            if (row == null) {
			                continue;
			            }
			            list.add(row);
			        }
			   }
		   }
		   try {
			   if(wb!=null){
				   wb.close();
			   }
		   } catch (IOException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		  }
	       return list;
	    }
	    /**
	     * 验证EXCEL文件
	     * 
	     * @param filePath
	     * @return
	     */
	   public static boolean validateExcel(String filePath) {
	        if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))) {
	            errorMsg = "文件名不是excel格式";
	            return false;
	        }
	        return true;
	    }

	    // @描述：是否是2003的excel，返回true是2003
	    public static boolean isExcel2003(String filePath) {
	        return filePath.matches("^.+\\.(?i)(xls)$");
	    }

	    // @描述：是否是2007的excel，返回true是2007
	    public static boolean isExcel2007(String filePath) {
	        return filePath.matches("^.+\\.(?i)(xlsx)$");
	    } 
	    
	    public static void createExcel(File file) throws IOException{
	    	 HSSFWorkbook workbook = new HSSFWorkbook();
	    	 OutputStream os=new FileOutputStream(file);
		     workbook.write(os);
		     os.flush();
		     os.close();
		     workbook.close();
	    }
	    public static void main(String[] args) {
			System.out.println("1111");
		}
}
