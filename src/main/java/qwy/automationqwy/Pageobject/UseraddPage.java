package qwy.automationqwy.Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class UseraddPage {
    private WebDriver driver;
    
    //Promotion page common elements
    
    
    @FindBy(xpath = "//span[contains(text(),'Settings')]")
    private WebElement settingspage;
    
    @FindBy(xpath = "//body/app-layout[@class='ng-star-inserted']/div[@id='kt_app_root']/div[@id='kt_app_page']/div[@id='kt_app_wrapper']/app-sidebar[@id='kt_app_sidebar']/app-sidebar-menu[@class='app-sidebar-menu overflow-hidden flex-column-fluid']/div[@id='kt_app_sidebar_menu_wrapper']/div[@id='#kt_app_sidebar_menu']/div[1]")
    private WebElement forscrollclick;
    
    @FindBy(xpath = "//span[normalize-space()='User Access Config']")
    private WebElement usercofing;
    
    @FindBy(xpath = "//button[normalize-space()='Add User']")
	WebElement adduserbutton;

    @FindBy(xpath = "//input[@formcontrolname='name']")
	WebElement username;

    @FindBy(xpath = "//li[@aria-label='Tester']")
	WebElement roleselect;

    @FindBy(xpath = "//span[@class='p-dropdown-label p-inputtext p-placeholder ng-star-inserted']")
	WebElement dropsown;
	
    @FindBy(xpath = "//input[@type='email']")
    WebElement useremail;

    @FindBy(xpath = "//input[@type='tel']")
	WebElement userph;

    @FindBy(xpath = "//input[@formcontrolname='password']")
	WebElement password;
	
    @FindBy(xpath = "//input[@formcontrolname='confirm']")
    WebElement confirmpassword;
	
    @FindBy(xpath = "//span[@class='indicator-label']")
    WebElement submituser;

    @FindBy(xpath = "//i[@class='ki-duotone ki-cross fs-1']//span[@class='path2']")
    WebElement closebutton;

    @FindBy(xpath = " //modal-container[@role='dialog']")
    WebElement clickany;
 
    
    public UseraddPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void userpageselect()throws InterruptedException
	{
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	forscrollclick.click();
        js.executeScript("window.scrollBy(0, 500);");
    	settingspage.click();
    	Thread.sleep(2000); 
    	usercofing.click();	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ngx-spinner[@type='square-jelly-box']")));
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//ngx-spinner[@type='square-jelly-box']")));
    	
	}
	public void adduser()throws InterruptedException
	{
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
    	adduserbutton.click();
    	Thread.sleep(2000);
    	username.sendKeys("User 03");
    	dropsown.click();
    	Thread.sleep(2000);
    	roleselect.click();
    	useremail.sendKeys("nsw@test.com");
    	userph.sendKeys("9283614009");
    	password.sendKeys("12345678");
    	confirmpassword.sendKeys("12345678");
    	submituser.click();
    	Thread.sleep(2000);
    //	clickany.click();
    	//driver.navigate().refresh();
    	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ngx-spinner[@type='square-jelly-box']")));
	   // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//ngx-spinner[@type='square-jelly-box']")));
		}
	
	public void addexistinguser()throws InterruptedException
	{
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	   
    	adduserbutton.click();
    	Thread.sleep(2000);
    	username.sendKeys("Test Auto User");
    	dropsown.click();
    	Thread.sleep(2000);
    	roleselect.click();
    	useremail.sendKeys("ns@test.com");
    	userph.sendKeys("9382614613");
    	password.sendKeys("12345678");
    	confirmpassword.sendKeys("12345678");
    	submituser.click();
    	Thread.sleep(2000);
		}
		
}