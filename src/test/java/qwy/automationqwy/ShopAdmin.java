package qwy.automationqwy;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;


public class ShopAdmin {
	private String ShopName= "TestName";
	private String PreviousDay= "05 Mar 2024";
	private String Address="TestAddress";
	private String City="Trivandrum";
	private String pincode= "555555";
	private String statename="Kerala";
	private String email="keralaauto@gmail.com";
	private String mobilenumber="9632589632";
	private String filePath = "C:\\Users\\Niju\\eclipse-workspace\\automationqwy\\src\\main\\java\\qwy\\automationqwy\\resources\\spiderman.jpg";
	private String RegionName = "Trivandrum";
	
	private String MerchantName="QWY SOFT 02";
	private String MerchantEmail="qwysoft@qwy.com";
	private String Merchantphone="8293714651";
	private String Mercahantpassword="123456789";
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
	public void dashboardFilter() throws InterruptedException
	{
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    	WebElement regionClick= driver.findElement(By.xpath("//p[@class='ng-star-inserted']"));
    	regionClick.click();
    	WebElement regionSelect= driver.findElement(By.xpath("//input[@role='textbox']"));
    	regionSelect.sendKeys(RegionName);
    	WebElement dropdownselect= driver.findElement(By.xpath("//span[@class='ng-star-inserted']"));
    	dropdownselect.click();  	
    	WebElement fromDate= driver.findElement(By.xpath("//input[@class='ng-tns-c48-1 p-inputtext p-component ng-star-inserted']"));
    	fromDate.click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='1']")));
        WebElement previousDate = driver.findElement(By.xpath("//span[normalize-space()='1']"));
        previousDate.click();	    
    	Thread.sleep(2000);
    	WebElement searchbutton= driver.findElement(By.xpath("//button[@type='submit']"));
    	searchbutton.click(); 	
    	Thread.sleep(2000);
    	WebElement SelectedRegion = driver.findElement(By.xpath("//div[@class='selected-item-text']"));
    	String ActualRegion = SelectedRegion.getText();
        Assert.assertEquals(ActualRegion, RegionName, "Actual Region does not match expected Region");    
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='reset']")));
        WebElement Searchclear=driver.findElement(By.xpath("//button[@type='reset']"));
        Searchclear.click();
        Thread.sleep(2000);
		
	}
    
    
	@Test(priority = 3)
	public void erpStatus() throws InterruptedException
	{
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='ng-tns-c48-1 p-inputtext p-component ng-star-inserted']")));
    	WebElement fromDate= driver.findElement(By.xpath("//input[@class='ng-tns-c48-1 p-inputtext p-component ng-star-inserted']"));
    	fromDate.click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='1']")));
        WebElement previousDate = driver.findElement(By.xpath("//span[normalize-space()='1']"));
        previousDate.click();	
		WebElement submitbutton= driver.findElement(By.xpath("//button[@type='submit']"));
		submitbutton.click();
		Thread.sleep(2000);
		WebElement erp=driver.findElement(By.xpath("//div[@id='kt_app_main']//div[11]//div[2]//span[1]"));
		String text= erp.getText();
		System.out.println("No of ERP fail :"+text);
       Assert.assertTrue(Integer.parseInt(text) <= 0, "No of ERP fail is greater than 0: " + text);
	
	}	
	
	@Test(priority = 4)
	public void merchantAdd() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='menu-link mar']//span[@class='menu-title fs-5 mainColor'][normalize-space()='Shops']")));
    	WebElement mainShops= driver.findElement(By.xpath("//span[@class='menu-link mar']//span[@class='menu-title fs-5 mainColor'][normalize-space()='Shops']"));
    	mainShops.click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Merchants']")));
    	WebElement merchants= driver.findElement(By.xpath("//span[normalize-space()='Merchants']"));
    	merchants.click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add New']")));
    	WebElement addMerchant= driver.findElement(By.xpath("//button[normalize-space()='Add New']"));
    	addMerchant.click();
    	WebElement merchantName= driver.findElement(By.xpath("//input[@formcontrolname='name']"));
    	merchantName.sendKeys(MerchantName);
    	WebElement merchantEmail= driver.findElement(By.xpath("//input[@type='email']"));
    	merchantEmail.sendKeys(MerchantEmail);
    	WebElement merchantphone =driver.findElement(By.xpath("//input[@type='tel']"));
    	merchantphone.sendKeys(Merchantphone);
    	WebElement mercahantpassword= driver.findElement(By.xpath("//input[@formcontrolname='password']"));
    	mercahantpassword.sendKeys(Mercahantpassword);
    	WebElement mercahantConfirmpassword= driver.findElement(By.xpath("//input[@class='select-class ng-untouched ng-pristine ng-invalid']"));
    	mercahantConfirmpassword.sendKeys(Mercahantpassword);
    	WebElement SubmitButton= driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm']"));
    	SubmitButton.click();
    	Thread.sleep(5000);		
	}
	
	@Test(priority = 5)
	public void shopPageselection() throws InterruptedException
	{

		driver.findElement(By.xpath("//span[@class='menu-link mar']"
				+ "//span[@class='menu-title fs-5 mainColor'][normalize-space()='Shops']")).click();
		driver.findElement(By.xpath("//a[@class='menu-link without-sub']"
				+ "//span[@class='menu-title fs-5 mainColor'][normalize-space()='Shops']")).click();
		Thread.sleep(3000);
		
	}
	
	@Test(priority = 5)
	public void merchantfilter() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='menu-link mar']//span[@class='menu-title fs-5 mainColor'][normalize-space()='Shops']")));
    	WebElement mainShops= driver.findElement(By.xpath("//span[@class='menu-link mar']//span[@class='menu-title fs-5 mainColor'][normalize-space()='Shops']"));
    	mainShops.click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Merchants']")));
    	WebElement merchants= driver.findElement(By.xpath("//span[normalize-space()='Merchants']"));
    	merchants.click();
    	Thread.sleep(2000);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='ng-tns-c48-5 p-inputtext p-component ng-star-inserted']")));
    	WebElement datefilterfrom= driver.findElement(By.xpath("//input[@class='ng-tns-c48-5 p-inputtext p-component ng-star-inserted']"));
    	
    	datefilterfrom.click();
    	Thread.sleep(2000);
		
	}
	
	
	
