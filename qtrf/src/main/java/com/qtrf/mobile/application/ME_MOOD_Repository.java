package com.qtrf.mobile.application;

import java.util.Hashtable;

public class ME_MOOD_Repository extends Utility {

	public static Hashtable<String,String> table = new Hashtable<String,String>();
	public static Hashtable<String,String> typeTable = new Hashtable<String,String>();
	public static void ini()
	{
		table.put("package", "com.calea.echo");
		table.put("activity", "com.calea.echo.MainActivity");
		table.put("waitActivity", "any");
		table.put("Sender", "AIS");
		typeTable.put("Sender","text");
		table.put("messageList", "com.calea.echo:id/content");
		typeTable.put("messageList", "id");
		table.put("unread", "//android.widget.TextView[@index='5']");
		typeTable.put("unread", "xpath");
		table.put("verifyMessageSending", "//android.widget.ListView/android.view.View/android.widget.TextView[@index='5']");
		typeTable.put("verifyMessageSending", "xpath");
	}
	
}
