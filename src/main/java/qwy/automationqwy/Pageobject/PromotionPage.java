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

public class PromotionPage {
    private WebDriver driver;
    
    @FindBy(xpath = "//span[normalize-space()='Promotions']")
    private WebElement promotionpageselect;

    @FindBy(xpath = "//div[@class='p-multiselect-label p-placeholder']")
    private WebElement regionoption;
    
    @FindBy(xpath = "//input[@role='textbox']")
    private WebElement regiontext;

    @FindBy(xpath = "//span[@class='ng-star-inserted']")
    private WebElement selectregion;

    @FindBy(xpath = "//input[@placeholder='Search by Title, Code']")
    private WebElement promotionnamesearch;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm ng-star-inserted']")
    private WebElement promotionaddbutton;

    @FindBy(xpath = "//input[@formcontrolname='title']")
    private WebElement promotiontitle;

    @FindBy(xpath = "//input[@formcontrolname='description']")
    private WebElement promotiondescription;

    @FindBy(xpath = "//input[@formcontrolname='code']")
    private WebElement promotioncode;
    
    @FindBy(xpath = "//span[@class='p-dropdown-label p-inputtext p-placeholder ng-star-inserted']")
    private WebElement dropdown;
    
    @FindBy(xpath = "//li[@aria-label='Single Region']")
    private WebElement SingleRegion;
    
    @FindBy(xpath = "//input[@class='select-class mt-2 ng-untouched ng-pristine ng-invalid']")
    private WebElement priority;

    @FindBy(xpath = "//div[@class='content ng-star-inserted']/input[@type='file']")
    private WebElement fileInput;
    
    @FindBy(xpath = "//input[@placeholder='No date selected']")
    private WebElement startdate;
    
    @FindBy(xpath = "//span[normalize-space()='15']")
    private WebElement startday;
    
    @FindBy(xpath = "(//input[@placeholder='No date selected'])[2]")
    private WebElement enddate;
    
    @FindBy(xpath = "//span[normalize-space()='15']")
    private WebElement endday;
    
    @FindBy(xpath = "//button[@id='kt_modal_add_customer_submit']")
    private WebElement submitpromotion;
  
    @FindBy(xpath = "//span[@class='p-dropdown-label p-inputtext p-placeholder ng-star-inserted']")
    private WebElement selectregionforpromotion;
    
    @FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']")
    private WebElement regionenter;
    
    @FindBy(xpath = "//span[@class='ng-star-inserted']")
    private WebElement selregion;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;
       
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchbutton;
 

    public PromotionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

	public void promotionsFilter(String regionname)throws InterruptedException
	{
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		promotionpageselect.click();
		Thread.sleep(2000);
		regionoption.click();
		Thread.sleep(2000);
		regiontext.sendKeys(regionname);
		Thread.sleep(2000);
		selectregion.click();
		Thread.sleep(2000);
		searchbutton.click();

	}
	
	public void promotionsnamesearch(String promotionname)throws InterruptedException
	{
		promotionpageselect.click();
		Thread.sleep(2000);
		promotionnamesearch.click();
		promotionnamesearch.sendKeys(promotionname);
		searchbutton.click();
		Thread.sleep(3000);
	
	}
	

	public void addregionpromotions(String title,String descrpition,String code,String filePath)throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		promotionpageselect.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='p-multiselect-label p-placeholder']")));
		promotionaddbutton.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@formcontrolname='title']")));
		promotiontitle.sendKeys(title);	
		promotiondescription.sendKeys(descrpition);	
		promotioncode.sendKeys(code);
		dropdown.click();
		SingleRegion.click();
	    selectregionforpromotion.click();
	    regionenter.click();
	    regionenter.sendKeys("Trivandrum");
	    selregion.click();   
	    startdate.click();
	    Thread.sleep(2000);
	    startday.click();
	    Thread.sleep(2000);
	    enddate.click();
	    Thread.sleep(2000);
	    endday.click();
	    Thread.sleep(2000);
	    priority.sendKeys("10");
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fileInput);
       Thread.sleep(2000);
		String projectpath= System.getProperty("user.dir");
		fileInput.sendKeys(projectpath+"\\files\\promotionsample.png");
		//
//		WebElement fileIn = wait.until(ExpectedConditions.elementToBeClickable(this.fileInput));
//		fileIn.sendKeys(filePath);
	    Thread.sleep(3000);
	    submitpromotion.click();
	    Thread.sleep(3000);
	    
		
	}
	public void addregion()throws InterruptedException
	{
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	promotionpageselect.click();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='p-multiselect-label p-placeholder']")));

	promotionaddbutton.click();
	Thread.sleep(1000);
	 WebElement Regiondate= driver.findElement(By.xpath("//input[@placeholder='No date selected']"));
	 Regiondate.click();
    Thread.sleep(1000);

	
	}
}