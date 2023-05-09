package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass {
	@FindBy(id="cgv")
	WebElement termsBtn;
	
	@FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
	WebElement proceedcheckoutBtn;

	public ShippingPage() {
		PageFactory.initElements(getDriver(), this);
		}
	
	public void clickTermBtn()
	{
		Action.click(getDriver(), termsBtn);
		
		
	}
	
public PayemtPage clickOnCheckout()
{
	Action.click(getDriver(), proceedcheckoutBtn);
	return new PayemtPage();
	
	
}
}
