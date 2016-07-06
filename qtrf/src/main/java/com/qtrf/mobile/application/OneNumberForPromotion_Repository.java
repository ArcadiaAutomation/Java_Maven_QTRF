package com.qtrf.mobile.application;

import java.util.Hashtable;

public class OneNumberForPromotion_Repository extends Utility{
	public static Hashtable<String,String> table = new Hashtable<String,String>();
	public static Hashtable<String,String> typeTable = new Hashtable<String,String>();
	public static void ini()
	{
		table.put("Menu", "menu-85");
		typeTable.put("Menu", "id");
	}
	
}
