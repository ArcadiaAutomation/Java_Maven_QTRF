package com.qtrf.mobile.application;

import java.util.ArrayList;

import org.openqa.selenium.By;

import com.qtrf.core.Config;
import com.qtrf.core.Executor;
import com.qtrf.core.LogManager;

import io.appium.java_client.android.AndroidKeyCode;

public class ME_IN_ALLFORONE extends ME_IN_ALLFORONE_Repository {

	static String udid;

    public static void actionMapper(ArrayList<String> testStep)
    {
    	udid = getUdid(testStep.get(2));
    	ini();
    	
    	switch(testStep.get(3).toUpperCase())
    	{
    	case "OPENAPP" : 
    		try {
    			openApp(testStep,table.get("package"),table.get("activity"),table.get("waitActivity"));
    			LogManager.addStep("openApp", "Switch application", "Switch application", "pass", "");
    		} catch (Exception e) {
    			LogManager.addStep("openApp", "Switch application", e.toString(), "fail", "");	
    		}
    	break;
    	case "OPENSUBAPP" : openSubApp(testStep);
    	break;
    	case "COMPONENTISEXIST" : isComponentExist(testStep);
    	break;
    	case "COMPONENTCLICK" : clickComponent(testStep);
    	break;
    	case "SETTEXT" : setText(testStep);
    	break;
    	case "SETOTP" : setOTP(testStep);
    	break;
    	case "WAITUNTIL" : waitUntil(testStep);
    	break;
    	case "BACK" : MOBILE.driverList.get(udid).pressKeyCode(AndroidKeyCode.KEYCODE_BACK);
    	break;
    	case "CLOSEAPP" : closeApp();
    	break;
    	default : System.out.println("Action not found");
    	}
    }
    
    private static boolean isComponentExist(ArrayList<String> testStep)
    {
    	String udid = getUdid(testStep.get(2));
    	String[] parameter = Utility.getParameter(testStep.get(4));
    	
    	try
    	{
    	if(Utility.isComponentExist(udid, table.get(parameter[0]), typeTable.get(parameter[0]), parameter[1]))
    	{
    		System.out.println("Verify component : true");
    		LogManager.addStep("ComponentIsExist", "Verify component : true", "Verify component : true", "pass", "");
    		return true;
    	}
    	else
    	{
    		
    		System.out.println("Verify component : false");
    		LogManager.addStep("ComponentIsExist", "Verify component : true", "Verify component : false", "fail", "");
    		return false;
    	}
    	}
    	catch (Exception e)
    	{
    		LogManager.addStep("ComponentIsExist", "Verify component : true", e.toString(), "fail", "");
    		return false;
    	}
    }

    private static void clickComponent(ArrayList<String> testStep)
    {
    	String udid = getUdid(testStep.get(2));
    	String[] parameter = Utility.getParameter(testStep.get(4));
    	
    	Utility.clickComponent(udid, table.get(parameter[0]), typeTable.get(parameter[0]));
    }

    private static void setText(ArrayList<String> testStep)
    {
    	String udid = getUdid(testStep.get(2));
    	String[] parameter = Utility.getParameter(testStep.get(4));
    	
    	Utility.setText(udid, table.get(parameter[0]), typeTable.get(parameter[0]), parameter[1]);
    }
    
    private static void setOTP(ArrayList<String> testStep)
    {
    	String udid = getUdid(testStep.get(2));
    	String[] parameter = Utility.getParameter(testStep.get(4));
    	
    	Utility.setText(udid, table.get(parameter[0]), typeTable.get(parameter[0]), ME_MOOD.otpNumber);
    }
    
    private static void openSubApp(ArrayList<String> testStep)
    {
    	String udid = getUdid(testStep.get(2));
    	String[] parameter = Utility.getParameter(testStep.get(4));
    	
    	try
    	{
    		switch (parameter[0].toUpperCase())
    		{
    			case "ESERVICE":eService(testStep);
    			break;
    			default:System.out.println("Sub application not found");
    		}
    		LogManager.addStep("openSubApp", "Open sub application", "Open sub application", "pass", "");
    	}
    	catch (Exception e)
    	{
    		LogManager.addStep("openSubApp", "Open sub application", e.toString(), "fail", "");	
    	}
    }
    
