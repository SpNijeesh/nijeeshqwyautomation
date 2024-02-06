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
import org.openqa.selenium.JavascriptExecutor;

public class ShopAdmin {
	ChromeDriver driver;
    @BeforeClass
		public void login() throws InterruptedException
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://stage-shop-admin.qwqer.in/");
		driver.findElement(By.name("username")).sendKeys("Q A");
		driver.findElement(By.name("password")).sendKeys("123456789");
		driver.findElement(By.xpath("//button[@id='kt_sign_in_submit']")).click();
		Thread.sleep(2000);
		}
	@Test(priority = 1)
	public void erpStatus() throws InterruptedException
	{

    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='p-button-icon pi pi-calendar']")));
		WebElement fromDate = driver.findElement(By.xpath("//span[@class='p-button-icon pi pi-calendar']"));
        fromDate.click();
        WebElement previousDate = driver.findElement(By.xpath("//span[normalize-space()='5']"));
        previousDate.click();	
		WebElement submitbutton= driver.findElement(By.xpath("//button[@type='submit']"));
		submitbutton.click();
		Thread.sleep(2000);
		WebElement erp=driver.findElement(By.xpath("//div[@id='kt_app_main']//div[11]//div[2]//span[1]"));
		String text= erp.getText();
		System.out.println("No of ERP fail :"+text);
       Assert.assertTrue(Integer.parseInt(text) <= 0, "No of ERP fail is greater than 0: " + text);
	
	}	
	@Test(priority = 2)
	public void shopPageselection() throws InterruptedException
	{
		driver.findElement(By.xpath("//span[@class='menu-link mar']"
				+ "//span[@class='menu-title fs-5 mainColor'][normalize-space()='Shops']")).click();
		driver.findElement(By.xpath("//a[@class='menu-link without-sub']"
				+ "//span[@class='menu-title fs-5 mainColor'][normalize-space()='Shops']")).click();
		Thread.sleep(3000);
		
	}
	
//	@Test(priority = 3)
//	public void shopCsvDownload() throws InterruptedException
//	{
//	driver.findElement(By.xpath("//button[normalize-space()='CSV']")).click();
//	driver.findElement(By.xpath("//button[normalize-space()='Download']")).click();
//	Thread.sleep(10000);
//	
//	}
	@Test(priority = 4)
	public void shopSearch() throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    String shopName = "Nijeesh_Trivandrum";
    WebElement searchbar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search by Name, Phone No']")));
    searchbar.sendKeys(shopName);
    WebElement searchsubmit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
    searchsubmit.click();

	}
	
	@Test(priority = 5)
	public void shopDetails() throws InterruptedException
	{
	Thread.sleep(2000);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));	
  
	WebElement shopslect=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='p-element shop-name']")));
	shopslect.click();
	Thread.sleep(2000);
	driver.navigate().back();
	Thread.sleep(2000);
	}
