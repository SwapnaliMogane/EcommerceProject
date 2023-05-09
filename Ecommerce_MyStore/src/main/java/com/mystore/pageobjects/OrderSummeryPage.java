package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderSummeryPage extends BaseClass {
	
	
	@FindBy(xpath="	//*[@id=\"cart_navigation\"]/button/span")
	WebElement confirmOrderBtn;
	
	public OrderSummeryPage() {
		PageFactory.initElements(getDriver(), this);
		
	}
	
	public OrderConfirmationPage clickonConfirmorderBtn()
	{
		Action.click(getDriver(), confirmOrderBtn);
		return new OrderConfirmationPage();
	}

}