    private static void eService(ArrayList<String> testStep)
    {
    	String udid = getUdid(testStep.get(2));
    	String[] parameter = Utility.getParameter(testStep.get(4));
    	
    	ArrayList<String> virtualTestStep = new ArrayList<String>();
    	String mobileNumber = Config.getConfig().get("adb:RUN_"+testStep.get(2).charAt(testStep.get(2).length()-1)+"_Number");
    	virtualTestStep=cloneTestStep("ME_IN_ALLFORONE",testStep.get(2),"COMPONENTCLICK","Component='eService'|Value='true'","","");
    	Executor.applicationMapping(virtualTestStep);   
    	virtualTestStep=cloneTestStep("ME_IN_ALLFORONE",testStep.get(2),"waitUntil","Option='Exist'|ComponentName='mobileNumber'|sec='59'","","");
    	Executor.applicationMapping(virtualTestStep);    
    	virtualTestStep=cloneTestStep("ME_IN_ALLFORONE",testStep.get(2),"SetText","Component='mobileNumber'|Value='"+mobileNumber+"'","","");
    	Executor.applicationMapping(virtualTestStep);
    	virtualTestStep=cloneTestStep("ME_IN_ALLFORONE",testStep.get(2),"COMPONENTCLICK","Component='sentOTP'","","");
    	Executor.applicationMapping(virtualTestStep);
    	virtualTestStep=cloneTestStep("ME_IN_ALLFORONE",testStep.get(2),"waitUntil","Option='Exist'|ComponentName='otpNumber'|sec='59'","","");
    	Executor.applicationMapping(virtualTestStep);    			
    	virtualTestStep=cloneTestStep("ME_MOOD",testStep.get(2),"OpenApp","NewOpen='true'","","");
    	Executor.applicationMapping(virtualTestStep);
    	virtualTestStep=cloneTestStep("ME_MOOD",testStep.get(2),"COMPONENTISEXIST","Component='Sender'|Value='true'","","");
    	Executor.applicationMapping(virtualTestStep);
    	virtualTestStep=cloneTestStep("ME_MOOD",testStep.get(2),"VERIFYMESSAGESENDING","","","");
    	Executor.applicationMapping(virtualTestStep);
    	virtualTestStep=cloneTestStep("ME_MOOD",testStep.get(2),"COMPONENTCLICK","Component='Sender'|Value='true'","","");
    	Executor.applicationMapping(virtualTestStep);
    	virtualTestStep=cloneTestStep("ME_MOOD",testStep.get(2),"GETOTP","index='1'","","");
    	Executor.applicationMapping(virtualTestStep);
    	virtualTestStep=cloneTestStep("ME_MOOD",testStep.get(2),"CloseApp","NewOpen='true'","","");
    	Executor.applicationMapping(virtualTestStep);
    	virtualTestStep=cloneTestStep("ME_IN_ALLFORONE",testStep.get(2),"SetOTP","Component='otpNumber'","","");
    	Executor.applicationMapping(virtualTestStep);
    	virtualTestStep=cloneTestStep("ME_IN_ALLFORONE",testStep.get(2),"COMPONENTCLICK","Component='submitOTP'","","");
    	Executor.applicationMapping(virtualTestStep);  
    	virtualTestStep=cloneTestStep("ME_IN_ALLFORONE",testStep.get(2),"waitUntil","Option='Exist'|ComponentName='innerEService'|sec='59'","","");
    	Executor.applicationMapping(virtualTestStep);
    }
    
	private static void waitUntil(ArrayList<String> testStep)
	{
		String udid = getUdid(testStep.get(2));
		String[] parameter = Utility.getParameter(testStep.get(4));
		
		Utility.waitUntil(parameter, udid, table.get(parameter[1]), typeTable.get(parameter[1]));
	}
    
    private static void closeApp()
    {
    	MOBILE.driverList.get(udid).pressKeyCode(AndroidKeyCode.KEYCODE_BACK);
    	MOBILE.driverList.get(udid).findElement(By.name("Yes")).click();
    }
}
