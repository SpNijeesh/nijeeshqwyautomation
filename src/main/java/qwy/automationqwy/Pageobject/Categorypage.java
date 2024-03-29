package qwy.automationqwy.Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Categorypage {
    private WebDriver driver;
    
    @FindBy(xpath = "//span[normalize-space()='Categories']")
    private WebElement categorypageselect;

    @FindBy(xpath = "(//span[normalize-space()='Categories'])[3]")
    private WebElement categorysubpageselect;
    
    @FindBy(xpath = "//button[@class='btn btn-sm btn-primary csvBtn w-90px ng-star-inserted']")
    private WebElement addnew;

    @FindBy(xpath = "//input[@placeholder='Enter Name']")
    private WebElement newcatname;
    
    @FindBy(xpath = "//div[@class='content mt-3 ng-star-inserted']/input[@type='file']")
    private WebElement fileInput;
    
    @FindBy(id = "kt_modal_add_customer_submit")
    private WebElement submitcat;
    
   

    public Categorypage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

	public void CategoryAdd()throws InterruptedException
	{

		categorypageselect.click();
		categorysubpageselect.click();
		addnew.click();
		newcatname.sendKeys("Nijeesh-Automation");
		String projectpath= System.getProperty("user.dir");
		fileInput.sendKeys(projectpath+"\\files\\promotionsample.png");
		submitcat.click();
		Thread.sleep(3000);
	}
	
	public void subCategoryl2Add()throws InterruptedException
	{
	
	
	}
	

	public void subCategoryl3Add(String title,String descrpition,String code,String filePath)throws InterruptedException
	{		
	
	    
		
	}
	public void addregion()throws InterruptedException
	{
	
	}
}