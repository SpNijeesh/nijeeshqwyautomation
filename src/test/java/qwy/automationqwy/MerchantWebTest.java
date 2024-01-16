package qwy.automationqwy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import qwy.automationqwy.Pageobject.MerchantWebLoginPage;

public class MerchantWebTest {
    ChromeDriver driver;
    private String mobile = "9876543210";
    private String password = "123456789";
    private String receivername = "JohnCena";
    private String receivermobile = "9999999999";
    
    MerchantWebLoginPage merchantWebLoginPage = new MerchantWebLoginPage(driver);
 
    
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
  
    }
    @Test(priority = 1)
    public void login() throws Exception {
    	
    	 merchantWebLoginPage = new MerchantWebLoginPage(driver);
    	driver.get("https://stage-merchant.qwqer.in/home");
    	merchantWebLoginPage.loginApplication(mobile, password);
    	Thread.sleep(2000);
    }
    @Test
    public void placeanorder() throws Throwable
    {
    	Thread.sleep(2000);
    	merchantWebLoginPage.placetheOrder();
    }
    
    	
    }
//WebElement searchfield = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='weightlistcustom']//div[1]//input[1]")));
//searchfield.click();

//driver.findElement(By.xpath("//div[@class='weightlistcustom']//div[1]//input[1]")).click();
//driver.findElement(By.xpath("//input[@id='fieldDeliveryPoint']")).click();
//Thread.sleep(2000);
//driver.findElement(By.xpath("//a[normalize-space()='Saved Address']")).click();
//driver.findElement(By.xpath("//my-tab[@class='ng-star-inserted']//div[@class='pane']//div[1]//div[1]")).click();
//Thread.sleep(2000);
  
//	@Test(priority = 2)
//	 public void deatils() {
//		 
//		 WebElement name= driver.findElement(By.xpath("//input[@formcontrolname='name']"));
//		 name.clear();
//		 name.sendKeys(receivername);
//		 WebElement tel=driver.findElement(By.xpath("//input[@type='tel']"));
//		 tel.clear();
//		 tel.sendKeys(receivermobile);
//		 driver.findElement(By.xpath("//button[@type='submit']")).click();	
//	}
//	@Test(priority = 3)
//	 public void placeOrder() {
//		 
//		 driver.findElement(By.xpath("//button[normalize-space()='CONTINUE']")).click();
//		 driver.findElement(By.xpath("//div[contains(@class,'order-details')]//div[1]//input[1]")).click();
//		 driver.findElement(By.xpath("//button[@class='btn custombtnContinue ng-star-inserted']")).click();
//		 System.out.println(driver.findElement(By.xpath("//div[contains(@class,'loading-text')]")).getText());
//	 
//	}
//	
//	 @AfterClass
//	    public void tearDown() {
//	        if (driver != null) {
//	            driver.quit();
//	
//	}
//	        }
//	 }
//
//
