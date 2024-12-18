package com.jala.qa.pagelayer;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.jala.qa.testbase.testBase;

public class employeepage extends testBase {
	
	
	
public employeepage() throws IOException {
			PageFactory.initElements(driver, this);
}
@FindBy(id="FirstName")
WebElement firstName;

@FindBy(id="LastName")
WebElement lastName;

@FindBy(id="EmailId")
WebElement email;

@FindBy(id="MobileNo")
WebElement mobileNo;

@FindBy(id="DOB")
WebElement dateOfBirth;

@FindBy(id="rdbMale")
WebElement male;

@FindBy(id="rdbFemale")
WebElement feMale;

@FindBy(id="Address")
WebElement address;

@FindBy(id="CountryId")
WebElement selectCountry;

@FindBy(id="CityId")
WebElement selectCity;

@FindBy(id="chkSkill_1")
WebElement selectSkills;

@FindBy(xpath="//button[text()='Save']")
WebElement saveButton;

public void enterFirstName(String fname) {
	firstName.sendKeys(fname);
}
public void enterLastName(String lName) {
	lastName.sendKeys(lName);
}
public void enterEmail(String Email) {
	email.sendKeys(Email);
}

public void enterMobileNo(String Mob) {
	mobileNo.sendKeys(Mob);
}
public void enterDOB(String dob) {
	dateOfBirth.sendKeys(dob);
}

public void clickOnMaleButton() {
	male.click();
}
public void clickOnfemaleButton() {
	feMale.click();
}
public void enterAdress(String addre) {
	address.sendKeys(addre);;
}
public void selectCountryId()
{
	Select select=new Select(selectCountry);
	select.selectByIndex(5);
}
public void selectCityId()
{
	Select select=new Select(selectCity);
	select.selectByVisibleText("Hyderabad");
}
public void selectSkill()
{
	
	selectSkills.click();
}
public void clickOnSaveBytton() {
	saveButton.click();
}

}

	