//	@Test(priority = 3)
//	public void shopCsvDownload() throws InterruptedException
//	{
//	driver.findElement(By.xpath("//button[normalize-space()='CSV']")).click();
//	driver.findElement(By.xpath("//button[normalize-space()='Download']")).click();
//	Thread.sleep(10000);
//	
//	}
//	@Test(priority = 4)
//	public void shopSearch() throws InterruptedException {
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//    String shopName = "Nijeesh_Trivandrum";
//    WebElement searchbar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search by Name, Phone No']")));
//    searchbar.sendKeys(shopName);
//    WebElement searchsubmit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
//    searchsubmit.click();
//
//	}
//	
//	@Test(priority = 5)
//	public void shopDetails() throws InterruptedException
//	{
//	Thread.sleep(2000);
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));	
//  
//	WebElement shopslect=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='p-element shop-name']")));
//	shopslect.click();
//	Thread.sleep(2000);
//	driver.navigate().back();
//	Thread.sleep(2000);
//	}
@Test(priority = 6)
public void shopAdd() throws InterruptedException
{
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
	   
		WebElement addNew=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add New']")));
		addNew.click();
		WebElement fileInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@class='btn btn-icon btn-circle btn-active-color-primary w-25px h-25px bg-body shadow']")));		fileInput.sendKeys(filePath);
		 Actions actions = new Actions(driver);
		    actions.moveToElement(fileInput).click().build().perform();
		    Thread.sleep(1000);
		    actions.sendKeys(filePath).build().perform();
		    Thread.sleep(1000);
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
		 js.executeScript("window.scrollTo(0, document.body.scrollHeight / 1 - 100);");
		WebElement saturday=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@formgroupname='saturday']//div[@class='py-3 d-flex flex-stack flex-wrap']//div//input[@value='true']")));
		saturday.click();
		WebElement starttime7=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@formgroupname='saturday']//div[@class='row row-cols-1 row-cols-sm-2 rol-cols-md-1 row-cols-lg-2']//input[@type='time']")));
		starttime7.sendKeys("1200AM");		
		WebElement endtime7=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@formgroupname='saturday']//div[@class='row row-cols-1 row-cols-sm-2 rol-cols-md-1 row-cols-lg-2 mt-1']//input[@type='time']")));
		endtime7.sendKeys("1159PM");
		Thread.sleep(1000);	
		js.executeScript("window.scrollTo({ top: 0, behavior: 'smooth' });");
		Thread.sleep(1000);
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
		Thread.sleep(3000);
		WebElement Shop=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@formcontrolname='name']")));
		Shop.click();
		Shop.sendKeys(ShopName);
		WebElement ShopAddress=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='card-body pt-0 mt-3']//div[4]//div[1]//div[1]//input[1]")));
		ShopAddress.click();
		ShopAddress.sendKeys(Address);
		WebElement ShopCity=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@formcontrolname='city']")));
		ShopCity.click();
		ShopCity.sendKeys(City);
		WebElement Shoppincode=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@formcontrolname='pincode']")));
		Shoppincode.click();
		Shoppincode.sendKeys(pincode);
		WebElement ShopState=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@formcontrolname='state']")));
		ShopState.click();
		ShopState.sendKeys(statename);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight / 2 - 200);");
		WebElement ShopEmail=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@formcontrolname='shop_email']")));
		ShopEmail.click();
		ShopEmail.sendKeys(email);
		WebElement ShopContact=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@formcontrolname='shop_phone_number']")));
		ShopContact.click();
		ShopContact.sendKeys(mobilenumber);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight / 3 - 200);");
		Thread.sleep(3000);
		WebElement MerchantSection=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Select Merchant']")));
		MerchantSection.click();
		WebElement Merchanttext=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='p-dropdown-filter p-inputtext p-component']")));
		Merchanttext.click();
		Merchanttext.sendKeys("Nijeesh");
		WebElement Merchantselect=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='ng-star-inserted'][normalize-space()='Nijeesh']")));
		Merchantselect.click();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight / 2 - 200);");
		Thread.sleep(2000);
		//span[normalize-space()='Select Stage']
		WebElement SelectStage=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Select Stage']")));
		SelectStage.click();
		WebElement Stagetocancel=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Awaiting PickUp']")));
		Stagetocancel.click();
		WebElement distancefordelivery=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@formcontrolname='distance_in_meters']")));
		distancefordelivery.click();
		distancefordelivery.sendKeys("10000");
		WebElement shopapikey=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@formcontrolname='shop_api_key']")));
		shopapikey.click();
		shopapikey.sendKeys("dfdffgfgffgfgfgfg");
		WebElement shoperoref=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@formcontrolname='shop_erp_ref']")));
		shoperoref.click();
		shoperoref.sendKeys("54212er");
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
