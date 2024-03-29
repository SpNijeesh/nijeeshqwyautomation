package sampletest;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import qwy.automationqwy.Pageobject.ShopAdminLoginPage;

public class categorytest {
    private ChromeDriver driver;
    private ShopAdminLoginPage shopAdminPage;
    @BeforeTest
    public void setUp() throws InterruptedException 
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.default_directory", "\"C:\\Users\\Niju\\Downloads\\");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        shopAdminPage = new ShopAdminLoginPage(driver);
        driver.get("https://stage-shop-admin.qwqer.in/");
        shopAdminPage.login("Nijeesh", "123456789");
        Thread.sleep(2000);
        WebElement categorypageselect= driver.findElement(By.xpath("//span[normalize-space()='Categories']"));
    	categorypageselect.click();

}
    @Test(priority = 1)
    public void categorysearch() throws InterruptedException { 	
    	
    	//@FindBy(xpath = "(//span[normalize-space()='Categories'])[3]")
        WebElement categorysubpageselect= driver.findElement(By.xpath("(//span[normalize-space()='Categories'])[3]"));
        categorysubpageselect.click();
        Thread.sleep(2000);
        WebElement categorysearch = driver.findElement(By.xpath("//input[@placeholder='Search by Category']"));
        categorysearch.sendKeys("Migration Cat Mar");
        WebElement search = driver.findElement(By.xpath("//button[normalize-space()='Search']"));
        search.click();
        Thread.sleep(2000);
    }
    @Test(priority = 2)
    public void subcategoryadd() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement expand = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@ptooltip='Expand']")));
        expand.click();
        
        Thread.sleep(2000);
        WebElement addsub1 = driver.findElement(By.xpath("//button[@type='submit'][normalize-space()='New']"));
        addsub1.click();
        Thread.sleep(2000);
        WebElement subcat1name = driver.findElement(By.xpath("//input[@placeholder='Enter Name']"));
        subcat1name.sendKeys("Test02");       
        WebElement fileInput =driver.findElement(By.xpath("//div[@class='content mt-3 ng-star-inserted']/input[@type='file']"));
		String projectpath= System.getProperty("user.dir");
		fileInput.sendKeys(projectpath+"\\files\\category.png");
        WebElement submitcat=driver.findElement(By.id("kt_modal_add_customer_submit"));
        submitcat.click();
    }
    
}