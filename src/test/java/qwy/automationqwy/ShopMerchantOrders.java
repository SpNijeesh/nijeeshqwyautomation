package qwy.automationqwy;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ShopMerchantOrders {
    private ChromeDriver driver;
    private String user = "9999888999";
    private String pass = "111111111111111";


    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
       
    }

    @Test(priority = 4)
    public void login() {
    	 driver.get("https://stage-shop-merchant.qwqer.in/");
        driver.findElement(By.id("customerPhone")).sendKeys(user);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pass);
        driver.findElement(By.xpath("//span[@class='login-text']")).click();
        System.out.println("Login success in Shop Merchant");
    }

    @Test(priority = 5)
    public void orderModule() throws InterruptedException {
        // Order Module
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='p-dropdown-trigger-icon ng-tns-c50-4 pi pi-chevron-down']")).click(); // shop select
		driver.findElement(By.xpath("//li[@id='p-highlighted-option']")).click(); // shop slection
        driver.findElement(By.xpath("//label[normalize-space()='Orders']")).click(); // order module
        driver.findElement(By.xpath("//tbody/tr[1]/td[5]/div[1]/button[1]")).click(); //  
        driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
        Thread.sleep(2000);
        driver.navigate().refresh();
        driver.findElement(By.xpath("//tbody/tr[1]/td[5]/div[1]/button[1]")).click();
        Thread.sleep(2000);

        String orderId = driver.findElement(By.xpath("//div[@class='col-md-2 header-style']/div[@class='topbar-value-dark']"))
                .getText();
        String orderStatus = driver.findElement(
                By.xpath("//div[@class='col-md-2 content'][3]/div[@class='topbar-value']"))
                .getText();

        System.out.println("Order ID provided " + orderId);
        System.out.println("Order Status is " + orderStatus);
        Thread.sleep(2000);
        driver.navigate().back();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
