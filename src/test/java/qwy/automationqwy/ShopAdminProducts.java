package qwy.automationqwy;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import qwy.automationqwy.Pageobject.Productspage;
import qwy.automationqwy.Pageobject.ShopAdminLoginPage;


public class ShopAdminProducts {
	private ShopAdminLoginPage shopAdminPage;
	private Productspage productspage;
	
	private ChromeDriver driver;
	
	 private String filePath = "C:\\Users\\Niju\\Downloads\\bulkuploadfile.csv";
	 private String productimagepath = "C:\\Users\\Niju\\Downloads\\HyperSport.jpg";
	 
	
	String expectedMessage="Success";
	
	  @BeforeClass
	    public void setUp() throws InterruptedException {
		  WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	        driver.manage().window().maximize();
	        shopAdminPage = new ShopAdminLoginPage(driver);    
	        driver.get("https://stage-shop-admin.qwqer.in/");
	        shopAdminPage.login("Nijeesh", "123456789");  
	        productspage= new Productspage(driver);
	        productspage.productsppageselect();
	       
	    }
	    @Test(priority = 1)
	    public void bulkupload() throws Exception {  
	    	
	    	productspage.bulkupload(filePath);
	    }
	    @Test(priority = 2)
	    public void singleproductadd() throws Exception {
	    	
	    	productspage.singleproductadd(productimagepath);
	    	productspage.singlevariantadd();
	    	productspage.productsubmit();
			}
	    @Test(priority = 3)
	    public void productcsv() throws Exception {
	    	
	    	productspage.productcsv();
			}
	    
	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	 
}
