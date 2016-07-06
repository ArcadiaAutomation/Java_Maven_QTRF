package com.qtrf.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.qtrf.mobile.application.Miscellaneous;

public class LogManager extends Miscellaneous
{

	public static ArrayList<String> reportLog = new ArrayList<String>();
	public static long startExecuteTime;
	public static long stopExecuteTime;
	public static void generateLog(String runName,String testScript,String userID)
	{
		startExecuteTime =System.currentTimeMillis();
		reportLog.add("<html>");
		reportLog.add("<head>");
		reportLog.add("<meta http-equiv=\"Content-Language\" content=\"th\">");
		reportLog.add("<meta http-equiv=\"content-Type\" content=\"text/html; charset=window-874\">");
		reportLog.add("<meta http-equiv=\"content-Type\" content=\"text/html; charset=tis-620\">");
		reportLog.add("</head>");
		reportLog.add("<Style>");  
		reportLog.add("body{}");
		reportLog.add("table{width:100%;}"); 
		reportLog.add("table,th,td{border:1px solid black;text-align:center;}");   
		reportLog.add(".title{}");
		reportLog.add(".header{font-weight: bold;}");
		reportLog.add(".pass{color:#008000;}");
		reportLog.add(".fail{color:#FF0000;}");
		reportLog.add("</Style>");
		reportLog.add("<head>");
		reportLog.add("<title>");
		reportLog.add("Report Log");
		reportLog.add("</title>");  
		reportLog.add("</head>");
		reportLog.add("<body>");   
		reportLog.add("<div class=\"title\">");  
		reportLog.add("<table>");  
		reportLog.add("<tr>");     
		reportLog.add("<th>"); 
		reportLog.add("<h1 class>Report log</h1>");
		reportLog.add("</th>");  
		reportLog.add("</tr>"); 
		reportLog.add("</table>"); 
		reportLog.add("</div>"); 
		reportLog.add("<div class=\"header\">");
		reportLog.add("<table>");    
		reportLog.add("<tr>");     
		reportLog.add("<th>");		     
		reportLog.add("<p>เธชเธงเธฑเธชเธ”เธตเธ�เธฒเธงเน�เธฅเธ� : "+runName+"</p>");  
		reportLog.add("<p>Test Script : "+testScript+"</p>");
		reportLog.add("<p>User Id : "+userID+"</p>");
		reportLog.add("<p>Execution Start Time : "+getCurrentTimeDate()+"</p>");
		reportLog.add("</th>");
		reportLog.add("</tr>"); 
		reportLog.add("</table>");
		reportLog.add("</div>");
		reportLog.add("<div class=\"content\">");
		reportLog.add("<table>");    
		reportLog.add("<tr>");     
		reportLog.add("<th width=\"9%\">Time</th>");
		reportLog.add("<th width=\"18%\">Action</th>");
		reportLog.add("<th width=\"27%\">Expected</th>");
		reportLog.add("<th width=\"27%\">Actual</th>");
		reportLog.add("<th width=\"10%\">Result</th>");
		reportLog.add("<th width=\"9%\">CaptureScreen</th>");
		reportLog.add("</tr>");
	}
	
	public static void addStep(String action,String expected,String actual,String result,String captureScreen)
	{
		reportLog.add("<tr class=\""+result+"\">");     
		reportLog.add("<th>"+getCurrentTime()+"</th>");
		reportLog.add("<th>"+action+"</th>");
		reportLog.add("<th>"+expected+"</th>");
		reportLog.add("<th>"+actual+"</th>");
		reportLog.add("<th>"+result+"</th>");
		reportLog.add("<th>"+captureScreen+"</th>");
		reportLog.add("</tr>");
	}
	
	public static void closeLog()
	{
		stopExecuteTime =System.currentTimeMillis();
		
		double runtime = (stopExecuteTime - startExecuteTime)/1000.0;
		int minute = (int) Math.floor(runtime/60.0);
		int second = Math.floorMod((int)runtime, 60);
		
		reportLog.add("<div class=\"header\">");
		reportLog.add("</table>");
		reportLog.add("<table>");
		reportLog.add("<tr>");
		reportLog.add("<th>");
		reportLog.add("Execute time : "+minute+" minute "+second+" second");
		reportLog.add("</thh>");
		reportLog.add("</tr>");
		reportLog.add("</table>");
		reportLog.add("</div>");
		
		
		reportLog.add("</div>");
		reportLog.add("</body>");
		reportLog.add("</html>");	
	}
	
	public static void generateHTML()
	{
		File file = new File(Environment.getValue("LogDir"));
		FileWriter writer = null;
		try {
			writer = new FileWriter(file.getAbsoluteFile());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		BufferedWriter buffer = new BufferedWriter(writer);
		
		for (int i=0;i<reportLog.size();i++)
		{
		try {
			buffer.append(reportLog.get(i));
			buffer.append(System.lineSeparator());
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		try {
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
