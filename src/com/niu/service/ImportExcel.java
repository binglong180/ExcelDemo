package com.niu.service;

import java.io.File;

import com.niu.utils.ExcelUtils;
import com.niu.utils.FileUtil;

public class ImportExcel {
	public void importExcel(String path) throws Exception{
		FileUtil.mkDir(path);
		File file = FileUtil.createExcelFile(path);
		ExcelUtils.importExcel(file);
	}
}
