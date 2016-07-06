package com.qtrf.mobile.application;

import java.util.Hashtable;

public class ME_IN_ALLFORONE_Repository extends Utility {

	public static Hashtable<String,String> table = new Hashtable<String,String>();
	public static Hashtable<String,String> typeTable = new Hashtable<String,String>();
	public static void ini()
	{
		table.put("package", "com.ais.mimo.eservice");
		table.put("activity", "com.nextzy.allforone.view.DummyActivity");
		table.put("waitActivity", "com.nextzy.allforone.view.menu.MenuActivity");
		table.put("eService", "//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[@index='0']");
		typeTable.put("eService", "xpath");
		table.put("4G", "//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[@index='1']");
		typeTable.put("4G", "xpath");
		table.put("fibre", "//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[@index='2']");
		typeTable.put("fibre", "xpath");
		table.put("previlege", "//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[@index='3']");
		typeTable.put("previlege", "xpath");
		table.put("roaming", "//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[@index='4']");
		typeTable.put("roaming", "xpath");
		table.put("superCombo", "//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[@index='5']");
		typeTable.put("superCombo", "xpath");
		table.put("Home", "//android.widget.TextView[contains(@resource-id,'com.ais.mimo.eservice:id/tv_menu_level_one') and @text='Home']");
		typeTable.put("Home", "xpath");
		table.put("Store", "//android.widget.TextView[contains(@resource-id,'com.ais.mimo.eservice:id/tv_menu_level_one') and @text='Store']");
		typeTable.put("Store", "xpath");
		table.put("Site", "//android.widget.TextView[contains(@resource-id,'com.ais.mimo.eservice:id/tv_menu_level_one') and @text='Site']");
		typeTable.put("Site", "xpath");
		table.put("Settings", "//android.widget.TextView[contains(@resource-id,'com.ais.mimo.eservice:id/tv_menu_level_one') and @text='Settings']");
		typeTable.put("Settings", "xpath");
		table.put("mobileNumber","com.ais.mimo.eservice:id/edt_mobile_number");
		typeTable.put("mobileNumber", "id");
		table.put("sentOTP", "com.ais.mimo.eservice:id/btn_submit_mobile_number");
		typeTable.put("sentOTP", "id");
		table.put("otpNumber","com.ais.mimo.eservice:id/edt_otp_number");
		typeTable.put("otpNumber", "id");
		table.put("submitOTP","com.ais.mimo.eservice:id/btn_submit_password");
		typeTable.put("submitOTP", "id");
		table.put("verifyEservice","eService");
		typeTable.put("verifyEservice", "text");	
		table.put("progressBar","Loading");
		typeTable.put("progressBar", "text");	
		table.put("innerEService","eService");
		typeTable.put("innerEService", "text");
		table.put("innerMyProfile","My Profile");
		typeTable.put("innerMyProfile", "text");
	}
	
}