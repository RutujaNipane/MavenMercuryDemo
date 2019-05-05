package com.model.MavenMercuryDemo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class MercuryTest 
{
	public WebDriver driver;
	@Test(priority=1)
	  public void loginvaliddata1() 
	  {
		  String exp_title="Welcome: Mercury Tours";
		  String act_title=driver.getTitle();
		  Assert.assertEquals(exp_title, act_title);
		  System.out.println("Titles are matched");
		  
		  	driver.findElement(By.cssSelector("input[name='userName']")).sendKeys("rutuja2");
		  	driver.findElement(By.cssSelector("input[name='password']")).sendKeys("rutuja2");
		    driver.findElement(By.xpath("//input[@name='login']")).click();
		  
		   boolean exp_img=true;
		   boolean act_img=driver.findElement(By.cssSelector("img[src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
		   Assert.assertEquals(act_img, exp_img);
		   System.out.println("Flightfinder image is displayed");
		   driver.findElement(By.xpath("//a[.='SIGN-OFF']")).click();
	  }
	  
	  @Test(priority=2)
	  public void signupPage()
	  {
		  
		  String exp_title="Sign-on Mercury Tours";
		  String act_title=driver.getTitle();
		  
		  Assert.assertEquals(exp_title, act_title, "Titles of signup page are not match");
		  System.out.println("User is on signup page");
	  }
	  
	  @Test(priority=3)
	  public void loginInvalidds()
	  {
		  
		  String exp_title="Sign-on: Mercury Tours";
		  String act_title=driver.getTitle();
		  
		  AssertJUnit .assertEquals(exp_title, act_title);
		  System.out.println("User is on this page"+act_title);
		  
		  driver.findElement(By.cssSelector("input[name='userName']")).sendKeys("rutu");
		  driver.findElement(By.cssSelector("input[name='password']")).sendKeys("rutu");
		  driver.findElement(By.xpath("//input[@name='login']")).click();
		  
		  boolean act_img=driver.findElement(By.xpath("//img[@src='/images/masts/mast_signon.gif']")).isDisplayed();
		  Assert.assertTrue(act_img);
		  System.out.println("Signon image is displayed"+act_img);
		  
	  }
	  
	  @BeforeMethod
	  public void getAllCookies() 
	  {
		  System.out.println("IN BEFORE METHOD");
		 Set<Cookie>cookies=driver.manage().getCookies();
		 for(Cookie cookie:cookies)
		 {
			 String nameofcookie=cookie.getName();
			 System.out.println("Name of cookie is=="+nameofcookie);
		 }
		 
	  }

	  @AfterMethod
	  public void getScreenshots() throws IOException 
	  {
		  System.out.println("IN AFTER METHOD");
		  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFileToDirectory(src, new File("G:\\OxygenWorkspce\\MavenMercuryDemo\\src\\main\\resource\\ScrrenShots\\"));
		  System.out.println("Screenshot Taken Successfully");
	  }

	  @BeforeClass
	  public void windowMaximize() 
	  {
		  System.out.println("IN BEFORE CLASS");
		  driver.manage().window().maximize();
		  String currenturl=driver.getCurrentUrl();
		  System.out.println("Current url of page is=="+currenturl);
	  }

	  @AfterClass
	  public void deleteAllCookies() 
	  {
		  System.out.println("IN AFTER CLASS");
		  driver.manage().deleteAllCookies();
	  }

	  @BeforeTest
	  public void pageurlUp() 
	  {
		  System.out.println("IN BEFORE TEST");
		  driver.get("http://newtours.demoaut.com/");
		  
	  }

	  @AfterTest
	  public void dbConnectionClose() 
	  {
		  System.out.println("IN AFTER TEST");
		  System.out.println("db connection close");
		  
	  }

	  @BeforeSuite
	  public void beforeSuite() 
	  {
		  System.out.println("IN BEFORE SUIT");
		  System.setProperty("webdriver.chrome.driver", "G:\\TESTING\\chromedriver_win32\\chromedriver.exe");
		  driver=new ChromeDriver();
		  
	  }

	  @AfterSuite
	  public void browserClose() 
	  {
		  System.out.println("IN AFTER SUIT");
		  
		  driver.close();
		  
	  }
}
