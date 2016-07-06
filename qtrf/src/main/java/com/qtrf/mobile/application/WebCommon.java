package com.qtrf.mobile.application;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.qtrf.core.LogManager;

public class WebCommon {
	
	static String[] parameter;
	static WebDriver driver;
    public static void actionMapper(ArrayList<String> testStep)
    {
    	parameter = Utility.getParameter(testStep.get(4));
    	EServiceWeb_Repository.ini();
    	String Action = testStep.get(3);
    	switch(Action.toUpperCase())
    	{
    	case "OPENBROWSER" :
    		OpenBrowser(parameter[0],parameter[1]);
    		break;
    	case "CLOSEBROWSER" :
    		CloseBrowser();
    		break;
    	case "SETTEXT" : 
    		setText(parameter[0],parameter[1],parameter[2]); //setText(type,value,text); 
    		break;
    	case "CLICKELEMENT" :
    		ClickElement(parameter[0],parameter[1]);
    		break;
    	case "CHECKELEMENT" :
    		CheckElement(parameter[0],parameter[1]);
    		break;
    	case "SELECTDROPDOWN" :
    		SelectDropDown(parameter[0],parameter[1],parameter[2]);
    		break;
    	case "ISEXISTS" :
    		if (elementIsExists(parameter[0],parameter[1])){
    			
    		}
    		else {
    			
    		}
    		break;
    	default : System.out.println("Action not found");
    	}
    }
    
    public static void setText(String type ,String value, String text) {
		// TODO Auto-generated method stub
    	switch(type.toUpperCase()) {
    	case "ID" : 
    		driver.findElement(By.id(value)).sendKeys(text);
    		break;
    	case "NAME" : 
    		driver.findElement(By.name(value)).sendKeys(text);
    		break;
    	case "LINK TEXT" : 
    		driver.findElement(By.linkText(value)).sendKeys(text);
    		break;
    	case "TAG NAME" : 
    		driver.findElement(By.tagName(value)).sendKeys(text);
    		break;
    	case "CLASS" : 
    		driver.findElement(By.className(value)).sendKeys(text);
    		break;
    	case "CSS" : 
    		driver.findElement(By.cssSelector(value)).sendKeys(text);
    		break;
    	case "XPATH" : 
    		driver.findElement(By.xpath(value)).sendKeys(text);
			break;
    	default : System.out.println("Action not found");
    	}
	}
    public static void ClickElement(String type, String value) {
		// TODO Auto-generated method stub
    	switch(type.toUpperCase()) {
    	case "ID" : 
    		driver.findElement(By.id(value)).click();
    		break;
    	case "NAME" : 
    		driver.findElement(By.name(value)).click();
    		break;
    	case "LINK TEXT" : 
    		driver.findElement(By.linkText(value)).click();
    		break;
    	case "TAG NAME" : 
    		driver.findElement(By.tagName(value)).click();
    		break;
    	case "CLASS" : 
    		driver.findElement(By.className(value)).click();
    		break;
    	case "CSS" : 
    		driver.findElement(By.cssSelector(value)).click();
    		break;
    	case "XPATH" : 
    		driver.findElement(By.xpath(value)).click();
			break;
    	default : System.out.println("Action not found");
    	}
	}
    public static String getText(String type, String value) {
		// TODO Auto-generated method stub
    	switch(type.toUpperCase()) {
    	case "ID" : 
    		return driver.findElement(By.id(value)).getText();
    	case "NAME" : 
    		return driver.findElement(By.name(value)).getText();
    	case "LINK TEXT" : 
    		return driver.findElement(By.linkText(value)).getText();
    	case "TAG NAME" : 
    		return driver.findElement(By.tagName(value)).getText();
    	case "CLASS" : 
    		return driver.findElement(By.className(value)).getText();
    	case "CSS" : 
    		return driver.findElement(By.cssSelector(value)).getText();
    	case "XPATH" : 
    		return driver.findElement(By.xpath(value)).getText();
    	default : System.out.println("Action not found");
    		return "";
    	}
	}
	public static void OpenBrowser(String Url, String Type) {
		// TODO Auto-generated method stub
		  System.setProperty("webdriver.chrome.driver", "C:\\workspace\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.get("https://"+Url);
		  driver.manage().window().maximize();
	}
	public static void CloseBrowser() {
		  driver.quit();
		  LogManager.addStep("CloseBrowser","","","pass","");
	}
	public static void SelectDropDown(String type, String value, String text) {
		Select dropdown ;
    	switch(type.toUpperCase()) {
    	case "ID" : 
    		dropdown = new Select(driver.findElement(By.id(value)));
    		dropdown.selectByVisibleText(text);
    		break;
    	case "NAME" : 
    		dropdown = new Select(driver.findElement(By.name(value)));
    		dropdown.selectByVisibleText(text);
    		break;
    	case "LINK TEXT" : 
    		dropdown = new Select(driver.findElement(By.linkText(value)));
    		dropdown.selectByVisibleText(text);
    		break;
    	case "TAG NAME" : 
    		dropdown = new Select(driver.findElement(By.tagName(value)));
    		dropdown.selectByVisibleText(text);
    		break;
    	case "CLASS" : 
    		dropdown = new Select(driver.findElement(By.className(value)));
    		dropdown.selectByVisibleText(text);
    		break;
    	case "CSS" : 
    		dropdown = new Select(driver.findElement(By.cssSelector(value)));
    		dropdown.selectByVisibleText(text);
    		break;
    	case "XPATH" : 
    		dropdown = new Select(driver.findElement(By.xpath(value)));
    		dropdown.selectByVisibleText(text);
    		break;
    	default : System.out.println("Action not found");
    	}
	}
    public static void CheckElement(String type, String value) {
		// TODO Auto-generated method stub
    	switch(type.toUpperCase()) {
    	case "ID" : 
    		List<WebElement> elements = driver.findElements(By.id(value));
    		elements.get(0).click();
    		break;
    	case "NAME" : 
    		driver.findElement(By.name(value)).click();
    		break;
    	case "LINK TEXT" : 
    		driver.findElement(By.linkText(value)).click();
    		break;
    	case "TAG NAME" : 
    		driver.findElement(By.tagName(value)).click();
    		break;
    	case "CLASS" : 
    		driver.findElement(By.className(value)).click();
    		break;
    	case "CSS" : 
    		driver.findElement(By.cssSelector(value)).click();
    		break;
    	case "XPATH" : 
    		driver.findElement(By.xpath(value)).click();
			break;
    	default : System.out.println("Action not found");
    	}
	}
    public static boolean elementIsExists(String type, String value) {
		// TODO Auto-generated method stub
    	switch(type.toUpperCase()) {
    	case "ID" : 
    		return driver.findElement(By.id(value)).isDisplayed();
    	case "NAME" : 
    		return driver.findElement(By.name(value)).isDisplayed();
    	case "LINK TEXT" : 
    		return driver.findElement(By.linkText(value)).isDisplayed();
    	case "TAG NAME" : 
    		return driver.findElement(By.tagName(value)).isDisplayed();
    	case "CLASS" : 
    		return driver.findElement(By.className(value)).isDisplayed();
    	case "CSS" : 
    		return driver.findElement(By.cssSelector(value)).isDisplayed();
    	case "XPATH" : 
    		return driver.findElement(By.xpath(value)).isDisplayed();
    	default : System.out.println("Action not found");
    		return false;
    	}
	}
}
