package testNG.Excel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignInTest {
	public static void Execute() throws Exception {

		// This is to get the values from Excel sheet, passing parameters (Row num &amp;
		// Col num)to getCellData method
		/**/
		String sUserName = ExcelUtilities.getCellData(1, 1);

		String sPassword = ExcelUtilities.getCellData(1, 2);

		String driverPath = "D:\\chromedriver.exe";
		/**/
		System.setProperty("webdriver.chrome.driver", driverPath);

		// Create a new instance of the Chrome driver
		WebDriver driver;

		driver = new ChromeDriver();

		// Put a Implicit wait, this means that any search for elements on the page
		// could take the time the implicit wait is set for before throwing exception

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Launch the Online Store Website

		driver.get("http://demo.guru99.com/test/login.html");

		// Get the WebElement corresponding to the Email Address(TextField)
		WebElement email = driver.findElement(By.id("email"));

		// Get the WebElement corresponding to the Password Field
		WebElement password = driver.findElement(By.name("passwd"));

		email.sendKeys(sUserName);
		password.sendKeys(sPassword);

		// Find the submit button
		WebElement login = driver.findElement(By.id("SubmitLogin"));

		login.click();

		Thread.sleep(5000);
		
		driver.close();

	}

}
