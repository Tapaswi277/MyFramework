package com.jala.qa.testlayer;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jala.qa.pagelayer.Homepage;
import com.jala.qa.pagelayer.employeepage;
import com.jala.qa.pagelayer.loginPage;
import com.jala.qa.testbase.testBase;
import com.jala.qa.utilitylayer.dataProvider1;

public class employeeTestPage extends testBase {
	loginPage login;
	Homepage home;
	employeepage emp;
	public employeeTestPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		intialization();
		login=new loginPage();
		login.username(prop.getProperty("Username"));
		login.password(prop.getProperty("Password"));
	    login.clickonloginBtn();
	    home=new Homepage();
	    Thread.sleep(4000);
	    home.createEmployeeTab();
	    emp=new employeepage();
	}
/*@DataProvider
public Object[][] addData() {
	
	Object [][] data= {{"tapaswi","saladi","saladi@gmail.com"},
			{"satish","kollipara","satish@gmail.com"},
			{"saleem","sahik","shaik@gmail.com"}};
	
	return data;
}*/

@DataProvider
public Object[][] getdataFromExcelSheet() throws IOException {
	dataProvider1 dataP = new dataProvider1();
	Object[][] data = dataP.fetchDataFromExcel();
	return data;
}



@Test(dataProvider="getdataFromExcelSheet")
	public void employeeTestPage(String fname,String lname,String mail,String Mobileno,String dob,String address) throws InterruptedException {
	    
	    emp.enterFirstName(fname);
	    emp.enterLastName(lname);
	    emp.enterEmail(mail);
	    emp.enterMobileNo(Mobileno);
	    emp.enterDOB(dob);
	    emp.clickOnfemaleButton();
	    emp.enterAdress(address);
	    emp.selectCountryId();
	    emp.selectCityId();
	    emp.selectSkill();
	    emp.clickOnSaveBytton();
	}

@AfterMethod
public void tearDown() throws InterruptedException {
	holdTime();
	driver.close();
	driver.quit();
}


}

