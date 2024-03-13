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
import qwy.automationqwy.Pageobject.DashboardFilterPage;
import qwy.automationqwy.Pageobject.MerchantPage;
import qwy.automationqwy.Pageobject.PromotionPage;
import qwy.automationqwy.Pageobject.ShopAdminLoginPage;

public class ShopAdminTest {
    private ChromeDriver driver;
    
    //Object creation for Pages
    
    private ShopAdminLoginPage shopAdminPage;
    private MerchantPage merchantpage;
    private DashboardFilterPage dashboardFilterPage;
    private PromotionPage promotionpage;
    
    private String RegionName = "Trivandrum";
    
    //New Merchant Deatils
    
    private String MerchantName="CSK-02";
	private String MerchantEmail="csk02@bcci.com";
	private String Merchantphone="4624258659";
	private String Mercahantpassword="123456789";
	private String ExpectedTosterMessage= "Merchant Updated";
	
	//For Update the Merchant
	private String MerchantNameForSearch="QWY SOFT 05";
	private String MerchantNameForUpdate="QWY SOFT 02";
	private String MerchantEmailForUpdate="new@qwysoft.com";
	private String MerchantMobileForUpdate="5522336611";
	private String MerchantpasswordForUpdate="123456789";
	
	//Promotions
	
	private String promotionnamesearch="DEMOAPR07";
	
    @BeforeClass
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        shopAdminPage = new ShopAdminLoginPage(driver);
        dashboardFilterPage = new DashboardFilterPage(driver);
        merchantpage= new MerchantPage(driver);
        promotionpage= new PromotionPage(driver);
        driver.get("https://stage-shop-admin.qwqer.in/");
        shopAdminPage.login("Nijeesh", "123456789");
        Thread.sleep(2000);
    }

    @Test(priority = 1)
    public void dashboardFilter() throws InterruptedException {
        dashboardFilterPage.filterByRegion(RegionName);
        WebElement SelectedRegion = driver.findElement(By.xpath("//div[@class='selected-item-text']"));
    	String ActualRegion = SelectedRegion.getText();
        Assert.assertEquals(ActualRegion, RegionName, "Actual Region does not match expected Region"); 
        dashboardFilterPage.clearSearch();
        Thread.sleep(2000);
    }
    @Test(priority = 2)
	public void erpStatus() throws InterruptedException
	{
    	dashboardFilterPage.erpStatus();
		Thread.sleep(2000);
		WebElement erp=driver.findElement(By.xpath("//div[@id='kt_app_main']//div[11]//div[2]//span[1]"));
		String text= erp.getText();
		System.out.println("No of ERP fail :"+text);
       Assert.assertTrue(Integer.parseInt(text) <= 0, "No of ERP fail is greater than 0: " + text);
	
	}
    
    @Test(priority = 4)
	public void merchantAdd() throws InterruptedException
	{
    	merchantpage.merchantAdd(MerchantName, MerchantEmail, Merchantphone, Mercahantpassword );
    	WebElement tostermessage= driver.findElement(By.id("toast-container"));
    	String Tostermessagerecived = tostermessage.getText();
    	String expectedMessage = "Merchant Added Succesfully";
    	System.out.println(Tostermessagerecived);
        Assert.assertTrue(Tostermessagerecived.contains(expectedMessage), "Merchant was not added successfully");
	}
    @Test(priority = 5)
	public void merchantEditMerchantName() throws InterruptedException
	{
    	driver.navigate().refresh();
    	merchantpage.merchantNameEdit(MerchantNameForSearch,MerchantNameForUpdate);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("toast-container"))); 
    	WebElement tostermessage= driver.findElement(By.id("toast-container"));
    	String Tostermessagerecived = tostermessage.getText();
        Assert.assertTrue(Tostermessagerecived.contains(ExpectedTosterMessage), Tostermessagerecived);
    	Thread.sleep(2000);
	}
    @Test(priority = 6)
	public void merchantEditMerchantNumber() throws InterruptedException
	{	
    	driver.navigate().refresh();
    	merchantpage.merchantphonenumber(MerchantNameForSearch,MerchantMobileForUpdate);
 
	}
    @Test(priority = 7)
   	public void merchantEditMerchantEmail() throws InterruptedException
   	{	driver.navigate().refresh();
    	merchantpage.merchantemail(MerchantNameForSearch,MerchantEmailForUpdate);
       	
   	}
    @Test(priority = 8)
   	public void merchantEditMerchantPasswor() throws InterruptedException
   	{
    	driver.navigate().refresh();
    	merchantpage.merchantpasswordchange(MerchantNameForSearch,MerchantpasswordForUpdate,MerchantpasswordForUpdate);
    
   	}
    @Test(priority = 9)
   	public void merchantthirdparty() throws InterruptedException
   	{ 
    	driver.navigate().refresh();
    	merchantpage.merchantenablethirdparty();
 
   	}
    @Test(priority = 10)
   	public void merchantfilter() throws InterruptedException
   	{
    	merchantpage.merchantfilter();
    	
   	}
    
    @Test(priority = 11)
   	public void PromotionRegionfilter() throws InterruptedException
   	{
    	promotionpage.promotionsFilter(RegionName);
    	//Aseert
    	
   	}
    @Test(priority = 12)
   	public void PromotionNameSearch() throws InterruptedException
   	{
    	promotionpage.promotionsnamesearch(promotionnamesearch);
    	//Aseert
   	}
    
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}