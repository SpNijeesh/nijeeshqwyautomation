package qwy.automationqwy;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.firefoxdriver().setup();
		
		FirefoxDriver driver = new FirefoxDriver();

//ChromeDriver driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
driver.manage().window().maximize();
driver.get("https://stage-customer.qwqer.in/home");
driver.findElement(By.xpath("//div[contains(text(), 'Trivandrum')]")).click();
driver.findElement(By.xpath("//span[@class='cart-item-name']")).click();
driver.findElement(By.id("customerPhone")).sendKeys("9037342807");
driver.findElement(By.name("password")).sendKeys("123456789");
Thread.sleep(2000);
driver.findElement(By.xpath("//button[@type='submit']")).click();
Thread.sleep(2000);
String expectedText = "Nijeesh_Trivandrum";

// Find all elements matching the given selector
List<WebElement> elements = driver.findElements(By.xpath("//div[@class='shop-details-name ng-star-inserted']"));

// Iterate through the matching elements
for (WebElement element : elements) {
    // Get the text of each element
    String text = element.getText();

    // Check if the text matches the expected text
    if (text.equals(expectedText)) {
        // Click on the element if the text matches
        element.click();
        break; // Stop iterating through elements once a match is found
    }
}
List<WebElement> products = driver.findElements(By.xpath("//div[@class='product-item shopcrdhome']//div[@class='product-detail-wrapper']"));
for (WebElement product : products) {
    // Get the text of each element
    String text = product.getText();
    if(text.equals("QK6810"))
    {
    System.out.println(text);
    }
}


// Close the browser window
//driver.quit();

	}
}
