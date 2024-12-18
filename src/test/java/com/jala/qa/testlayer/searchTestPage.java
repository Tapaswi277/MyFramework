package com.jala.qa.testlayer;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jala.qa.pagelayer.Homepage;
import com.jala.qa.pagelayer.loginPage;
import com.jala.qa.pagelayer.searchPage;
import com.jala.qa.testbase.testBase;

public class searchTestPage extends testBase {
	Homepage home;
	searchPage search;
	public searchTestPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
@BeforeMethod
public void setUp() throws IOException {
	intialization();
	loginPage login=new loginPage();
	login.username(prop.getProperty("Username"));
	login.password(prop.getProperty("Password"));
	login.clickonloginBtn();
     search=new searchPage();
}
@Test
public void validateSearchPage() throws InterruptedException {
	search.enterMobileNo();
	Thread.sleep(4000);
	search.clickOnSearchBtn();
	search.searchEmployeeTable();
	Thread.sleep(4000);
	String actual=driver.getTitle();
	Assert.assertEquals(actual, "Search Employee");
	Reporter.log("title matched",true);
}
@AfterMethod
public void tearDown() throws InterruptedException {
	holdTime();
	driver.close();
}
}
