package com.myStore.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummeryPage;
import com.mystore.pageobjects.PayemtPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;

public class EndToEndTest extends BaseClass{
	IndexPage ip;
	SearchResultPage searchresult;
	AddToCartPage addToCartPage;
	OrderPage op;
	LoginPage lp;
	AddressPage ap;
	ShippingPage sp;
	PayemtPage pp;
	OrderSummeryPage os;
	OrderConfirmationPage ocp;
	
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
	public void endToEndTest()
	{
		ip=new IndexPage();
		searchresult=ip.searchProduct("dress");
		addToCartPage=searchresult.clickOnProduct();
		addToCartPage.enterQuantity("1");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		op=addToCartPage.clickOnCheckout();
		lp=op.clickOnCheckout();
		ap=lp.login1(prop.getProperty("username"), prop.getProperty("password"));
		sp=ap.clickOnCheckout();
		sp.clickTermBtn();
		pp=sp.clickOnCheckout();
		os=pp.clickOnPaymentMethod();
		ocp=os.clickonConfirmorderBtn();
		String actual_msg=ocp.validateOrderConfirmPage();
		String expt_msg="Your order on My Store is complete.";
		Assert.assertEquals(actual_msg, expt_msg);
	}
}
