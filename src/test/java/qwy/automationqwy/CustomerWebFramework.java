package qwy.automationqwy;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class CustomerWebFramework {

    ChromeDriver driver;
    
    private String mobile = "9037342807";
    private String password = "123456789";
    private String expectedText = "Nijeesh_Trivandrum";

   @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--incognito");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://stage-customer.qwqer.in/home");
        
    }
 

    @Test(priority = 2)
    public void performLogin() throws Throwable{
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    	driver.findElement(By.xpath("//img[@alt='Trivandrum']")).click();
        driver.findElement(By.xpath("//span[@class='cart-item-name']")).click();
        driver.findElement(By.id("customerPhone")).sendKeys(mobile);
        driver.findElement(By.name("password")).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))); 
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("toast-container"))); 
        WebElement loginvalidation = driver.findElement(By.id("toast-container"));
        String loginvalidationtext= loginvalidation.getText();
        if (loginvalidationtext.contains("Success")) {
            // Display the name of the selected shop and Click on the shop if the text matches
            System.out.println("Customer Web Login Success");
        }else
        {
		System.out.println("Customer Web Login Failed");
        }
        Thread.sleep(2000);
    }
    @Test(priority = 3)
    public void performAddToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='address']")));
        driver.findElement(By.xpath("//div[@class='address']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='Trivandrum']")));
        driver.findElement(By.xpath("//img[@alt='Trivandrum']")).click();
        // Wait for the elements with the specified class
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='shop-details-name ng-star-inserted']")));

        for (WebElement element : elements) {
            // Get the text of each element
            String text = element.getText();

            // Check if the text matches the expected text
            if (text.equals(expectedText)) {
                // Display the name of the selected shop and Click on the shop if the text matches
                System.out.println("The shop Selected is " + element.getText());
                element.click();
                break; // Stop iterating through elements once a match is found
            }
        }

        // Wait for the 'Add to Cart' button to be clickable and click it
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='shop-detail-container']//div[1]//app-product-card[1]//div[1]//div[1]//div[3]//div[3]//button[1]//div[1]")));
        addToCartButton.click();
    }
@Test(priority = 4)
public void performPayment() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	driver.findElement(By.xpath("//button[@type='submit']")).click(); //proceed to payment
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(), 'COD')]"))); 
	driver.findElement(By.xpath("//div[contains(text(), 'COD')]")).click();//payment Selection with COD
	driver.findElement(By.xpath("//button[contains(text(), 'CONFIRM ORDER')]")).click(); //Confirm the order
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='order-id-text']")));
		WebElement orderID = driver.findElement(By.xpath("//div[@class='order-id-text']")); //order success page
		System.out.println(orderID.getText());
}
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
