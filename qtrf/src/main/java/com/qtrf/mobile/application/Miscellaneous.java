package com.qtrf.mobile.application;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Miscellaneous 
{
	public static void wait(int second)
	{
		 try {
			  	System.out.println("wait for "+second+" second");
			  	for (int i=1;i<=second;i++)
			  	{
				Thread.sleep(1000);
				//System.out.println("Wait for "+(second-i)+" second");
			  	}
				
			 } catch (InterruptedException e) {
				e.printStackTrace();
			 }
	}
	
	public static String getCurrentTimeDate()
	{
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date timeDate = new Date();	
		return dateFormat.format(timeDate);
	}
	
	public static String getCurrentTime()
	{
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.SSS");
		Date timeDate = new Date();	
		return dateFormat.format(timeDate);
	}
	
	public static String getCurrentMilSec()
	{
		DateFormat dateFormat = new SimpleDateFormat("SSS");
		Date timeDate = new Date();	
		return dateFormat.format(timeDate);
	}
	
	public static String getCurrentSec()
	{
		DateFormat dateFormat = new SimpleDateFormat("ss");
		Date timeDate = new Date();	
		return dateFormat.format(timeDate);
	}
	
	public static String getCurrentMin()
	{
		DateFormat dateFormat = new SimpleDateFormat("mm");
		Date timeDate = new Date();	
		return dateFormat.format(timeDate);
	}
	
	public static String getCurrentHour()
	{
		DateFormat dateFormat = new SimpleDateFormat("HH");
		Date timeDate = new Date();	
		return dateFormat.format(timeDate);
	}
}
