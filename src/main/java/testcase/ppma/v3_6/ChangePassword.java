package testcase.ppma.v3_6;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertEquals;
public class ChangePassword {
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
        driver.get("http://localhost/ppma/ppma-3.6/");
        driver.findElement(By.id("user")).sendKeys("admin");
        driver.findElement(By.id("pwd")).sendKeys("1234567");
        driver.findElement(By.id("chk")).click();
        Thread.sleep(3000);





        driver.findElement(By.id("oldpassword")).sendKeys("1234567");
        driver.findElement(By.id("pwd")).sendKeys("12345678");
        driver.findElement(By.id("pwd1")).sendKeys("12345678");
        driver.findElement(By.id("changepw")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(5000);

        driver.findElement(By.id("user")).sendKeys("admin");
        driver.findElement(By.id("pwd")).sendKeys("12345678");
        driver.findElement(By.id("chk")).click();
        Thread.sleep(3000);

        assertEquals("Log Out", driver.findElement(By.cssSelector(".btn-info")).getAttribute("value"));


        driver.findElement(By.cssSelector(".btn-info")).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
