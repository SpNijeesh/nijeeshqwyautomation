package qwy.automationqwy.Pageobject;

import org.openqa.selenium.By;
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
//
//    @FindBy(xpath = "//input[@type='tel']")
//    private WebElement merchantPhone;
//
//    @FindBy(xpath = "//input[@formcontrolname='password']")
//    private WebElement merchantPassword;
//
//    @FindBy(xpath = "//input[@class='select-class ng-untouched ng-pristine ng-invalid']")
//    private WebElement merchantConfirmPassword;
//
//    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm']")
//    private WebElement submitButton;
//    
//    @FindBy(xpath = "//input[@placeholder='Search by Name, Phone No, Email, Api key']")
//    private WebElement searchfeild;
    
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
}