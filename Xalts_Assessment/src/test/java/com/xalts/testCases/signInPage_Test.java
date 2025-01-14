package com.xalts.testCases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xalts.base.baseClass;
import com.xalts.pageObjects.Signin_Page;
import com.xalts.pageObjects.Signup_Page;
import com.xalts.pageObjects.homePage;
import com.xalts.pageObjects.indexPage;




public class signInPage_Test extends baseClass{

	indexPage ip;
	Signup_Page sip;
	Signin_Page sin;
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
		sin=sip.ifAlreadyAcount();
		sin.EnteringSignup_Details(prop.getProperty("username"), prop.getProperty("password"));
		hp=sin.Clicking_Signin();
		hp.verifyLogin();
		ip=hp.signout();
		ip.verifyLogout();
		

	}


}
