package qwy.automationqwy.Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MerchantPage {
    private WebDriver driver;
    
    @FindBy(xpath = "//span[@class='menu-link mar']//span[@class='menu-title fs-5 mainColor'][normalize-space()='Shops']")
    private WebElement mainShops;

    @FindBy(xpath = "//span[normalize-space()='Merchants']")
    private WebElement merchants;
    
    @FindBy(xpath = "//button[normalize-space()='Add New']")
    private WebElement addMerchant;

    @FindBy(xpath = "//input[@formcontrolname='name']")
    private WebElement merchantName;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement merchantEmail;

    @FindBy(xpath = "//input[@type='tel']")
    private WebElement merchantPhone;

    @FindBy(xpath = "//input[@formcontrolname='password']")
    private WebElement merchantPassword;

    @FindBy(xpath = "//input[@class='select-class ng-untouched ng-pristine ng-invalid']")
    private WebElement merchantConfirmPassword;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm']")
    private WebElement submitButton;
    
    @FindBy(xpath = "//input[@placeholder='Search by Name, Phone No, Email, Api key']")
    private WebElement searchfeild;
    
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchbutton;
    
    @FindBy(xpath = "//div[@class='btn btn-sm btn-light btn-flex btn-center btn-active-light-primary']")
    private WebElement actionbutton;

    @FindBy(xpath = "//a[normalize-space()='Edit']")
    private WebElement editoption;
    
    @FindBy(xpath = "//input[@formcontrolname='name']")
    private WebElement editname;
    
    @FindBy(xpath = "//button[@class='btn btn-sm btn-primary']")
    private WebElement editsubmitbutton;
    
    @FindBy(xpath = "//input[@type='phone']")
    private WebElement mphonenumber;
    
    @FindBy(xpath = "//input[@type='email']")
    private WebElement merchantemailedit;
    
    @FindBy(xpath = "//input[@formcontrolname='confirm']")
    private WebElement confirmpass;
    
    @FindBy(xpath = "//span[@class='checkmark']")
    private WebElement thirdpartycheck;
    
    @FindBy(xpath = "//input[@class='ng-tns-c48-5 p-inputtext p-component ng-star-inserted']")
    private WebElement datefilterfrom;

    @FindBy(xpath = "//span[normalize-space()='1']")
    private WebElement previousDate;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;
    
    @FindBy(xpath = "//button[@type='reset']")
    private WebElement searchClear;
  

    public MerchantPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void merchantAdd(String name,String email,String phone,String password) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='menu-link mar']//span[@class='menu-title fs-5 mainColor'][normalize-space()='Shops']")));
    	mainShops.click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Merchants']")));
    	merchants.click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add New']")));
    	addMerchant.click(); 
    	merchantName.sendKeys(name); 
    	merchantEmail.sendKeys(email);
    	merchantPhone.sendKeys(phone);
    	merchantPassword.sendKeys(password);
    	merchantConfirmPassword.sendKeys(password);
    	submitButton.click();
    	Thread.sleep(5000);		
	}
    public void merchantNameEdit(String name,String editedname) throws InterruptedException
	{
    	//Edit the merchant Name 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	mainShops.click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Merchants']")));
    	merchants.click();
    	searchfeild.click();
    	searchfeild.sendKeys(name);
    	searchbutton.click();
    	Thread.sleep(2000);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[8]/div[1]/div[1]/div[1]")));
    	actionbutton.click();
    	Thread.sleep(2000);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Edit']")));
    	editoption.click();
    	Thread.sleep(2000);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@formcontrolname='name']")));
    	editname.clear();
    	editname.sendKeys(editedname);
    	Thread.sleep(2000);
    	editsubmitbutton.click();
    	Thread.sleep(2000);
	}
    public void merchantphonenumber(String name,String phone) throws InterruptedException
    {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	mainShops.click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Merchants']")));
    	merchants.click();
    	searchfeild.click();
    	searchfeild.sendKeys(name);
    	searchbutton.click();
    	Thread.sleep(2000);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[8]/div[1]/div[1]/div[1]")));
    	actionbutton.click();
    	Thread.sleep(2000);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Edit']")));
    	editoption.click();
    	Thread.sleep(2000);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='phone']")));
    	mphonenumber.clear();
    	mphonenumber.sendKeys(phone);
    	Thread.sleep(2000);
    	editsubmitbutton.click();
    	
    }
	public void merchantemail(String name,String email)throws InterruptedException
	
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	mainShops.click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Merchants']")));
    	merchants.click();
    	searchfeild.click();
    	searchfeild.sendKeys(name);
    	searchbutton.click();
    	Thread.sleep(2000);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[8]/div[1]/div[1]/div[1]")));
    	actionbutton.click();
    	Thread.sleep(2000);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Edit']")));
    	editoption.click();
    	Thread.sleep(2000);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']")));
    	merchantemailedit.clear();
    	merchantemailedit.sendKeys(email);
    	Thread.sleep(2000);
    	editsubmitbutton.click();
    	
	}
	
	public void merchantpasswordchange(String name,String password,String confirm)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	mainShops.click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Merchants']")));
    	merchants.click();
    	searchfeild.click();
    	searchfeild.sendKeys(name);
    	searchbutton.click();
    	Thread.sleep(2000);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[8]/div[1]/div[1]/div[1]")));
    	actionbutton.click();
    	Thread.sleep(2000);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Edit']")));
    	editoption.click();
    	Thread.sleep(2000);
    	merchantPassword.sendKeys(password);
    	confirmpass.sendKeys(confirm);
    	editsubmitbutton.click();
		
	}
	public void merchantenablethirdparty()throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	mainShops.click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Merchants']")));
    	merchants.click();
    	searchfeild.click();
    	searchfeild.sendKeys("QWY SOFT 02");
    	searchbutton.click();
    	Thread.sleep(2000);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[8]/div[1]/div[1]/div[1]")));
    	actionbutton.click();
    	Thread.sleep(2000);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Edit']")));
    	editoption.click();
    	Thread.sleep(2000);
    	thirdpartycheck.click();
    	Thread.sleep(2000);
    	editsubmitbutton.click();
    	
	}
	public void merchantfilter()throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	mainShops.click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Merchants']")));
    	merchants.click();
    	Thread.sleep(2000);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='ng-tns-c48-5 p-inputtext p-component ng-star-inserted']")));
    	datefilterfrom.click();
    	previousDate.click();
    	searchbutton.click();
    	Thread.sleep(5000);
    	

	}
}