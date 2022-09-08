package testcase.addressbook.v3_0;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class RemoveMultipleAddressBook {
	
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
		driver.get("http://localhost/addressbook/addressbook-3.0/?lang=en");
		driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[1]/td[7]/a/img")).click();

		driver.findElement(By.xpath("(//input[@name='update'])[2]")).click();

		driver.findElement(By.linkText("home")).click();

		assertFalse(driver.findElement(By.tagName("body")).getText().contains("firstname1"));
		assertEquals("Number of results: 2", driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/table/tbody/tr/td[1]/strong")).getText());

		driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[1]/td[7]/a/img")).click();

		driver.findElement(By.xpath("(//input[@name='update'])[2]")).click();

		driver.findElement(By.linkText("home")).click();

		assertFalse(driver.findElement(By.tagName("body")).getText().contains("firstname2"));
		assertEquals("Number of results: 1", driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/table/tbody/tr/td[1]/strong")).getText());

		driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[1]/td[7]/a/img")).click();

		driver.findElement(By.xpath("(//input[@name='update'])[2]")).click();

		driver.findElement(By.linkText("home")).click();

		assertFalse(driver.findElement(By.tagName("body")).getText().contains("firstname3"));
		assertEquals("Number of results: 0", driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/table/tbody/tr/td[1]/strong")).getText());
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
}
