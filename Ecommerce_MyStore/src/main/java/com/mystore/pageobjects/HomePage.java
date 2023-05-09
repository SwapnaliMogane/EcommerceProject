package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass{
	@FindBy(xpath="")
	WebElement username;
	
	@FindBy(xpath="//span[text()='Order history and details']")
	WebElement orderHistory;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
		}
		
	public boolean validateOrderHistory()
	{
		return Action.isDisplayed(getDriver(), orderHistory);
		
	}

	public String getCurrentURL()
	{
		String homePageURL=getDriver().getCurrentUrl();
		return homePageURL;
	}
}
