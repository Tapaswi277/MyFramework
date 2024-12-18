package com.jala.qa.pagelayer;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jala.qa.testbase.testBase;

public class Homepage extends testBase {
	
	@FindBy(linkText="Employee")
	WebElement employee;
	@FindBy(linkText ="Create")
	WebElement createTab;
	
	@FindBy(linkText="Search")
	WebElement SearchTab;
	
	@FindBy(xpath="//span[text()='Logout']")
	WebElement logoutBtn;
	
	public Homepage() throws IOException{
		PageFactory.initElements(driver, this);
	}
	
	public void createEmployeeTab() throws InterruptedException{
		employee.click();
		Thread.sleep(3000);
		createTab.click();
	}

	 public void searcEmployeeTab() {
		 SearchTab.click();
		 logoutBtn.click();
		 
	 }
	 public void logoutButtonClick() {
		 logoutBtn.click();
	 }
	 public void clickOnSearchTab() {
		 SearchTab.click();
	 }
	 }
