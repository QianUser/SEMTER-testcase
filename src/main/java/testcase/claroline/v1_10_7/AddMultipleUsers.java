package testcase.claroline.v1_10_7;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertTrue;

public class AddMultipleUsers {

	private WebDriver driver;

	@Before
	public void setUp(){
		System.setProperty(Executor.driverProperty, Executor.driverPath);
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}
	
	@Test
	public void runTest() throws InterruptedException{
		driver.get("http://localhost/claroline/claroline-1.10.7/");
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.name("submitAuth")).click();

		driver.findElement(By.linkText("Platform administration")).click();

		driver.findElement(By.linkText("Create user")).click();
		Thread.sleep(1000);

		driver.findElement(By.id("lastname")).sendKeys("testuser1");
		driver.findElement(By.id("firstname")).sendKeys("testuser1");
		driver.findElement(By.id("username")).sendKeys("testuser1");
		driver.findElement(By.id("password")).sendKeys("testuser1");
		driver.findElement(By.id("password_conf")).sendKeys("testuser1");
		driver.findElement(By.id("student")).click();
		driver.findElement(By.id("applyChange")).click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("Create another new user")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("lastname")).sendKeys("testuser2");
		driver.findElement(By.id("firstname")).sendKeys("testuser2");
		driver.findElement(By.id("username")).sendKeys("testuser2");
		driver.findElement(By.id("password")).sendKeys("testuser2");
		driver.findElement(By.id("password_conf")).sendKeys("testuser2");
		driver.findElement(By.id("courseManager")).click();
		driver.findElement(By.id("applyChange")).click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("Create another new user")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("lastname")).sendKeys("testuser3");
		driver.findElement(By.id("firstname")).sendKeys("testuser3");
		driver.findElement(By.id("username")).sendKeys("testuser3");
		driver.findElement(By.id("password")).sendKeys("testuser3");
		driver.findElement(By.id("password_conf")).sendKeys("testuser3");
		driver.findElement(By.id("platformAdmin")).click();
		driver.findElement(By.id("applyChange")).click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("Back to admin page")).click();

		driver.findElement(By.linkText("User list")).click();

		assertTrue(driver.findElement(By.tagName("body")).getText().contains("testuser1"));
		assertTrue(driver.findElement(By.tagName("body")).getText().contains("testuser2"));
		assertTrue(driver.findElement(By.tagName("body")).getText().contains("testuser3"));

		driver.findElement(By.linkText("Logout")).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
