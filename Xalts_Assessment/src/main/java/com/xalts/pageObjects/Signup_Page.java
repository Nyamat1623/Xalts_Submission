package com.xalts.pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.xalts.base.baseClass;

public class Signup_Page extends baseClass{

	@FindBy(xpath="//input[@type='text']")
	WebElement Username_field;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement passwordText_field;
	
	@FindBy(xpath="/html/body/div/div/main/div[2]/div[3]/div/input")
	WebElement ConfirmpasswordText_field;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/main/div[2]/button[1]")
	WebElement signUp_BTN;
	
	@FindBy(xpath="//button[contains(text(), 'Already have an account?')]")
	WebElement AcountSigninBtn_Link;
	
	public Signup_Page() {
		PageFactory.initElements(driver, this);
	}
	
	public void EnteringSignup_Details(String username,String password,String Cpassword) {
		Username_field.sendKeys(username);
		passwordText_field.sendKeys(password);
		ConfirmpasswordText_field.sendKeys(Cpassword);
	}
	
	public homePage Clicking_Signup() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(signUp_BTN));
		if(signUp_BTN.isEnabled()) {
			signUp_BTN.click();
		}else {
			System.out.println("Sign up button is disabled");
		}
		
		return new homePage();
	}
	
	public Signin_Page ifAlreadyAcount() {
		AcountSigninBtn_Link.click();
		return new Signin_Page();
	}
}
