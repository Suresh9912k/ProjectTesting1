package ProjectOne;

import org.testng.asserts.SoftAssert;
// import all assert -------------------
//import static org.testng.Assert.*; //hard assert
//import org.testng.asserts.SoftAssert.*;  //soft assert 

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;


public class HardVsSoftAssert {
	
	@Test
	public void TestFacebook(Object String) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();  // maximize the window
		driver.get("https://www.facebook.com/");
		
		// i need to enter some text and enter 
		// enter text and click
		driver.findElement(By.name("email")).sendKeys("wikipedia",Keys.ENTER); 
		Thread.sleep(3000);
		
		//create an object of SoftAssert class
		//step-2
		SoftAssert softAssert = new SoftAssert(); // create an object
		
		//step-3 all methods before you just use object name
		
		//case-1 hard assertion checking.....
	
		//1st Title checking...
		//create string...
		String actualTitle = driver.getTitle();  // get the title
		String expectedTitle = "Log in to Facebook";
		softAssert.assertEquals(actualTitle,expectedTitle,"Title is Missmathed");
		//https://www.facebook.com/
			
			
		//2nd URL checking...
		//create string...
		String actualUrl =driver.getCurrentUrl(); //get url
		String expectedUrl = "https://www.facebook.com/";
		softAssert.assertEquals(actualUrl,expectedUrl,"Url is Missmathed..");
		
		//3rd Text Assertion...
		//create string... and get text name---by using value
		String actualText = driver.findElement(By.name("email")).getAttribute("value"); // get the url
		String expectedText = "https://www.facebook.com/";
		softAssert.assertEquals(actualText,expectedText,"Text is Missmathed..");
		
		//4th Boadrer Assertion
		// Note: Boarder color= rgb     should be 
		String actualBoarder =driver.findElement(By.name("email")).getCssValue("boarder");
		// Note RGB color formate only we suuld use, (convert  and space also must)
		String expectedBoarder = "1px solid rgb(240, 40, 73)";
		softAssert.assertEquals(actualBoarder, expectedBoarder, "Boarder color is missmatched");
		
		//5th Error message
		// we can get error text message element by using X_path
		String actualErrorMessage =driver.findElement(By.xpath("(//div[@id=email_container]/div)[last()]")).getCssValue("boarder");
		String expectedErrorMessage = "The email address or mobile number you entered isn't connected to an account. ";
		softAssert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error Text message is missmatched");
		
		//-------------------------------------------------------		
		System.out.println(driver.getTitle()); //to print title
		Thread.sleep(3000);
		driver.quit();	
		softAssert.assertAll(); // to print all assetions.... exception at last...

	}

		
}
