package qwy.automationqwy.Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardFilterPage {
    private WebDriver driver;
    
    @FindBy(xpath = "//p[@class='ng-star-inserted']")
    private WebElement regionClick;

    @FindBy(xpath = "//input[@role='textbox']")
    private WebElement regionSelect;

    @FindBy(xpath = "//span[@class='ng-star-inserted']")
    private WebElement dropdownSelect;

    @FindBy(xpath = "//input[@class='ng-tns-c48-1 p-inputtext p-component ng-star-inserted']")
    private WebElement fromDate;

    @FindBy(xpath = "//span[normalize-space()='1']")
    private WebElement previousDate;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;
    
    @FindBy(xpath = "//button[@type='reset']")
    private WebElement searchClear;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    public DashboardFilterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void filterByRegion(String regionName) {
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        regionClick.click();
        regionSelect.sendKeys(regionName);
        dropdownSelect.click();
        fromDate.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='1']")));
        previousDate.click();
        searchButton.click();
              
    }

    public void clearSearch() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='reset']")));
        searchClear.click();
    	
    }
    public void erpStatus()
	{
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='ng-tns-c48-1 p-inputtext p-component ng-star-inserted']")));
    	fromDate.click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='1']")));
        previousDate.click();	
		searchButton.click();
	}
}