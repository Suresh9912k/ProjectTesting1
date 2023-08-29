package ProjectOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParameterTest02 {

	WebDriver driver;

	@Parameters({ "URL" })
	@BeforeClass
	public void setup(String url) {

		// WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// step:1 Load the AUT
		driver.get(url);

	}

	// 2nd ----
	@Test
	@Parameters({ "Task", "TestResult" })
	public void TestFileDownload(String task, String testRestult) {

		// Step 2: Click the file download link
		driver.findElement(By.xpath("//a[text()='File Download']")).click();

		// step 3: Enter Data
		driver.findElement(By.id("textbox")).sendKeys(task + "Execution:" + testRestult);

		// Step 4: Click the Generator File
		driver.findElement(By.id("create")).click();

		// Step 5: Click the Download FIle
		driver.findElement(By.id("link-to-download")).click();

	}

	@AfterClass
	public void tearDwon() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();

	}

}
