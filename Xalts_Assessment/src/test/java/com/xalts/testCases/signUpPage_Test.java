package com.xalts.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xalts.base.baseClass;
import com.xalts.pageObjects.Signup_Page;
import com.xalts.pageObjects.homePage;
import com.xalts.pageObjects.indexPage;


public class signUpPage_Test extends baseClass{

	indexPage ip;
	Signup_Page sip;
	homePage hp;
	
	@BeforeMethod
	public void setup() {
		launchapp();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test
	public void Test() {
		ip=new indexPage();
		sip=ip.clickinon_Signuplink();
		sip.EnteringSignup_Details("Nyam1@gmail.com","Pass@1234","Pass@1234");
		
		hp=sip.Clicking_Signup();
		hp.verifysignUp();
		ip=hp.signout();
		ip.verifyLogout();
}
}
