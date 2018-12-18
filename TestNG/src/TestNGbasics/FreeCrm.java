package TestNGbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FreeCrm {
	public String baseUrl = "https://www.freecrm.com/index.html";
	 String driverPath = "D:\\chromedriver.exe";
	 public WebDriver driver;
	 String fName = "John";
	 String lName = "Mathew";
	 String uName = "Jmathew3";
	 String eMail = "johnmathew3@gmail.com";
	 String pwd = "mathewjohn";
	 String contact1Fname = "peeter ";
	 String contact1Lname = "mm";
	 String C1 = contact1Fname  + contact1Lname;
	 String companyName1 = "IBM";
	 String Contactsfn[] = {"john", "mathew", "george"};
	 String Contactsln[] = {"johnl", "mathewl", "georgel"};


	 

@BeforeTest
public void launchBrower()
{
    System.out.println("launching chrome");
    System.setProperty("webdriver.chrome.driver",driverPath);
    driver = new ChromeDriver();
    driver.get(baseUrl);
    
}
/*
@Test(priority = 0)
public void SignUp() throws Exception{
	Thread.sleep(3000);
	driver.findElement(By.linkText("Sign Up")).click();
	Select Edition = new Select (driver.findElement(By.id("payment_plan_id")));
	Edition.selectByVisibleText("Free Edition");
	driver.findElement(By.name("first_name")).sendKeys(fName);
	driver.findElement(By.name("surname")).sendKeys(lName);
	driver.findElement(By.name("email")).sendKeys(eMail);
	driver.findElement(By.name("email_confirm")).sendKeys(eMail);
	driver.findElement(By.name("username")).sendKeys(uName);
	driver.findElement(By.name("password")).sendKeys(pwd);
	driver.findElement(By.name("passwordconfirm")).sendKeys(pwd);
	driver.findElement(By.name("agreeTerms")).click();
	driver.findElement(By.id("submitButton")).click();
	Thread.sleep(5000);
	driver.findElement(By.name("company_name")).sendKeys("ibm");
	driver.findElement(By.name("phone")).sendKeys("5142351478");
	driver.findElement(By.name("company_email")).sendKeys("ibm@gmail.com");
	driver.findElement(By.name("address")).sendKeys("Mathew"
			+ "562 kipps");
	driver.findElement(By.id("city")).sendKeys("london");
	driver.findElement(By.name("state")).sendKeys("ontario");
	driver.findElement(By.name("postcode")).sendKeys("h4l5d6");
	Select country = new Select (driver.findElement(By.name("country")));
	country.selectByVisibleText("Canada");
	driver.findElement(By.name("copy_address"));
	
	driver.findElement(By.name("btnSubmit")).click();
	Thread.sleep(3000);
	driver.findElement(By.name("finish")).click();
	Thread.sleep(3000);
	
	WebElement we= driver.findElement(By.className("text_orange"));
	System.out.println( we.getText());
	if (we.getText().equalsIgnoreCase("Your account is now registered"))
		System.out.println("SignUp completed");
	Thread.sleep(5000);
}
*/

@DataProvider
public Object[][] dp() {
  return new Object[][] {
    new Object[] { "Jmathew3", "mathewjohn" },
    new Object[] { "username2", "pwd24" },
  };
}
@Test(priority = 0,dataProvider = "dp")
public void SignIn(String u, String p) throws Exception{
	driver.get(baseUrl);
	Thread.sleep(3000);
	driver.findElement(By.name("username")).sendKeys(u);
	driver.findElement(By.name("password")).sendKeys(p);
	driver.findElement(By.xpath("//*[@id='loginForm']/div/div/input")).click();
	
	//xpath for buttons(with attributes) //input[@type='submit']
	Thread.sleep(4000);
	//tr/td[4]/a
	driver.switchTo().frame("mainpanel");
	driver.findElement(By.xpath("//tr/td[4]/a")).click();
	//System.out.println("Contact saved: "+C2.contentEquals(C1));
	Thread.sleep(3000);
}
/*
@Test(priority = 2)
public void CName() throws Exception{
//driver.switchTo().frame("mainpanel");
	Actions builder = new Actions(driver);
	Thread.sleep(3000);
	
	Action mouseOverC = builder.moveToElement(driver.findElement(By.linkText("COMPANIES"))).build();
	mouseOverC.perform();
	Thread.sleep(2000);
	builder.moveToElement(driver.findElement(By.linkText("New Company"))).click().build().perform();
	Thread.sleep(2000);
	driver.findElement(By.id("company_name")).sendKeys(companyName1);
	driver.findElement(By.xpath("//*[@id='companyForm']/table/tbody/tr[1]/td/input")).click();
	Thread.sleep(3000);
	String Co1 = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[1]")).getText();
	System.out.println("company name saved" +Co1.contentEquals(companyName1) );
	
}

*/


@Test(priority = 1)
public void Contact() throws Exception{
//	Thread.sleep(3000);
	driver.switchTo().frame("mainpanel");
	Actions builder = new Actions(driver);
	
	//a[text()='Contacts']
	for(int i=0;i<3;i++){
	WebElement contact = driver. findElement(By.xpath("//a[text()='Contacts']"));
	WebElement newContact = driver.findElement(By.xpath("//a[text()='New Contact']"));
	
	builder.moveToElement(contact).build().perform();
	Thread.sleep(2000);
	newContact.click();
	Thread.sleep(3000);
	driver.findElement(By.id("first_name")).sendKeys(Contactsfn[i]);
	driver.findElement(By.id("surname")).sendKeys(Contactsln[i]);
	driver.findElement(By.xpath("//*[@id='contactForm']/table/tbody/tr[1]/td/input[2]")).click();
	Thread.sleep(3000);
	String C0 = Contactsfn[i]+" "+Contactsln[ i];
	String C2 =  driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[1]")).getText();
	System.out.println(C2);
	if (C2.equalsIgnoreCase(C0)){
		System.out.println("passed");
		}
	System.out.println(C0);
	
	driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[2]/td[1]/div/table/tbody/tr/td[4]/a")).click();
	//System.out.println("Contact saved: "+C2.contentEquals(C1));
	Thread.sleep(3000);
	}
}


/*@AfterTest
public void closeBrowser(){
  driver.close();
}
*/
}