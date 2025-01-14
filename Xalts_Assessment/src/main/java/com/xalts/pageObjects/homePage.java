package com.xalts.pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.xalts.base.baseClass;

public class homePage extends baseClass{

	
	@FindBy(xpath="//*[@id=\"root\"]/div/header/div/button")
	WebElement Signout_BTN;
	
	public homePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void verifyLogin() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(Signout_BTN));
		if(Signout_BTN.isDisplayed()) {
			System.out.println("User Logged in");
		}else {
			System.out.println("Log in failed");
		}
	}
	
	public void verifysignUp() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(Signout_BTN));
		if(Signout_BTN.isDisplayed()) {
			System.out.println("User Signed in");
		}else {
			System.out.println("Sign in failed");
		}
	}
	public indexPage signout() {
		Signout_BTN.click();
		return new indexPage();
	}
}
