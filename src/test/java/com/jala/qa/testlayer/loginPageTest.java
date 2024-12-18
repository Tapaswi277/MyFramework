package com.jala.qa.testlayer;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jala.qa.pagelayer.loginPage;
import com.jala.qa.testbase.testBase;

public class loginPageTest extends testBase {
loginPage login;
	public loginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@BeforeMethod
public void setUp() throws IOException {
	intialization();
    login=new loginPage();
   
}
@Test
public void validateLoginPage() throws InterruptedException  {
	login.username(prop.getProperty("Username"));
	login.password(prop.getProperty("Password"));
    login.clickonloginBtn();

	holdTime();
	String actual=driver.getCurrentUrl();
	Assert.assertEquals(actual, "https://magnus.jalatechnologies.com/Home/Index123", "TC failed");
	Reporter.log("Url matched.. TC passed", true);
	
}
@AfterMethod
public void tearDown() throws InterruptedException {
	holdTime();
	driver.close();
	
}

}
