package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.mystore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;
	//public static WebDriver driver;
	
	//Declare thread local driver
	public static ThreadLocal<RemoteWebDriver> driver=new ThreadLocal<>();
	
	@BeforeSuite(groups= {"Smoke","Sanity","Regression"})
	public void beforeSuite() throws IOException
	{
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
	}
	
	
	@BeforeTest(groups= {"Smoke","Sanity","Regression"})
	
	public void loadConfig() throws IOException
	{
		//ExtentManager.setExtent();
		//DOMConfigurator.configure("log4j.xml");
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\Config.properties");
			prop.load(ip);
			System.out.println("driver:"+driver);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static WebDriver getDriver()
	{
		//get driver from threadlocalmap
		return driver.get();
		
	}
	
	
	public static void launchApp(String browserName) {

		
		//String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			
			//set browser to thread localmap
			driver.set(new ChromeDriver());

		} else if (browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver();
			driver.set(new FirefoxDriver());


		}
		getDriver().manage().window().maximize();
		//Action.implicitWait(getDriver(), 10);
		//Action.pageLoadTimeOut(driver, 30);
		getDriver().get(prop.getProperty("url"));
		
	}
	
	@AfterSuite
	public void afterSuite()
	{
		ExtentManager.endReport();
	}
}
