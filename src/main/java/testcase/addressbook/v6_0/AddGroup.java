package testcase.addressbook.v6_0;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertTrue;

public class AddGroup {

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
	public void runTest() throws InterruptedException {
		driver.get("http://localhost/addressbook/addressbook-6.0/?lang=en");
		driver.findElement(By.linkText("groups")).click();

		driver.findElement(By.name("new")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("group_name")).sendKeys("Group");
		driver.findElement(By.name("group_header")).sendKeys("Header");
		driver.findElement(By.name("group_footer")).sendKeys("Footer");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);

		assertTrue(driver.findElement(By.xpath(".//*[@id='content']/div")).getText().contains("A new group has been entered into the address book."));
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
}
