package com.qtrf.mobile.application;

import java.util.ArrayList;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidKeyCode;

public class ME_WIFICONNECT extends ME_WIFICONNECT_Repository{

	static String[] parameter;
	static String udid;	
	
    public static void actionMapper(ArrayList<String> testStep)
    {
    	parameter = Utility.getParameter(testStep.get(4));
    	udid = getUdid(testStep.get(2));    	
    	ME_WIFICONNECT_Repository.ini();
    	
    	switch(testStep.get(3).toUpperCase())
    	{
    	case "OPENAPP" : openApp(testStep,table.get("package"),table.get("activity"),table.get("waitActivity"));
    	break;
    	case "SETENABLEWIFI" : 
    		if (!isWifiOpen())
    		MOBILE.driverList.get(udid).findElement(By.id(table.get("wifiToggle"))).click();
    	break;
    	case "WAITUNTIL" : ;System.out.println("Wait until : "+waitUntil(testStep));
    	break;
    	case "VERIFYWIFI" : System.out.println("verify wifi : "+verifyWifi());
    	break;
    	case "SETDISABLEWIFI" : 
    		if (isWifiOpen())
    		MOBILE.driverList.get(udid).findElement(By.id(table.get("wifiToggle"))).click();
    	break;
    	case "CLOSEAPP" : MOBILE.driverList.get(udid).pressKeyCode(AndroidKeyCode.KEYCODE_BACK);
    	break;
    	default : System.out.println("Action not found");
    	}    			
    }
	
	private static boolean waitUntil(ArrayList<String> testStep)
	{
		String udid = getUdid(testStep.get(2));
		String[] parameter = Utility.getParameter(testStep.get(4));
		
		return Utility.waitUntil(parameter, udid, table.get(parameter[1]), typeTable.get(parameter[1]));
	}
	
	
	public static boolean isWifiOpen()
	{
		return MOBILE.driverList.get(udid).findElement(By.id(table.get("wifiToggle"))).getAttribute("checked").equals("true");
	}
	
	
	public static boolean verifyWifi()
	{
			if (parameter[0].toUpperCase().equals("ENABLE"))
			{
				return isWifiOpen();
			}
			else
			{
				return !isWifiOpen();
			}
	}
}