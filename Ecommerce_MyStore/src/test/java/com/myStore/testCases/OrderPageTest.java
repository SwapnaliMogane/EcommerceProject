package com.myStore.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

public class OrderPageTest extends BaseClass{
	IndexPage ip;
	SearchResultPage searchresult;
	AddToCartPage addToCartPage;
	OrderPage op;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser)
	{
		launchApp(browser);
	}
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}

	@Test(groups="Regression")
	public void verifyTotalPriceTest() {
		ip=new IndexPage();
		searchresult=ip.searchProduct("dress");
		addToCartPage=searchresult.clickOnProduct();
		addToCartPage.enterQuantity("1");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		op=addToCartPage.clickOnCheckout();
		Double unitPrice=op.getunitPrice();
		Double totalPrice=op.getTotalPrice();
		Double totalExpectedPrice=(unitPrice*1)+7;
		Assert.assertEquals(totalPrice, totalExpectedPrice);
	}
	

}
