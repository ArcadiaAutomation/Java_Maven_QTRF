package com.qtrf.mobile.application;

import java.util.ArrayList;

import com.qtrf.core.Executor;
import com.qtrf.core.LogManager;

import io.appium.java_client.android.AndroidKeyCode;

public class ME_IN_ALLFORONE_ESERVICE extends ME_IN_ALLFORONE_ESERVICE_Repository{

	static String[] parameter;
	static String udid;
	
    public static void actionMapper(ArrayList<String> testStep)
    {   	
    	parameter = Utility.getParameter(testStep.get(4));
    	udid = getUdid(testStep.get(2));
    	ini();
    	
    	switch(testStep.get(3).toUpperCase())
    	{
    	case "SELECTMENU" : selectMenu(testStep);
    	break;
    	case "SELECTSUBMENU" : selectSubMenu(testStep);
    	break;   	
    	case "COMPONENTISEXIST" : isComponentExist(testStep);
    	break;
    	case "COMPONENTCLICK" : clickComponent(testStep);
    	break;
    	case "WAITUNTIL" : waitUntil(testStep,parameter);
    	break;
    	case "VERIFYMESSAGE" : verifyMessage(testStep);
    	break;
    	default : System.out.println("Action not found");
    	}    	
    }
    
	private static void selectSubMenu(ArrayList<String> testStep)
	{	
		String[] parameter = Utility.getParameter(testStep.get(4));
		try
		{
		if (Utility.isComponentExist(udid, table.get(parameter[0]), typeTable.get(parameter[0]), "false"))	
			{
			 	ArrayList<String> virtualTestStep = new ArrayList<String>();
			 	MOBILE.driverList.get(udid).pressKeyCode(AndroidKeyCode.KEYCODE_BACK);	
	    	 	virtualTestStep=cloneTestStep("ME_IN_ALLFORONE_ESERVICE",testStep.get(2),"selectMenu","Component='"+parameter[2]+"'","","");
	    	 	Executor.applicationMapping(virtualTestStep);	
	    	 	virtualTestStep=cloneTestStep("ME_IN_ALLFORONE_ESERVICE",testStep.get(2),"waitUntil","Option='Exist'|Component='verify"+parameter[2]+"'|sec='20'","","");
	    	 	Executor.applicationMapping(virtualTestStep);	
	    	 	virtualTestStep=cloneTestStep("ME_IN_ALLFORONE_ESERVICE",testStep.get(2),"selectMenu","Component='"+parameter[1]+"'","","");
	    	 	Executor.applicationMapping(virtualTestStep);    	
	    	 	virtualTestStep=cloneTestStep("ME_IN_ALLFORONE_ESERVICE",testStep.get(2),"selectSubMenu",testStep.get(4),"","");
	    	 	Executor.applicationMapping(virtualTestStep);  	    	 	
			}
		else
		 	{
				Utility.clickComponent(udid, table.get(parameter[0]), typeTable.get(parameter[0]));
		 		LogManager.addStep("selectSubMenu : "+parameter[0], "Menu selected", "Menu selected", "pass", "");
		 	}

		}
		catch (Exception e)
		{
			LogManager.addStep("selectSubMenu : "+parameter[0], "Menu selected", e.toString(), "fail", "");	
		}
	}
	
	private static void selectMenu(ArrayList<String> testStep)
	{
		try
		{
		Utility.clickComponent(udid, table.get(parameter[0]), typeTable.get(parameter[0]));
		LogManager.addStep("selectMenu", "Menu selected : "+parameter[0], "Menu selected", "pass", "");
		}
		catch (Exception e)
		{
			LogManager.addStep("selectMenu : "+parameter[0], "Menu selected", e.toString(), "fail", "");	
		}
	}	
	
    private static boolean isComponentExist(ArrayList<String> testStep)
    {
    	
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
    	Utility.clickComponent(udid, table.get(parameter[0]), typeTable.get(parameter[0]));
    }
    
	private static void waitUntil(ArrayList<String> testStep,String[] parameter)
	{
		Utility.waitUntil(parameter, udid, table.get(parameter[1]), typeTable.get(parameter[1]));
	}
	
	private static void verifyMessage(ArrayList<String> testStep)
	{
		String[] parameter = Utility.getParameter(testStep.get(4));
		try
		{
			
    	ArrayList<String> virtualTestStep = new ArrayList<String>();
    	virtualTestStep=cloneTestStep("ME_MOOD",testStep.get(2),"OpenApp","NewOpen='true'","","");
    	Executor.applicationMapping(virtualTestStep);
    	virtualTestStep=cloneTestStep("ME_MOOD",testStep.get(2),"COMPONENTISEXIST","Component='Sender'|Value='true'","","");
    	Executor.applicationMapping(virtualTestStep);
    	virtualTestStep=cloneTestStep("ME_MOOD",testStep.get(2),"VERIFYMESSAGESENDING","","","");
    	Executor.applicationMapping(virtualTestStep);
    	 virtualTestStep=cloneTestStep("ME_MOOD",testStep.get(2),"COMPONENTCLICK","Component='Sender'|Value='true'","","");
    	 Executor.applicationMapping(virtualTestStep);
    	 virtualTestStep=cloneTestStep("ME_MOOD",testStep.get(2),"VERIFYMESSAGE",testStep.get(4),"","");
    	 Executor.applicationMapping(virtualTestStep);   	
    	 virtualTestStep=cloneTestStep("ME_MOOD",testStep.get(2),"CloseApp","NewOpen='true'","","");
    	 Executor.applicationMapping(virtualTestStep);
		}
		catch (Exception e)
		{
			LogManager.addStep("verifyMessage", parameter[1], e.toString(), "fail", "");
		}
	}
    
}
