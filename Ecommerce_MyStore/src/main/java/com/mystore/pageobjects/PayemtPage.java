package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class PayemtPage extends BaseClass{
	
	@FindBy(xpath="	//*[@class=\"bankwire\"]")
	WebElement wireMethod;
	

	@FindBy(xpath="//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a")
	WebElement payByCheck;
	
	public PayemtPage() {
		PageFactory.initElements(getDriver(), this);
		}
	
	
	public OrderSummeryPage clickOnPaymentMethod()
	{
		Action.click(getDriver(), wireMethod);
		return new OrderSummeryPage();
	}
	

}
