package ProjectOne;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.URL;

import org.testng.annotations.Parameters;

@Test
public class CrossBowser_Testing {

	public WebDriver driver;
	public String username = "jhonsksb4"; // username
	public String accesskey = "IfVJdBQjf6m7QqmztUSPFC4ghnI1s31H4CuxlWDrV6B3cGu52W"; // access key
	public String hub = "@hub.lambdatest.com/wd/hub";

	DesiredCapabilities capabilities = new DesiredCapabilities();

	// @Parameters(value={"Browser","Version","Platform"})

	@BeforeMethod
	@Parameters(value = { "Browser", "Version", "Platform" })
	public void setup(String browser, String version, String platform) {
		capabilities.setCapability("build", "2.1");
		capabilities.setCapability("name", "CrossBowser_Testing");

		capabilities.setCapability("browserName", "browser");
		capabilities.setCapability("version", "version");
		capabilities.setCapability("platform", "platform"); // If this cap isn't specified, it will just get the any
															// available one

		capabilities.setCapability("network", true);
		capabilities.setCapability("console", true);
		capabilities.setCapability("visual", true);

//	        capabilities.setCapability("video", true);
//	        capabilities.setCapability("resolution", "1024x768");
//	        capabilities.setCapability("network", true);

		try {

			driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + hub), capabilities);
		} catch (MalformedURLException exc) {
			exc.printStackTrace();
		}

		// open url----------------------------------
		driver.get("https://www.lambdatest.com/selenium-playground/");

	}

	// Test-1
	public void testDropDowns() {

		driver.findElement(By.linkText("Select Dropdown List")).click();
		WebElement findDropDowns = driver.findElement(By.id("select-demo"));
		Select DropD = new Select(findDropDowns);
		DropD.selectByVisibleText("Saturday");

	}

	// Test-2
	public void testDropDowns2() {

		driver.findElement(By.linkText("Select Dropdown List")).click();
		WebElement findDropDowns = driver.findElement(By.id("select-demo"));
		Select DropD = new Select(findDropDowns);
		DropD.selectByVisibleText("Monday");

	}

}
