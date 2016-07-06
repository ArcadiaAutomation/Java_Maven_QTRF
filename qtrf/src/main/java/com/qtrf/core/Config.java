package com.qtrf.core;

import java.util.ArrayList;
import java.util.Hashtable;

public class Config 
{
	
	public static Hashtable<String, String> table= new Hashtable<String, String>();
	
	public static void readConfig(String configPath,String sheetName)
	{
		ArrayList<ArrayList<String>> arr = ExcelManager.getArray(configPath,sheetName);
		for (int i=1;i<arr.size();i++)
		{
			table.put(arr.get(i).get(1), arr.get(i).get(2));
		}
	}
	
	public static Hashtable<String, String> getConfig()
	{
		return table;
	}
}
