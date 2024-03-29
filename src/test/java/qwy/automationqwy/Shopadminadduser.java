package qwy.automationqwy;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import qwy.automationqwy.Pageobject.ShopAdminLoginPage;
import qwy.automationqwy.Pageobject.UseraddPage;

public class Shopadminadduser {
	private ShopAdminLoginPage shopAdminPage;
	private UseraddPage userpage;
	
	private ChromeDriver driver;
	
	String expectedMessage="User Added Successfully";
	  @BeforeClass
	    public void setUp() throws InterruptedException {
		  WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	        driver.manage().window().maximize();
	        shopAdminPage = new ShopAdminLoginPage(driver);
	        userpage= new UseraddPage (driver);
	        driver.get("https://stage-shop-admin.qwqer.in/");
	        shopAdminPage.login("Nijeesh", "123456789");
	        userpage.userpageselect();
	       
	    }
	    @Test(priority = 1)
	    public void adduser() throws Exception {
	    
	            userpage.adduser();
	            WebElement tostermessage = driver.findElement(By.id("toast-container"));
	            String Tostermessagerecived = tostermessage.getText();
	            System.out.println(Tostermessagerecived);
	            Assert.assertTrue(Tostermessagerecived.contains(expectedMessage), "User Not Added");
	      
	       	    }
	    
	    @Test(priority = 2)
	    public void addexistinguser() throws Exception {
	    	userpage.addexistinguser();
	    	WebElement tostermessage= driver.findElement(By.id("toast-container"));
	    	String Tostermessagerecived = tostermessage.getText();
	    	System.out.println(Tostermessagerecived);
	        Assert.assertFalse(Tostermessagerecived.contains(expectedMessage), "User Not Added");
	     
			}
	    
	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	 
}
