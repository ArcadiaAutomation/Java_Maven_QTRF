package com.qtrf.mobile.application;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.qtrf.core.Environment;

import io.appium.java_client.android.AndroidDriver;

public class MOBILE extends Utility
{
	static int count=-1;
	static Hashtable<String, Integer> udidMap= new Hashtable<String, Integer>();
	static File dir = new File(Environment.getValue("appiumDir"));
    static Hashtable<String, DesiredCapabilities> capabilitiesList = new Hashtable<String, DesiredCapabilities>();
    static Hashtable<String, AndroidDriver> driverList = new Hashtable<String, AndroidDriver>();
    static Hashtable<String, Integer> statusList = new Hashtable<String, Integer>();
    
    public static void initialize()
    {
    	count = -1;
    	udidMap.clear();
    	capabilitiesList.clear();
    	driverList.clear();
    	statusList.clear();
    }
    
    
    public static void actionMapper(ArrayList<String> testStep)
    {
    	switch(testStep.get(3).toUpperCase())
    	{
    	case "CONNECTDEVICE" : connectDevice(getUdid(testStep.get(2)));
    	break;
    	case "CLOSEDEVICE" : closeDevice(getUdid(testStep.get(2)));
    	break;
    	default : System.out.println("Action not found");
    	}
    }
    
	public static void connectDevice(String udid){
		
		if (udidMap.get(udid)==null)
		{
		count=count+1;
		System.out.println("Start appium node number : "+count);
		udidMap.put(udid, count);
	    try {
			Runtime.getRuntime().exec("cmd.exe /c \"start node appium -p "+(4725+count)+" -a 127.0.0.1 --session-override\"",null,dir);
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    capabilitiesList.put(udid, new DesiredCapabilities());
	    capabilitiesList.get(udid).setCapability("deviceName", "any");
		capabilitiesList.get(udid).setCapability("udid", udid);	
		capabilitiesList.get(udid).setCapability("autoLaunch","false");
		capabilitiesList.get(udid).setCapability("appPackage", "any"); 
		capabilitiesList.get(udid).setCapability("appActivity", "any");
		
		statusList.put(udid, 0);
		}
	}
	
	public static void closeDevice(String udid){
		Integer index = udidMap.get(udid);
		driverList.get(udid).quit();
		System.out.println("Close appium session number : "+index);
	}	
		
}
