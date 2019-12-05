package com.daxv.common.BatchExcel;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import net.bytebuddy.asm.Advice.This;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WorkbookUtils {
	public   SXSSFWorkbook workbook;
	 
	public WorkbookUtils() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WorkbookUtils(String filePath) {
		super();
		// TODO Auto-generated constructor stub
		workbook=new SXSSFWorkbook(getXSSFWorkbook(filePath),100);
	}
	 
    /**
     * 创建 XSSFWorkbook
     * @param filePath
     * @return
     */
	public   XSSFWorkbook getXSSFWorkbook(String filePath) {
		XSSFWorkbook workbook =  null;
		
		BufferedInputStream inputStream = null;
		try {
			File fileXlsxPath = new File(filePath);
			inputStream = new BufferedInputStream(new FileInputStream(fileXlsxPath));
			workbook = new XSSFWorkbook(inputStream); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(inputStream!=null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return workbook;
	}
	 
	/**
	 * XSSFWorkbook对象
	 * @param filePath
	 * @return
	 */
	public static XSSFWorkbook getXSSFWorkbookByOut(String filePath) {
		XSSFWorkbook workbook =  null;
		BufferedOutputStream outputStream = null;
		try {
			File fileXlsxPath = new File(filePath);
			outputStream = new BufferedOutputStream(new FileOutputStream(fileXlsxPath));
			workbook = new XSSFWorkbook();
			workbook.createSheet("测试Sheet");
			workbook.write(outputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(outputStream!=null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return workbook;
	}
  

	public SXSSFWorkbook getWorkbook() {
		return workbook;
	}

	public void setWorkbook(SXSSFWorkbook workbook) {
		this.workbook = workbook;
	}

}
