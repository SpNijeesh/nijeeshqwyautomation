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


public class Productspage {
    private WebDriver driver;
   
    //Promotion page common elements
    
    
    @FindBy(xpath = "//span[@class='menu-link mar']//span[@class='menu-title fs-5 mainColor'][normalize-space()='Products']")
    private WebElement productspagemain;

    @FindBy(xpath = "//a[@class='menu-link without-sub']//span[@class='menu-title fs-5 mainColor'][normalize-space()='Products']")
    private WebElement produtspage;
    
    @FindBy(xpath = "//button[normalize-space()='Bulk Upload']")
    private WebElement bulkupload;

    @FindBy(xpath = "//label[@class='file-upload mb-0 mr-1']/input")
    private WebElement fileInput;

    @FindBy(xpath = "//button[@id='kt_modal_add_customer_submit']")
    private WebElement submitbutton;
    
    //Single Product Add 
    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm dlt-btn ng-star-inserted']")
    private WebElement addnewproduct;
    
    @FindBy(xpath = "//input[@class='form-control mb-2 w-50% ng-untouched ng-pristine ng-invalid']")
    private WebElement productname;
    
    @FindBy(xpath = "//div[@class='p-treeselect-label p-placeholder']")
    private WebElement categorybutton;
    @FindBy(xpath = "//div[@aria-label='Cookware']")
    private WebElement categoryselect;

  
    @FindBy(xpath = "//textarea[@class='form-control mb-2 w-50% ng-untouched ng-pristine ng-invalid']")
    private WebElement productdes;

    @FindBy(xpath = "//input[@class='ng-untouched ng-pristine ng-invalid']")
    private WebElement productimage;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-light-primary']")
    private WebElement variantaddbutton;

    @FindBy(xpath = "//input[@formcontrolname='varientName']")
    private WebElement varientName;
    
    @FindBy(xpath = "//input[@formcontrolname='mrp']")
    private WebElement varaiantmrp;
    
    @FindBy(xpath = "//input[@formcontrolname='sku']")
    private WebElement vaaiantsku;
   
    @FindBy(xpath = "//span[@class='p-dropdown-label p-inputtext p-placeholder ng-star-inserted']")
    private WebElement attributedropdown;
    
    @FindBy(xpath = "//li[@aria-label='38.6 kg']")
    private WebElement attributeselect;
    
    @FindBy(xpath = "//input[@formcontrolname='weight']")
    private WebElement variantweight;
  
    @FindBy(xpath = "//button[@id='kt_modal_add_customer_submit']")
    private WebElement variantsubmit;
    
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement productsubmit;
    
    //product csv
    
    @FindBy(xpath = "//i[@class='fa fa-download']")
    private WebElement productcsv;
 

    private WebDriverWait wait;
    

    public Productspage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
        
    }
    public void productsppageselect()throws InterruptedException
	{
    	productspagemain.click();
    	produtspage.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ngx-spinner[@type='square-jelly-box']")));
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//ngx-spinner[@type='square-jelly-box']")));
    	
	}
    
    public void bulkupload(String filePath)throws InterruptedException
	{
    	bulkupload.click();
    	Thread.sleep(1000);
    	fileInput.sendKeys(filePath);
    	submitbutton.click();
    	
	}  
    public void singleproductadd(String imagefilePath)throws InterruptedException
	{
    
    	addnewproduct.click();
    	Thread.sleep(1000);
    	productname.sendKeys("Test");
    	Thread.sleep(3000);
    	categorybutton.click();
    	Thread.sleep(2000);
    	categoryselect.click();
    	Thread.sleep(2000);
    	productdes.sendKeys("test");
    	Thread.sleep(2000);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
    	Thread.sleep(3000);
    	productimage.sendKeys(imagefilePath);
    	js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
    	Thread.sleep(3000);
	}   

    public void singlevariantadd()throws InterruptedException
    {
    	variantaddbutton.click();
    	varientName.sendKeys("test");
    	varaiantmrp.sendKeys("100");
    	vaaiantsku.sendKeys("545212sdsds");
    	attributedropdown.click();
    	attributeselect.click();
    	variantweight.sendKeys("1");
    	Thread.sleep(3000);
    	variantsubmit.click();
    	Thread.sleep(3000);
    }
    public void productsubmit()throws InterruptedException
    {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        Thread.sleep(2000);
        productsubmit.click();
        Thread.sleep(3000);
        
    }
    
    public void productcsv()throws InterruptedException

    {
    	productcsv.click();
    	Thread.sleep(2000);
    }
}