package testcase.collabtive.v0_7;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertTrue;
public class OpenTasks {
	
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
		driver.get("http://localhost/collabtive/collabtive-0.7/");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("pass")).sendKeys("admin");
		driver.findElement(By.cssSelector("button.loginbutn")).click();

		driver.findElement(By.xpath(".//*[@id='mainmenue']/li[3]/a")).click();


		driver.findElement(By.linkText("Project001")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(".//*[@id='contentwrapper']/div[1]/ul/li[3]/a")).click();


		driver.findElement(By.xpath("html/body/div[2]/div[2]/div[2]/div/div/div[5]/div[3]/div/a[2]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("html/body/div[2]/div[2]/div[2]/div/div/div[5]/div[2]/div/div/table/tbody[1]/tr[1]/td[1]/a")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("html/body/div[2]/div[2]/div[2]/div/div/div[5]/div[2]/div/div/table/tbody[2]/tr[1]/td[1]/a")).click();
		Thread.sleep(2000);

		driver.navigate().refresh();

		assertTrue(driver.findElement(By.tagName("body")).getText().contains("Task001"));
		assertTrue(driver.findElement(By.tagName("body")).getText().contains("Task002"));

		driver.findElement(By.xpath(".//*[@id='mainmenue']/li[4]/a")).click();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
}
