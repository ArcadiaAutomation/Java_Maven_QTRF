package com.qtrf.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelManager 
{
	
	public static ArrayList<ArrayList<String>> getArray(String path,String sheetName)
	{
		FileInputStream file = null;
		XSSFWorkbook workbook = null;
		
		try {
			file = new FileInputStream(new File(path));
			LogManager.addStep("Read file : "+path, "File exist", "File exist", "pass", "");
			LogManager.generateHTML();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			LogManager.addStep("Read file : "+path, "File exist", e.toString(), "fail", "");
		}
		
		try {
			workbook = new XSSFWorkbook(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		XSSFSheet sheet = workbook.getSheetAt(getSheetIndex(workbook,sheetName));		
		ArrayList<ArrayList<String>> data = readTestCase(sheet);
		
		return data;
	}
	
	public static int getSheetIndex(XSSFWorkbook workbook,String name)
	{
		int count = -1;
		Iterator<Sheet> sheetIterator = workbook.iterator();
		for (Iterator<Sheet> i = sheetIterator; i.hasNext(); )
		{
			count = count+1;
			Sheet item = i.next();
			if (name.equals(item.getSheetName()))
			{
				return count;
			}
		}
		System.out.println("Sheet \""+name+"\" not found");
		return -1;
	}
	
	public static int numRow(Iterator<Row> i)
	{
		int count = 0;
		for (Iterator<Row> j = i;j.hasNext();)
		{
			j.next();
			count =count+1;
		}
		return count;
	}
	
	public static int numCell(Iterator<Cell> i)
	{
		int count = 0;
		for (Iterator<Cell> j = i;j.hasNext();)
		{
			j.next();
			count =count+1;
		}
		return count;
	}	
	
	public static ArrayList<ArrayList<String>> readTestCase(XSSFSheet sheet)
	{
		ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
		for (Iterator<Row> i = sheet.iterator();i.hasNext();)
		{
			Row item = i.next();			
			
			ArrayList<String> row = new ArrayList<String>();
			
			for (Iterator<Cell> j = item.iterator();j.hasNext();)
			{
				Cell item2 = j.next();
				row.add(item2.toString());
			}
			data.add(row);
		}
		return data;
	}
	
	public static boolean isSheetExist(String path,String sheetName)
	{
		FileInputStream file = null;
		XSSFWorkbook workbook = null;
		
		try {
			file = new FileInputStream(new File(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			workbook = new XSSFWorkbook(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (getSheetIndex(workbook,sheetName)==-1)
		{
		return false;
		}
		else
		{
		return true;
		}
	}

}
