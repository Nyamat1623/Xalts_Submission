package com.xalts.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xalts.base.baseClass;

public class Signin_Page extends baseClass {

	@FindBy(xpath="//input[@type='text']")
	WebElement Username_field;

	@FindBy(xpath="//input[@type='password']")
	WebElement passwordText_field;

	@FindBy(xpath="//button[contains(text(), 'S')]")
	WebElement signIn_BTN;

	public Signin_Page() {
		PageFactory.initElements(driver, this);
	}

	public void EnteringSignup_Details(String username,String password) {
		Username_field.sendKeys(username);
		passwordText_field.sendKeys(password);	}

		public homePage Clicking_Signin() {
			signIn_BTN.click();
			return new homePage();
		
		}
		
		
	
}