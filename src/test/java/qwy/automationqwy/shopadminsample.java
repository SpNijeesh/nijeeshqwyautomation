package qwy.automationqwy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class shopadminsample {
	private ChromeDriver driver;
	  @BeforeClass
	    public void setUp() throws InterruptedException {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        driver.manage().window().maximize();
	        driver.get("https://stage-shop-admin.qwqer.in/");
	        driver.findElement(By.name("username")).sendKeys("Nijeesh");
	        driver.findElement(By.name("password")).sendKeys("123456789");
	        driver.findElement(By.xpath("//button[@id='kt_sign_in_submit']")).click();	
	        Thread.sleep(3000);
	    }
	    @Test(priority = 1)
	    public void adduser() throws Exception {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        driver.findElement(By.xpath(" //body/app-layout[@class='ng-star-inserted']/div[@id='kt_app_root']/div[@id='kt_app_page']/div[@id='kt_app_wrapper']/app-sidebar[@id='kt_app_sidebar']/app-sidebar-menu[@class='app-sidebar-menu overflow-hidden flex-column-fluid']/div[@id='kt_app_sidebar_menu_wrapper']/div[@id='#kt_app_sidebar_menu']/div[1]")).click();
	        js.executeScript("window.scrollBy(0, 500);");
	    	driver.findElement(By.xpath("//span[contains(text(),'Settings')]")).click();
	    	Thread.sleep(2000); 
	    	WebElement usercofing = driver.findElement(By.xpath("//span[normalize-space()='User Access Config']"));
	    	usercofing.click();
	    	Thread.sleep(3000);
	    	WebElement adduserbutton= driver.findElement(By.xpath("//button[normalize-space()='Add User']"));
	    	adduserbutton.click();
	    	Thread.sleep(2000);
	    	WebElement username= driver.findElement(By.xpath("//input[@formcontrolname='name']"));
	    	username.sendKeys("Tester");
	    	WebElement dropsown= driver.findElement(By.xpath("//span[@class='p-dropdown-label p-inputtext p-placeholder ng-star-inserted']"));
	    	dropsown.click();
	    	Thread.sleep(2000);
	    	WebElement roleselect= driver.findElement(By.xpath("//li[@aria-label='Tester']"));
	    	roleselect.click();
	    	WebElement useremail= driver.findElement(By.xpath("//input[@type='email']"));
	    	useremail.sendKeys("nsp@test.com");
	    	WebElement userph= driver.findElement(By.xpath("//input[@type='tel']"));
	    	userph.sendKeys("9382714613");
	    	WebElement password= driver.findElement(By.xpath("//input[@formcontrolname='password']"));
	    	password.sendKeys("12345678");
	    	WebElement confirmpassword= driver.findElement(By.xpath("//input[@formcontrolname='confirm']"));
	    	confirmpassword.sendKeys("12345678");
	    	WebElement submituser= driver.findElement(By.xpath("//span[@class='indicator-label']"));
	    	submituser.click();
	    	Thread.sleep(2000);
	    	 
			}
		        }
		 


