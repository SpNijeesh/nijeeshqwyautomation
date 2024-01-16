package qwy.automationqwy.Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qwy.automationqwy.AbstractComponents.AbstractComponents;

public class PlaceorderMerchantWeb extends AbstractComponents{
WebDriver driver;
	
	public PlaceorderMerchantWeb(ChromeDriver driver) {
		super(driver);
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	By Weight = By.xpath("//div[@class='weightlistcustom']//div[1]//input[1]");
	By fieldDeliveryPoint = By.xpath("//input[@id='fieldDeliveryPoint']");	
	By SavedAddress = By.xpath("//a[normalize-space()='Saved Address']");
	By SelectSavedAddress = By.xpath("\"//div[@class='weightlistcustom']//div[1]//input[1");
	
	public void placetheOrder()
	{
		waitforelementToBeClickable(Weight);
		WebElement weight =  driver.findElement(Weight);
		weight.click();
		waitforelementToBeClickable(fieldDeliveryPoint);
		WebElement fieldDelivery =  driver.findElement(fieldDeliveryPoint);
		fieldDelivery.click();
		WebElement SavedAddressfield =  driver.findElement(SavedAddress);
		SavedAddressfield.click();
		WebElement SelectSave =  driver.findElement(SelectSavedAddress);
		SelectSave.click();
		
		
	}
}

