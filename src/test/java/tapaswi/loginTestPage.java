package tapaswi;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jala.qa.pagelayer.loginPage;
import com.jala.qa.testbase.testBase;

import com.jala.qa.utilitylayer.dataProvider2;

public class loginTestPage extends testBase {
	loginPage login;
	public loginTestPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		intialization();
		login=new loginPage();
		/*login.username(prop.getProperty("Username"));
		login.password(prop.getProperty("Password"));
	    login.clickonloginBtn();*/
	}
	@DataProvider
	public Object[][] getdataFromExcelSheet() throws IOException {
		dataProvider2 dataP = new dataProvider2();
		Object[][] data = dataP.fetchDataFromExcel();
		return data;
	}
	@Test(dataProvider="getdataFromExcelSheet")
	public void LoginPageValidation(String Username,String Password) throws InterruptedException {
		login.username(Username);
		login.password(Password);
		login.clickonloginBtn();
		Thread.sleep(3000);
		String actual=driver.getCurrentUrl();	
		System.out.println(actual);
		Assert.assertEquals(actual, "https://magnus.jalatechnologies.com/Home/Index");
		Reporter.log("Valid Details",true);
		
	}
	@AfterMethod
	public void tearDown() throws InterruptedException {
		holdTime();
		driver.close();
		driver.quit();
	}

}
