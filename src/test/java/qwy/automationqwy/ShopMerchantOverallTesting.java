package qwy.automationqwy;
import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ShopMerchantOverallTesting {
	public class ShopMerchantFramework {
	    private String user = "9999888999";
	    private String pass = "111111111111111";
	    private String textToSend = "Cars and Bikes";
	    private String filePath = "C:\\Users\\Niju\\Downloads\\HyperSport.jpg";
	    private String expectedDownloadPath = "C:\\Users\\Niju\\Downloads\\Inventory_Nijeesh_Trivandrum_27-12-2023.csv";
	    private String newstaffname="NNP";
	    private String newstaffphonenumber="9655741555";
	    private String newstaffpassword="123456789";
	    ChromeDriver driver;
	    @BeforeTest
	    public void setup() {
	    	WebDriverManager.chromedriver().setup();
	    	driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().window().maximize();
	        Map<String, Object> prefs = new HashMap<>();
	        prefs.put("profile.default_content_settings.popups", 0);
	        prefs.put("download.default_directory", "\"C:\\Users\\Niju\\Downloads\\");
	        ChromeOptions options = new ChromeOptions();
	        options.setExperimentalOption("prefs", prefs);
	       
	    }

	    @Test(priority = 1)
	    public void login() {
	    	 driver.get("https://stage-shop-merchant.qwqer.in/");
	        driver.findElement(By.id("customerPhone")).sendKeys(user);
	        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pass);
	        driver.findElement(By.xpath("//span[@class='login-text']")).click();
	      System.out.println("Login success in Shop Merchant");
	    }
	    @Test(priority = 2)
	    public void CategoryLists() {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    	//login();
			List<WebElement> categoryNextPages = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='p-paginator-bottom p-paginator p-component ng-star-inserted']//span//button")));
	        for (WebElement categoryNextPage : categoryNextPages) {
	            // Get the text of each shop
	        	System.out.println("Page No: "+categoryNextPage.getText());
	        	List<WebElement> categoryLists = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tbody[@class='p-element p-datatable-tbody']//tr//td[1]")));
				System.out.println("Available Categories");
		        for (WebElement categoryList : categoryLists) {
		            // Get the text of each shop
		            String categoryNames = categoryList.getText();
		            System.out.println(categoryNames);
		            }
	            categoryNextPage.click();
	            }
	        }

	    @Test(priority=3)
	    public void categorySearch() {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    	//login();
	    	WebElement searchfield = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search Category']")));
	    	searchfield.click();
	    	searchfield.sendKeys("IOS PRIVATE-L2");
	    }
	    @Test(priority=4)
	    public void categoryRequest() throws InterruptedException {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    	//login();
	    	WebElement requestcat = driver.findElement(By.xpath("//button[normalize-space()='Request Category']"));
	    	requestcat.click();
	    	WebElement categoryname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Enter Category Name']")));
	    	categoryname.sendKeys(textToSend); // Category Name
	    	driver.findElement(By.xpath("//div[3]//div[2]//label[1]//span[1]")).click(); //Public/private selection
	        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']")); //File Input
	        fileInput.sendKeys(filePath);
	        driver.findElement(By.xpath("//button[normalize-space()='Request']")).click(); //Submit
	        WebElement submissionmessage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='toast-container']")));
	        String text= submissionmessage.getText();
	        System.out.println(text);
	    	
	    }
	    @Test(priority=5)
	    public void inventoryPageSerach() throws InterruptedException {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	    	//login();
	    	WebElement inventory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[normalize-space()='Inventory']")));
	    	inventory.click();
	    	WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search']")));
	    	search.click();
	    	search.sendKeys("Cadbury Chocobakes ChocFilled Cookies Cream Filled");
	     	Thread.sleep(4000);
	    }
	    @Test(priority=6)
	    public void inventoryEdit() throws InterruptedException {

	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	    	login();
	    	inventoryPageSerach();
	    	WebElement inventoryedit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='button']")));
	    	inventoryedit.click();
	    	WebElement inventoryprice = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select-shop-wrap']//input[@formcontrolname='price']")));
	    	inventoryprice.click();
	    	inventoryprice.clear();
	    	inventoryprice.sendKeys("50");
	    	WebElement inventorudatebutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Update']")));
	    	inventorudatebutton.click();
	    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='toast-container']")));
	    	WebElement updatedprice = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='price-block']")));
	    	updatedprice.getText();
	    	System.out.println("Inventory Updated Successfuly and the price is "+updatedprice.getText());
	    	

}
	    @Test(priority=6)
	    public void inventoryPageCsv() throws InterruptedException {
	    	//login();
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	    	WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search']")));
	    	search.click();
	    	search.clear();
	    	search.sendKeys("Test");
	    	WebElement csvdownload = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Export CSV']")));
	    	csvdownload.click();
	    	WebElement confirmcsv = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Yes']")));
	    	confirmcsv.click();	
	    	Thread.sleep(11000);
	    	File downloadedFile = new File(expectedDownloadPath);


	    	 if (downloadedFile.exists()) {
	    	            System.out.println("File downloaded successfully at: " + expectedDownloadPath);
	    	            // Perform further verification or assertions as needed
	    	        } else {
	    	            System.out.println("File not found at: " + expectedDownloadPath);
	    	            // Handle the scenario where the file isn't downloaded
	    	        }

	    }
	    @Test(priority=7)
	    public void shopList()	
	    {
	    	  driver.navigate().refresh();
	    	  //login();
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	    	WebElement shopselect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='pr_id_2_label']")));
	    	shopselect.click();
	    	List<WebElement> shoplists = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[@class='p-ripple p-element p-dropdown-item']")));

	        for (WebElement shoplist : shoplists) {
	            // Get the text of each shop
	            String text = shoplist.getText();
	            System.out.println(text);
	            }
	    }
	    @Test(priority=8)
	    public void staffPage()	
	    { 
	    	driver.navigate().refresh();
	    	 // login();
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    	WebElement staff = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[normalize-space()='Staffs']")));
	    	staff.click();
	    	List<WebElement> staflists = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tr[@class='table-box-1 ng-star-inserted']//td[2]")));
	    	System.out.println("Available Staff under the Shops ");
	        for (WebElement staflist : staflists) {
	            // Get the text of each shop
	            String text = staflist.getText();
	            System.out.println(text);
	            }
	        
	        WebElement addstaff = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add Staff']")));
	        addstaff.click();
	        
	        WebElement staffname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select-shop-wrap']//input[@placeholder='Enter Staff Name']")));
	        staffname.click();
	        staffname.sendKeys(newstaffname);
	        
	        WebElement staffphone = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select-shop-wrap']//input[@placeholder='Enter Phone Number']")));
	        staffphone.click();
	        staffphone.sendKeys(newstaffphonenumber);
	        
	        WebElement staffpassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select-shop-wrap']//input[@placeholder='Enter Password']")));
	        staffpassword.click();
	        staffpassword.sendKeys(newstaffpassword);
	        
	        WebElement confirmstaff = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
	        confirmstaff.click();
	        WebElement tostermessage = wait.until(ExpectedConditions.elementToBeClickable(By.id("toast-container")));
	        System.out.println(tostermessage.getText());
	        if (tostermessage.getText().contains("Phone number already exists.")) {
                // Display the name of the selected shop and Click on the shop if the text matches
                System.out.println("The staff adding failed");
	        }else
	        {
	        List<WebElement> updatedstaflists = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tr[@class='table-box-1 ng-star-inserted']//td[2]")));
	    	System.out.println("Updated Staff under the Shops ");
	        for (WebElement updatedstaflist : updatedstaflists) {
	            // Get the text of each shop
	            String updatedlist = updatedstaflist.getText();
	            System.out.println(updatedlist);
	            }}
	    }
	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}}
