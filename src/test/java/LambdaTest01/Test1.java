package LambdaTest01;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import dev.failsafe.internal.util.Assert;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import static org.testng.Assert.*;

public class Test1 {

	public WebDriver driver;
	public WebDriverWait wait;
	public SoftAssert softassert;


	@Parameters({ "URL" })
	@BeforeClass
	public void setUp(String url) {

		// WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// step:1 Load the AUT
		driver.get(url);

	}

	// 1st Test Scenario-1
	@Test
	// @Parameters({ "Task", "TestResult" })
	public void Test_Scenario_01() {

		// WebDriverWait wait = new WebDriverWait(driver, 10); // 10 second wait at
		// palce // webDriverWait

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// SoftAssert class---
		softassert = new SoftAssert();

		// get Title---
		String expected_title = "Selenium Grid Online | Run Selenium Test On Cloud--";
		String actual_title = driver.getTitle();

		softassert.assertEquals(actual_title, expected_title, " ****Title Not matched****");

	}

	// 2nd Test Scenario-02
	@Test 
	// @Parameters({ "Task", "TestResult" })
	public void Test_Scenario_02() {

		// click on the "Check Box Demo"
		driver.findElement(By.linkText("Checkbox Demo")).click();

		// click on the "Single Check Box"
		WebElement cb1 = driver.findElement(By.id("isAgeSelected")); // read WebElement of 'single check box'

		// validate check box is selected---
		
		cb1.click(); // click on the check box

		if (cb1.isSelected()) {
			System.out.println("Check box is Selected.");
		} else {
			cb1.click();
			System.out.println("check box is unselected");
		}
		
		
		// method-2
		softassert.assertFalse(cb1.isDisplayed(), " **** Check Box already selected  ****");
		
	}

	// 2nd Test Scenario-03
	@Test
	@Parameters({ "URL" })
	public void Test_Scenario_03(String url) {

		//
//		1. Launch the same browser and URL given in the Pre-Condition.
//		2. Click “Javascript Alerts” under “Alerts & Modals”.
//		3. Now click the “Click Me” button in the “Java Script Alert Box”
//		section.
//		4. Validate the alert message “I am an alert box!” and click ok.		
	
		
		// step:1 Load the AUT
				driver.get(url);

		// click on "Javascript Alert"
		driver.findElement(By.xpath("//a[text()='Javascript Alerts']")).click();

		// click the “Click Me”
		driver.findElement(By.xpath("//button[text()='Click Me']")).click();

		// validate the alert message---
		String actual_alert = driver.switchTo().alert().getText();
		System.out.println("Alert Message:" + actual_alert);
		
		//validate alert message
		String Expected_alert="I am an alert box!--";
		softassert.assertEquals(actual_alert,Expected_alert,"**** Alert Box message Not Matched! ******");
		

//		assertEquals(actual_alert,Expected_alert,"****Alert Box message Not-Matched! ******");  //Hard Assert

		// accept alert
		driver.switchTo().alert().accept();	


	}

	@AfterClass
	public void tearDown() {
		

		System.out.println("Completed Scenario Successfully");
		driver.quit();
		softassert.assertAll(); // print all asserts---

	}

}
