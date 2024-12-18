package com.jala.qa.pagelayer;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jala.qa.testbase.testBase;

public class searchPage extends testBase{

	

	@FindBy(id="MobileNo")
	WebElement mobileNo;
	
	@FindBy(id="btnSearch")
	WebElement buttonSearch;
	
	@FindBy(id="tblEmployee")
	WebElement employeeTable;
	
	public searchPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	public void enterMobileNo() {
		mobileNo.sendKeys("9999999999");
	}
	public void clickOnSearchBtn() {
		buttonSearch.click();
	}
	public void searchEmployeeTable() {
		List<WebElement> tablevalue = employeeTable.findElements(By.tagName("tr"));
		for(int i=0;i<tablevalue.size();i++) {
			System.out.println(tablevalue.get(i).getText());
			String actual = tablevalue.get(i).getText();
			 String expected ="satish";
			 if(actual.contains(expected)) {
				 System.out.println("matched");
			 }
		}
		
	}
}
