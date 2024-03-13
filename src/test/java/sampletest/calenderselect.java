package sampletest;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class calenderselect {
	ChromeDriver driver;
	 @BeforeClass
		public void login() throws InterruptedException
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://stage-shop-admin.qwqer.in/");
		driver.findElement(By.name("username")).sendKeys("Q A");
		driver.findElement(By.name("password")).sendKeys("123456789");
		driver.findElement(By.xpath("//button[@id='kt_sign_in_submit']")).click();
		Thread.sleep(2000);
		}
	 
	  @Test(priority = 1)
	  public void dashboardDateFilter() throws InterruptedException {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='ng-tns-c48-1 p-inputtext p-component ng-star-inserted']")));
	        
	        WebElement fromDate = driver.findElement(By.xpath("//input[@class='ng-tns-c48-1 p-inputtext p-component ng-star-inserted']"));
	        fromDate.clear();
	        fromDate.sendKeys("01 Feb 2024");
	        WebElement todate = driver.findElement(By.xpath("//input[@class='ng-tns-c48-2 p-inputtext p-component ng-star-inserted']"));
	        todate.click();
	        WebElement todateselect = driver.findElement(By.xpath("//span[@class='p-ripple p-element ng-tns-c48-2 p-highlight ng-star-inserted']"));
	        todateselect.click();	    
	        WebElement searchbutton= driver.findElement(By.xpath("//button[@type='submit']"));
	        searchbutton.click();
	    }
}

