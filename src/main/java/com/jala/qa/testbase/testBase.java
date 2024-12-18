package com.jala.qa.testbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class testBase {
public static WebDriver driver;
public static Properties prop;
	public testBase() throws IOException{
		prop=new Properties();
		String baseLocation=System.getProperty("user.dir");
		FileInputStream file=new FileInputStream(baseLocation+"\\src\\main\\java\\com\\jala\\qa\\environmentlayer\\config.properties");
		prop.load(file);
	}
	public void intialization() {
		String browser=prop.getProperty("Browsername");
      if(browser.equals("chrome")) {
    	   driver=new ChromeDriver();
    	  
      }else if(browser.equals("firefox")){
    	   driver=new FirefoxDriver();

      }else if(browser.equals("edge")){
    	   driver=new EdgeDriver();

      }
      else {
    	  System.out.println("Something Went Wrong");
      }
      driver.manage().window().maximize();
      driver.manage().deleteAllCookies();
      driver.get(prop.getProperty("Url"));
      driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);//implicit wait
     
      /*Explicit wait*/
    /*  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
      WebElement username=driver.findElement(By.id("UserName"));
      username.sendKeys("training@jalaacademy.com");
      wait.until(ExpectedConditions.visibilityOf(username));
     WebElement password=driver.findElement(By.id("Password"));
     password.sendKeys("jobprogram");*/
	}
	public static void holdTime() throws InterruptedException {
		Thread.sleep(6000);
	}
}

