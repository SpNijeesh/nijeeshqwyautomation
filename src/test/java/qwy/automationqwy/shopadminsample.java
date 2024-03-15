package qwy.automationqwy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class shopadminsample {
	private ChromeDriver driver;
	  @BeforeClass
	    public void setUp() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        driver.manage().window().maximize();
	        driver.get("https://stage-shop-admin.qwqer.in/");
	        driver.findElement(By.name("username")).sendKeys("Nijeesh");
	        driver.findElement(By.name("password")).sendKeys("123456789");
	        driver.findElement(By.xpath("//button[@id='kt_sign_in_submit']")).click();	
	    }
	    @Test(priority = 1)
	    public void category() throws Exception {
	    	
	    	driver.findElement(By.xpath("//span[normalize-space()='Categories']")).click();	
	    	
	    	driver.findElement(By.xpath("(//span[normalize-space()='Categories'])[3]")).click();	
	    	Thread.sleep(2000);
	    	
	    	driver.findElement(By.xpath("//button[@class='btn btn-sm btn-primary csvBtn w-90px ng-star-inserted']")).click();	
	    	Thread.sleep(2000);
	    	driver.findElement(By.xpath("//input[@formcontrolname='publicCategoryName']")).sendKeys("Test");

	    	
	    	WebElement fileInput = driver.findElement(By.xpath("//div[@class='content mt-3 ng-star-inserted']/input[@type='file']"));	    	
	    	String projectpath= System.getProperty("user.dir");
			fileInput.sendKeys(projectpath+"\\files\\promotionsample.png");
	    	Thread.sleep(2000);
			
	    	driver.findElement(By.id("kt_modal_add_customer_submit")).click();	

	    	 
			}
		        }
		 


