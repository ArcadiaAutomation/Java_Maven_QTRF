package com.qtrf.core;

import java.io.IOException;
import java.util.ArrayList;

//import com.qtrf.mobile.application.EServiceWeb;
//import com.qtrf.mobile.application.ME_IN_ALLFORONE;
//import com.qtrf.mobile.application.ME_IN_ALLFORONE_ESERVICE;
//import com.qtrf.mobile.application.ME_MOOD;
//import com.qtrf.mobile.application.ME_WIFICONNECT;
import com.qtrf.mobile.application.MOBILE;
//import com.qtrf.mobile.application.OneNumberForPromotion;
//import com.qtrf.mobile.application.Utility;

public class Executor 
{
	public static void run(){	
		for (int i=1;i<TestCase.getTestCase().size();i++)
		{
			System.out.println("Start step : "+i);
			if (!applicationMapping(TestCase.getTestCase().get(i)))
			{
				break;
			}
		}
	}
		
	public static boolean applicationMapping(ArrayList<String> testStep)
	{
		switch(testStep.get(1).toUpperCase())
		{
			case "MOBILE" : MOBILE.actionMapper(testStep);
			break;
	//		case "ME_IN_ALLFORONE" : ME_IN_ALLFORONE.actionMapper(testStep);
	//		break;		
	//		case "ME_IN_ALLFORONE_ESERVICE" : ME_IN_ALLFORONE_ESERVICE.actionMapper(testStep);
	//		break;
	//		case "ME_MOOD" : ME_MOOD.actionMapper(testStep);
	//		break;
	//		case "UTILITY" : Utility.actionMapper(testStep);
	//		break;		
	//		case "ME_WIFICONECT" : ME_WIFICONNECT.actionMapper(testStep);
	//		break;		
	//		case "ESRVICEWEB"	: EServiceWeb.actionMapper(testStep);
	//		break;
	//		case "ONENUMBERFORSERVICE" : OneNumberForPromotion.actionMapper(testStep);
//			break;
			default : System.out.println("Command not found");
			return false;
		}
		return true;
		
	}
	
	public static void report()
	{
		LogManager.closeLog();
		LogManager.generateHTML();	
		try {
			Runtime.getRuntime().exec("cmd.exe /c "+Environment.getValue("LogDir"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
