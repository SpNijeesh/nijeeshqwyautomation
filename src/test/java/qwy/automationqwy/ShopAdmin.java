package qwy.automationqwy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShopAdmin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://stage-shop-admin.qwqer.in/");
		driver.findElement(By.name("username")).sendKeys("QATEST");
		driver.findElement(By.name("password")).sendKeys("123456789");
		driver.findElement(By.xpath("//button[@id='kt_sign_in_submit']")).click();
		driver.findElement(By.xpath("//span[@class='menu-link mar']//span[@class='menu-title fs-5 mainColor'][normalize-space()='Orders']")).click();
		driver.findElement(By.xpath("//a[@class='menu-link without-sub']//span[@class='menu-title fs-5 mainColor'][normalize-space()='Orders']")).click();
		Thread.sleep(2000);
		WebElement orderIdCell = driver.findElement(By.xpath("//span[normalize-space()='QS10471']"));

        // Click on the cell with 'Order ID'
		String Actual=orderIdCell.getText();
		if (Actual.equals("QS10471"))
		{
        orderIdCell.click();
        WebElement orderdetail = driver.findElement(By.xpath("//span[contains(text(),'Approved')]"));
        System.out.println("Shop Admin Order Status is : "+orderdetail.getText());
		}
	}

}
