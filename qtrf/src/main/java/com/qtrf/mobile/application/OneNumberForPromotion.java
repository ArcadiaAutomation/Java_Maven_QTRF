package com.qtrf.mobile.application;

import java.util.ArrayList;

import com.qtrf.core.LogManager;

public class OneNumberForPromotion extends OneNumberForPromotion_Repository {
	static String[] parameter;
	static String udid;
	WebCommon webCommon = new WebCommon();

    public static void actionMapper(ArrayList<String> testStep)
    {
    	parameter = Utility.getParameter(testStep.get(4));
    	OneNumberForPromotion_Repository.ini();
    	String Action = testStep.get(3);
    	switch(Action.toUpperCase())
    	{
    	case "SELECTSUBMENU" : 
    		SelectSubMenu(parameter[0]);
    		break;
    	default : WebCommon.actionMapper(testStep);
    	}
    }
    public static void Setup(){
    	OneNumberForPromotion_Repository.ini();
    	WebCommon.ClickElement(OneNumberForPromotion_Repository.typeTable.get("Menu"),OneNumberForPromotion_Repository.table.get("Menu"));
    }
    
    public static void SelectSubMenu(String SubMenu){
       	switch(SubMenu.toUpperCase())
    	{
    	case "YOURCURRENTPACKAGE" : 
    		WebCommon.ClickElement("id","menu-83");
    		LogManager.addStep("SelectSubMenu",SubMenu,"","pass","");
    		break;
    	case "CHANGEMAINPACKAGE" :
    		WebCommon.ClickElement("id","menu-135");
    		LogManager.addStep("SelectSubMenu",SubMenu,"","pass","");
    		break;
    	case "APPLYONTOPPACKAGE" :
    		WebCommon.ClickElement("id","menu-136");
    		LogManager.addStep("SelectSubMenu",SubMenu,"","pass","");
    		break;
    	case "CANCLEONTOPPACKAGE" :
    		WebCommon.ClickElement("id","menu-108");
    		LogManager.addStep("SelectSubMenu",SubMenu,"","pass","");
    		break;
    	default : LogManager.addStep("SelectSubMenu","cannot found submenu : "+SubMenu,"","fail","");
    	}
    }
}