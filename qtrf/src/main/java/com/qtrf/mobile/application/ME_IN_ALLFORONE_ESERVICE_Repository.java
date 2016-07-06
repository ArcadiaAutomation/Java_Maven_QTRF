package com.qtrf.mobile.application;

import java.util.Hashtable;

public class ME_IN_ALLFORONE_ESERVICE_Repository extends Utility {
	public static Hashtable<String,String> table = new Hashtable<String,String>();
	public static Hashtable<String,String> typeTable = new Hashtable<String,String>();
	public static void ini()
	{
		table.put("myProfile", "My Profile");
		typeTable.put("myProfile", "text");
		table.put("usageDetailHistory", "Usage Detail History");
		typeTable.put("usageDetailHistory", "text");
		table.put("promotion", "Promotion");
		typeTable.put("promotion", "text");
		 	table.put("currentPromotion", "โ€ข Current Promotion");
		 	typeTable.put("currentPromotion", "text");
		 	table.put("changeMainPackage", "โ€ข Change Main Package");
		 	typeTable.put("changeMainPackage", "text");
		 	 	table.put("verifychangeMainPackage", "Change Main Promotion");
		 	 	typeTable.put("verifychangeMainPackage", "text");
		 	 	table.put("buffet", "Buffet");
		 	 	typeTable.put("buffet", "text");
		 	 	 	table.put("twentyHour", "20-Hours Buffet 69 Baht/Week");
		 	 	 	typeTable.put("twentyHour", "text");	
		 	 	 	table.put("nightTime", "Nighttime Buffet 159 Baht/month");
		 	 	 	typeTable.put("nightTime", "text");	
		 	 	 	table.put("dayTime", "Daytime Buffet 199 Baht/Month");
		 	 	 	typeTable.put("dayTime", "text");	
		 	 	 	table.put("weekly", "Weekly Buffet 55 Baht/Week");
		 	 	 	typeTable.put("weekly", "text");	
		 	 	table.put("callToAllNetwork", "Call to All Networks");
		 	 	typeTable.put("callToAllNetwork", "text");
		 	 	table.put("callToAis", "Call to AIS");
		 	 	typeTable.put("callToAis", "text");		 	 	
		 	table.put("applyOnTopPackage", "โ€ข Apply On-Top Package");
		 	typeTable.put("applyOnTopPackage", "text");
		table.put("topUp", "Top Up");
		typeTable.put("topUp", "text");
		table.put("balance&ValidityTransfer", "Balance & Validity Transfer");
		typeTable.put("balance&ValidityTransfer", "text");
		table.put("faq", "FAQ");
		typeTable.put("faq", "text");
		table.put("applyPackage", "Apply Package");
		typeTable.put("applyPackage", "text");
		table.put("confirmPackage", "OK");
		typeTable.put("confirmPackage", "text");
		table.put("cancelPackage", "Back");
		typeTable.put("cancelPackage", "text");
		table.put("progressBar","Loading");
		typeTable.put("progressBar", "text");
	}
}
