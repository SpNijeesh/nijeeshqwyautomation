package qwy.automationqwy;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomerWebOrder {

    public static void main(String[] args) {
        
        WebDriverManager.chromedriver().setup();

        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://stage-customer.qwqer.in/home");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.findElement(By.xpath("//img[@alt='Trivandrum']")).click();
        driver.findElement(By.xpath("//span[@class='cart-item-name']")).click();
        driver.findElement(By.id("customerPhone")).sendKeys("9037342807");
        driver.findElement(By.name("password")).sendKeys("123456789");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Login Success");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root:nth-child(2) > app-shop:nth-child(2) > app-shop-home:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(10) > div:nth-child(1) > div:nth-child(1) > img:nth-child(1)"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='shop-detail-container']//div[1]//app-product-card[1]//div[1]//div[1]//div[3]//div[3]//button[1]//div[1]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click(); //proceed to payment

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//app-root//div[2]//div[1]//div[2]//img[1]"))).click();  // payment selection COD

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn qw-button-wd qw-btn-primary ng-star-inserted']"))).click(); //Completed order

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='order-id-text']")));
        System.out.println(driver.findElement(By.xpath("//div[@class='order-id-text']")).getText());

        driver.quit();
    }
}
