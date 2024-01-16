package qwy.automationqwy;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
	    @BeforeTest
	    public void setup() {
	    	WebDriverManager.chromedriver().setup();
	    	driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().window().maximize();
			 driver.get("https://stage-shop-merchant.qwqer.in/");
		        driver.findElement(By.id("customerPhone")).sendKeys(user);
		        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pass);
		        driver.findElement(By.xpath("//span[@class='login-text']")).click();
		      System.out.println("Login success in Shop Merchant");
	       
	    }
	    @Test(priority=6)
	    public void inventoryEdit() throws InterruptedException {

	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	    	WebElement inventory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[normalize-space()='Inventory']")));
	    	inventory.click();
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody[@class='p-element p-datatable-tbody']")));
	    	String nameToFind = "Test32";
	    	  java.util.List<WebElement> rows = driver.findElements(By.xpath("//tbody[@class='p-element p-datatable-tbody']/tr"));
	    	  for (WebElement row : rows) {
	              // Get the second column data of each row
	              WebElement nameElement = row.findElement(By.xpath("./td[2]"));

	              // Get the text of the name in the second column
	              String productName = nameElement.getText();

	              // Check if the name matches the desired name
	              if (productName.equals(nameToFind)) {
	                  // Click on the action button in the 11th column (assuming button[2])
	                  WebElement actionButton = row.findElement(By.xpath("./td[11]//button[2]"));
	                  actionButton.click();
	                  break; // Stop the loop after clicking the button
	              }
	          }
Thread.sleep(3000);
}  @Test(priority=6)
public void ordes() throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	driver.findElement(By.xpath("//label[normalize-space()='Orders']")).click(); 
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody[@class='p-element p-datatable-tbody']")));

    // Name to search in the table (1st index, first column)
    String nameToFind = "QS10774";

    // Find all rows in the table
    List<WebElement> rows = driver.findElements(By.xpath("//tbody[@class='p-element p-datatable-tbody']/tr"));

    // Iterate through each row to find the name in the first column
    for (WebElement row : rows) {
        // Get the first column data of each row
        WebElement nameElement = row.findElement(By.xpath("./td[1]"));

        // Get the text of the name in the first column
        String productName = nameElement.getText();

        // Check if the name matches the desired name
        if (productName.equals(nameToFind)) {
            // Click on the action button (3rd button in div) in the corresponding row
            WebElement actionButton = row.findElement(By.xpath("//tbody[@class='p-element p-datatable-tbody']/tr/td[1]/div/button[last()]")); //.td[5]/div/button[3]
            actionButton.click();
            break; // Stop the loop after clicking the button
        }
    }
	Thread.sleep(2000);
}
	    
	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}}
