package qwy.automationqwy;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ShopAdmin {
	ChromeDriver driver;
    @BeforeClass
		public void login() throws InterruptedException
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://shop-admin.qwqer.in/");
		driver.findElement(By.name("username")).sendKeys("Q A");
		driver.findElement(By.name("password")).sendKeys("123456789");
		driver.findElement(By.xpath("//button[@id='kt_sign_in_submit']")).click();
		Thread.sleep(2000);
		}
	@Test
	public void erpStatus() throws InterruptedException
	{

    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='p-button-icon pi pi-calendar']")));
		WebElement fromDate = driver.findElement(By.xpath("//span[@class='p-button-icon pi pi-calendar']"));
        fromDate.click();
        WebElement previousDate = driver.findElement(By.xpath("//span[normalize-space()='22']"));
        previousDate.click();	
		WebElement submitbutton= driver.findElement(By.xpath("//button[@type='submit']"));
		submitbutton.click();
		Thread.sleep(2000);
		WebElement erp=driver.findElement(By.xpath("//div[@id='kt_app_main']//div[11]//div[2]//span[1]"));
		String text= erp.getText();
		System.out.println("No of ERP fail :"+text);
       Assert.assertTrue(Integer.parseInt(text) <= 0, "No of ERP fail is greater than 0: " + text);
	
	}	

@Test
public void shopCsvDownload() throws InterruptedException
{
	driver.findElement(By.xpath("//span[@class='menu-link mar']"
			+ "//span[@class='menu-title fs-5 mainColor'][normalize-space()='Shops']")).click();
	driver.findElement(By.xpath("//a[@class='menu-link without-sub']"
			+ "//span[@class='menu-title fs-5 mainColor'][normalize-space()='Shops']")).click();
	driver.findElement(By.xpath("//button[normalize-space()='CSV']")).click();
	driver.findElement(By.xpath("//button[normalize-space()='Download']")).click();
	Thread.sleep(10000);
	
}
@Test
public void shopSearch() throws InterruptedException
{
	
}
@Test
public void shopView() throws InterruptedException
{
	
}
@Test
public void shopEnableorDisable() throws InterruptedException
{
	
}
@Test
public void shopEdit() throws InterruptedException
{
	
}
@Test
public void shopInventorySearch() throws InterruptedException
{
	
}
@Test
public void shopInventoryAdd() throws InterruptedException
{
	
}
@Test
public void shopInventoryDownload() throws InterruptedException
{
	
}
@Test
public void shopPriceUpdate() throws InterruptedException
{
	
}
@Test
public void shopInventoryEdit() throws InterruptedException
{
	
}
@Test
public void shopInventoryDelete() throws InterruptedException
{
	
}

@AfterClass

public void tearDown() {
    if (driver != null) {
        driver.quit();
    }
}

}
