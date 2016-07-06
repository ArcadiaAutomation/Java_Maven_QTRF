package com.qtrf.core;

import java.util.ArrayList;

public class TestCase 
{
	private static ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();
	
	public static void readTestCase(String testCasePath,String sheetName)
	{
		table = ExcelManager.getArray(testCasePath,sheetName);
	}
	
	public static ArrayList<ArrayList<String>> getTestCase()
	{
		return table;
	}
}
