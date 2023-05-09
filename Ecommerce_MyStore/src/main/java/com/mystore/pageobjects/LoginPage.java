package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass {
	
	@FindBy(id="email")
	WebElement username;
	
	@FindBy(id="passwd")
	WebElement password;
	
	
	@FindBy(id="SubmitLogin")
	WebElement signInBtn;
	
	@FindBy(id="email_create")
	WebElement emailForNewAccount;
	

	@FindBy(xpath = "//span[contains(.,'Create an account')]")
	WebElement createNewAccountBtn;
	

	public LoginPage() {
	PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage login(String uname,String pswd)
	{
		Action.type(username, uname);
		Action.type(password, pswd);
		Action.click(getDriver(), signInBtn);
		return new HomePage();
	}
	

	public AddressPage login1(String uname,String pswd)
	{
		Action.type(username, uname);
		Action.type(password, pswd);
		Action.click(getDriver(), signInBtn);
		return new AddressPage();
	}
	
	public AccoutCreationPage createNewAccount(String newEmail)
	{
		Action.type(emailForNewAccount, newEmail);
		Action.click(getDriver(), createNewAccountBtn);
		return new AccoutCreationPage();
	}
}
