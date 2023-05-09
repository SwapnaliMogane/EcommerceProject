package com.myStore.testCases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

public class IndexPageTest extends BaseClass {
	IndexPage ip;

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

	@Test(groups = "smoke")
	public void verifyLogo() {
		ip = new IndexPage();
		boolean result = ip.validateLogo();
		Assert.assertTrue(result);
	}

	@Test(groups = "Smoke")
	public void verifyTitle() {
		ip = new IndexPage();
		String actual_title = ip.getMyStoreTitle();
		Assert.assertEquals(actual_title, "My Store");

	}

}
