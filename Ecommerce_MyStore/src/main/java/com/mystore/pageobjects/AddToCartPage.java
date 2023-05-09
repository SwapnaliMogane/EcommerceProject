package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass {
	@FindBy(id = "quantity_wanted")
	WebElement quantity;
	
	@FindBy(name = "group_1")
	WebElement size;
	
	
	@FindBy(xpath="//*[@id=\"add_to_cart\"]//span")
	WebElement addToCartButton;
	
	@FindBy(xpath ="//*[@id=\"layer_cart\"]//h2")
	WebElement addToCartMessage;
	
	@FindBy(xpath ="//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckoutBtn;
	

	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
		}
	
	
	public void enterQuantity(String quantity1)
	{
		Action.type(quantity,quantity1);
	}
	
	public void selectSize(String size1)
	{
		Action.selectByVisibleText(size1,size);
	}

public void clickOnAddToCart()
{
	Action.click(getDriver(), addToCartButton);
	}
public boolean validateAddToCart()
{
	Action.fluentWait(getDriver(), addToCartMessage, 10);
	return  Action.isDisplayed(getDriver(), addToCartMessage);
}

public OrderPage clickOnCheckout()
{
	Action.fluentWait(getDriver(), proceedToCheckoutBtn, 10);
	Action.JSClick(getDriver(), proceedToCheckoutBtn);
	
	return new OrderPage();
}
}
