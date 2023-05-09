package com.myStore.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class LoginpageTest extends BaseClass{
	IndexPage ip;
	LoginPage loginPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser)
	{
		launchApp(browser);
	}
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown()
	{
		getDriver().quit();
	}
	@Test(dataProvider = "credentials",dataProviderClass = DataProviders.class,groups= {"Sanity","Smoke"})
	public void loginTest(String uname,String pwd)
	{
		Log.startTestCase("loginTest");
		ip=new IndexPage();
		Log.info("user is going to click on sign in");
		
		loginPage=ip.clickOnSignin();
		Log.info("enter username and pwd");
		
		homePage =loginPage.login(uname,pwd);
		//homePage =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String actualURL =homePage.getCurrentURL();
		String expectedURL="http://automationpractice.pl/index.php?controller=my-account";
		
		Log.info("verifying if user is able to log in");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("logi is success");
		Log.endTestCase("End loginTest");
	
}
}