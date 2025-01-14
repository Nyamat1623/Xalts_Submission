package com.xalts.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xalts.base.baseClass;

public class indexPage extends baseClass {

	@FindBy( xpath="//button[contains(text(), 'Get Started')]")
			WebElement GetStarted_BTN;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/header/div/button")
	WebElement signIn_BTN;

	public indexPage(){
		PageFactory.initElements(driver, this);
	} 
	
	public Signup_Page clickinon_Signuplink() {
		
		GetStarted_BTN.click();
		
		return new Signup_Page();
	}
	public void verifyLogout() {
		if(signIn_BTN.isDisplayed()) {
			System.out.println("User has logged out");
		}else {
			System.out.println("Log out failed");
		}
	}
	
}
