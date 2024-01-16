package qwy.automationqwy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class CustomerWebTestCases {
	public 	static  String exname= "Nijeesh";
	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://stage-customer.qwqer.in/home");
		driver.findElement(By.xpath("//img[@alt='Trivandrum']")).click();
        driver.findElement(By.xpath("//span[@class='cart-item-name']")).click();
        driver.findElement(By.id("customerPhone")).sendKeys("9037342807");
        driver.findElement(By.name("password")).sendKeys("123456789");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.id("toast-container")).getText());

     
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.cssSelector(".cart-item-name"));
        String actualText = element.getText();
        try {
			if (actualText.equals(exname)) {
			    System.out.println("Login Succes");
			} else {
			    System.out.println("Login Failed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
        Thread.sleep(2000);
        	driver.findElement(By.cssSelector("img[alt='cart']")).click();
        	List<WebElement> cartItems = driver.findElements(By.xpath("//div[@class='col-md-5 shop-details']//span[@class='cart-shop-title']")); 
        	// Print each shops  in the cart
            if (cartItems.size() > 0) {
                System.out.println("Shop Details in the cart");
                for (WebElement item : cartItems) {
                    System.out.println(item.getText());
                }
            } else {
                System.out.println("No items found in the cart.");
            }
		driver.findElement(By.xpath("//span[normalize-space()='Home']")).click();
driver.quit();
	}

}
