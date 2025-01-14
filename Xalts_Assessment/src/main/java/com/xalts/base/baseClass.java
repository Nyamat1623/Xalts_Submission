package com.xalts.base;


import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;



public class baseClass {

	//public static WebDriver driver=null;
	public static Properties prop;
	public static WebDriver driver;


	@BeforeMethod
	public void loadconfig() {
		
		try {
			
			prop=new Properties();


			System.out.println("Super Contructor Invoked");

			FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\Config.properties");
			prop.load(ip);
			//System.out.println(" Driver : "+driver);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void launchapp() {

		String browsername=prop.getProperty("browser");

		if(browsername.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver=new ChromeDriver();
			//set browser to threadLocalMap
			driver=new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//set browser to threadLocalMap
			driver=new FirefoxDriver();
			
		}else if(browsername.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			//set browser to threadLocalMap
			driver=new EdgeDriver(); 
		}
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
	}

}