@Test(priority = 6)
public void shopAdd() throws InterruptedException
{
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));	
		WebElement addNew=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add New']")));
		addNew.click();
		WebElement regionsection=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Select a Region']")));
		regionsection.click();
		WebElement regiontext=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='p-dropdown-filter p-inputtext p-component']")));
		regiontext.click();
		regiontext.sendKeys("Trivandrum");
		WebElement regionselect=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='ng-star-inserted']")));
		regionselect.click();
		WebElement locationselect=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@formcontrolname='location']")));
		locationselect.click();
		Thread.sleep(3000);
		WebElement location=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Ok']")));
		location.click();
		WebElement sunday=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@formgroupname='sunday']//div[@class='py-3 d-flex flex-stack flex-wrap']//div//input[@value='true']")));
		sunday.click();
		WebElement starttime=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@formcontrolname='startTime']")));
		starttime.sendKeys("1200AM");
		WebElement endtime=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@formcontrolname='endTime']")));
		endtime.sendKeys("1159PM");	
		Thread.sleep(2000);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo(0, document.body.scrollHeight / 2 - 200);");
	    Thread.sleep(2000);	
		WebElement monday=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@formgroupname='monday']//div[@class='py-3 d-flex flex-stack flex-wrap']//div//input[@value='true']")));
		monday.click();		
		WebElement starttime2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@formgroupname='monday']//div[@class='row row-cols-1 row-cols-sm-2 rol-cols-md-1 row-cols-lg-2']//input[@type='time']")));
		starttime2.sendKeys("1200AM");
		WebElement endtime2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@formgroupname='monday']//div[@class='row row-cols-1 row-cols-sm-2 rol-cols-md-1 row-cols-lg-2 mt-1']//input[@type='time']")));
		endtime2.sendKeys("1159PM");	
		WebElement tuesday=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@formgroupname='tuesday']//div[@class='py-3 d-flex flex-stack flex-wrap']//div//input[@value='true']")));		
		tuesday.click();
		WebElement starttime3=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@formgroupname='tuesday']//div[@class='row row-cols-1 row-cols-sm-2 rol-cols-md-1 row-cols-lg-2']//input[@type='time']")));
		starttime3.sendKeys("1200AM");
		WebElement endtime3=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@formgroupname='tuesday']//div[@class='row row-cols-1 row-cols-sm-2 rol-cols-md-1 row-cols-lg-2 mt-1']//input[@type='time']")));
		endtime3.sendKeys("1159PM");
		WebElement wednesday=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@formgroupname='wednesday']//div[@class='py-3 d-flex flex-stack flex-wrap']//div//input[@value='true']")));
		wednesday.click();
		WebElement starttime4=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@formgroupname='wednesday']//div[@class='row row-cols-1 row-cols-sm-2 rol-cols-md-1 row-cols-lg-2']//input[@type='time']")));
		starttime4.sendKeys("1200AM");
		WebElement endtime4=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@formgroupname='wednesday']//div[@class='row row-cols-1 row-cols-sm-2 rol-cols-md-1 row-cols-lg-2 mt-1']//input[@type='time']")));
		endtime4.sendKeys("1159PM");
		WebElement thursday=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@formgroupname='thursday']//div[@class='py-3 d-flex flex-stack flex-wrap']//div//input[@value='true']")));
		thursday.click();
		WebElement starttime5=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@formgroupname='thursday']//div[@class='row row-cols-1 row-cols-sm-2 rol-cols-md-1 row-cols-lg-2']//input[@type='time']")));
		starttime5.sendKeys("1200AM");
		WebElement endtime5=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@formgroupname='thursday']//div[@class='row row-cols-1 row-cols-sm-2 rol-cols-md-1 row-cols-lg-2 mt-1']//input[@type='time']")));
		endtime5.sendKeys("1159PM");
		WebElement friday=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@formgroupname='friday']//div[@class='py-3 d-flex flex-stack flex-wrap']//div//input[@value='true']")));
		friday.click();
		WebElement starttime6=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@formgroupname='friday']//div[@class='row row-cols-1 row-cols-sm-2 rol-cols-md-1 row-cols-lg-2']//input[@type='time']")));
		starttime6.sendKeys("1200AM");
		WebElement endtime6=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@formgroupname='friday']//div[@class='row row-cols-1 row-cols-sm-2 rol-cols-md-1 row-cols-lg-2 mt-1']//input[@type='time']")));
		endtime6.sendKeys("1159PM");
		 js.executeScript("window.scrollTo(0, document.body.scrollHeight / 2 - 200);");
		WebElement saturday=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@formgroupname='saturday']//div[@class='py-3 d-flex flex-stack flex-wrap']//div//input[@value='true']")));
		saturday.click();
		WebElement starttime7=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@formgroupname='saturday']//div[@class='row row-cols-1 row-cols-sm-2 rol-cols-md-1 row-cols-lg-2']//input[@type='time']")));
		starttime7.sendKeys("1200AM");		
		WebElement endtime7=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@formgroupname='saturday']//div[@class='row row-cols-1 row-cols-sm-2 rol-cols-md-1 row-cols-lg-2 mt-1']//input[@type='time']")));
		endtime7.sendKeys("1159PM");
		Thread.sleep(2000);	
		
		
		
}
//@Test
//public void shopInventorySearch() throws InterruptedException
//{
//	
//}
//@Test
//public void shopInventoryAdd() throws InterruptedException
//{
//	
//}
//@Test
//public void shopInventoryDownload() throws InterruptedException
//{
//	
//}
//@Test
//public void shopPriceUpdate() throws InterruptedException
//{
//	
//}
//@Test
//public void shopInventoryEdit() throws InterruptedException
//{
//	
//}
//@Test
//public void shopInventoryDelete() throws InterruptedException
//{
//	
//}

@AfterClass

public void tearDown() {
    if (driver != null) {
        driver.quit();
    }
}

}
