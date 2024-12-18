package com.jala.qa.testlayer;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jala.qa.pagelayer.Homepage;
import com.jala.qa.pagelayer.loginPage;
import com.jala.qa.testbase.testBase;

public class homepagetest extends testBase {
	Homepage home;
	public homepagetest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
@BeforeMethod
public void setUp() throws IOException, InterruptedException {
	intialization();
	loginPage login=new loginPage();
	login.username(prop.getProperty("Username"));
	login.password(prop.getProperty("Password"));
	login.clickonloginBtn();
     home=new Homepage();
}
@Test
public void validateHomePage() {
	home.logoutButtonClick();
	String actual=driver.getTitle();
	Assert.assertEquals(actual, "Login");
	Reporter.log("Page title matched",true);
}
@AfterMethod
public void tearDown() throws InterruptedException {
	holdTime();
	driver.close();
}
}
