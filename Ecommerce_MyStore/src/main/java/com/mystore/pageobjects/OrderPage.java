package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass{

	@FindBy(xpath="//li[@class='price']")
	WebElement unitPrice;
	
	@FindBy(id="total_price")
	WebElement totalPrice;
	
	
	@FindBy(xpath="(//span[contains(.,'Proceed to checkout')])[2]")
	WebElement proceedToCheckoutBtn;
	

	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
		}
	
	public double getunitPrice()
	{
		
		String unitPrice1= unitPrice.getText();
		String unit=unitPrice1.replaceAll("[^a-zA-Z0-9]","");
		Double finalUnitPrice=Double.parseDouble(unit);
		return finalUnitPrice/100;
		
		
		
		
	}
	
	
	public double getTotalPrice()
	{
		String totalPrice1= totalPrice.getText();
		String tot=totalPrice1.replaceAll("[^a-zA-Z0-9]","");
		Double finaltotalPrice=Double.parseDouble(tot);
		return finaltotalPrice/100;
		
		
	}
	
	public LoginPage clickOnCheckout()
	{
		Action.click(getDriver(), proceedToCheckoutBtn);
		return new LoginPage();
	}

}
