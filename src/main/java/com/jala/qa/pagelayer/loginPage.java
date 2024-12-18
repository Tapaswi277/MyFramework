package com.jala.qa.pagelayer;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jala.qa.testbase.testBase;

public class loginPage extends testBase {
	//1.Object repository 2.Constructor 3.Action function
	@FindBy(id="UserName")
	WebElement username;
	@FindBy(id="Password")
	WebElement password;
	@FindBy(id="btnLogin")
	WebElement loginBtn;

	public loginPage() throws IOException{
		
		PageFactory.initElements(driver,this);
	}
	public void username(String Uname) {
		username.sendKeys(Uname);
	
		
	}
	public void password(String Pass) {
		password.sendKeys(Pass);
	}
	public void clickonloginBtn() {
		loginBtn.click();
	}
}
