package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderConfirmationPage extends BaseClass {
	
	@FindBy(xpath="//p[@class='alert alert-success']")
	WebElement confirmOrderMsg;
	
	public OrderConfirmationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String validateOrderConfirmPage() 
	{
		
		String confirmMsg=confirmOrderMsg.getText();
		return confirmMsg;
	}

}
