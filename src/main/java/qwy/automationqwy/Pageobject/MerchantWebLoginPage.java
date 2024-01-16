package qwy.automationqwy.Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qwy.automationqwy.AbstractComponents.AbstractComponents;

public class MerchantWebLoginPage extends AbstractComponents{
	WebDriver driver;
	
	public MerchantWebLoginPage(ChromeDriver driver) {
		super(driver);
	this.driver = driver;
	PageFactory.initElements(driver, this); // used to construct the driver.elements in page factory 
	}
	// WebElement userMobile = driver.findElement(By.xpath("//input[@placeholder='Mobile number']")); 
	//it can be refactor using page factory
	//pagefactory
	
	@FindBy(xpath="//input[@placeholder='Mobile number']")
	 WebElement userMobile;	
	@FindBy(xpath="//input[@placeholder='Password']")
	 WebElement userPassword;
	@FindBy(xpath="//button[@type='submit']")
	 WebElement submit;
	//By Weight = By.xpath("//div[@class='weightlistcustom']//div[1]//input[1]");
	@FindBy(xpath="//div[@class='weightlistcustom']//div[1]//input[1]")
	 WebElement weights;
	
	By fieldDeliveryPoint = By.xpath("//input[@id='fieldDeliveryPoint']");	
	By SavedAddress = By.xpath("//a[normalize-space()='Saved Address']");
	By SelectSavedAddress = By.xpath("//div[@class='weightlistcustom']//div[1]//input[1");
	
	
	@FindBy(xpath="//div[@class='weightlistcustom']//div[1]//input[1]")
	 WebElement weightselect;
	
	//searchfield.click();
	public void loginApplication(String mobile, String password)
	{
		userMobile.sendKeys(mobile);
		userPassword.sendKeys(password);
		submit.click();
	}
	public void placetheOrder()
	{
		
		weightselect.click();
		
//		waitforelementToBeClickable(fieldDeliveryPoint);
//		WebElement fieldDelivery =  driver.findElement(fieldDeliveryPoint);
//		fieldDelivery.click();
//		WebElement SavedAddressfield =  driver.findElement(SavedAddress);
//		SavedAddressfield.click();
//		WebElement SelectSave =  driver.findElement(SelectSavedAddress);
//		SelectSave.click();
		
		
	}
	
}


//PRVL3_07