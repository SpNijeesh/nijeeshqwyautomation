package qwy.automationqwy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MerchantWeb {
    ChromeDriver driver;
    private String mobile = "9876543210";
    private String password = "123456789";
    private String receivername = "JohnCena";
    private String receivermobile = "9999999999";
    
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--incognito");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        
        
    }
    @Test(priority = 1)
    public void login() throws Exception {
    	
    	driver.get("https://stage-merchant.qwqer.in/home");
        driver.findElement(By.xpath("//input[@placeholder='Mobile number']")).sendKeys(mobile);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();	
        driver.findElement(By.xpath("//div[@class='weightlistcustom']//div[1]//input[1]")).click();
        driver.findElement(By.xpath("//input[@id='fieldDeliveryPoint']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space()='Saved Address']")).click();
        driver.findElement(By.xpath("//my-tab[@class='ng-star-inserted']//div[@class='pane']//div[1]//div[1]")).click();
        Thread.sleep(2000);
    }
	@Test(priority = 2)
	 public void deatils() {
		 
		 WebElement name= driver.findElement(By.xpath("//input[@formcontrolname='name']"));
		 name.clear();
		 name.sendKeys(receivername);
		 WebElement tel=driver.findElement(By.xpath("//input[@type='tel']"));
		 tel.clear();
		 tel.sendKeys(receivermobile);
		 //driver.findElement(By.xpath("//input[@class='inputMaterial ng-untouched ng-pristine ng-invalid']")).sendKeys(receiverhouseaddress);
		 driver.findElement(By.xpath("//button[@type='submit']")).click();	
	}
	@Test(priority = 3)
	 public void placeOrder() {
		 
		 driver.findElement(By.xpath("//button[normalize-space()='CONTINUE']")).click();
		 driver.findElement(By.xpath("//div[contains(@class,'order-details')]//div[1]//input[1]")).click();
		 driver.findElement(By.xpath("//button[@class='btn custombtnContinue ng-star-inserted']")).click();
		 System.out.println(driver.findElement(By.xpath("//div[contains(@class,'loading-text')]")).getText());
	 
	}
	
	 @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	
	}
	        }
	 }


