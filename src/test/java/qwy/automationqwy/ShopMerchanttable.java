package qwy.automationqwy;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ShopMerchanttable {
	public class ShopMerchantFramework {
	    private String user = "9999888999";
	    private String pass = "111111111111111";
	    ChromeDriver driver;
	    
	    @Test
	    public void setup() throws Throwable 
	    {
	    	WebDriverManager.chromedriver().setup();
	    	driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().window().maximize();
			driver.get("https://stage-shop-merchant.qwqer.in/");
		    driver.findElement(By.id("customerPhone")).sendKeys(user);
		    driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pass);
		    driver.findElement(By.xpath("//span[@class='login-text']")).click();
		    Thread.sleep(2000);
		    
            List<WebElement> categoryListItems= driver.findElements(By.xpath("//tbody[@class='p-element p-datatable-tbody']//tr//td[1]"));
            WebElement categoryNextPages= driver.findElement(By.xpath("//span[@class='p-paginator-icon pi pi-angle-right']"));
            
                
            for (WebElement categoryList : categoryListItems) {
                String categoryNames = categoryList.getText();
                System.out.println(categoryNames);
            if(categoryNextPages.isEnabled()) {
            	categoryNextPages.click();
            }break;
            }
            }
	    }
	    
	}