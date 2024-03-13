package qwy.automationqwy.Pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage{
	
	 WebDriver driver;
	 
	 public LoginPage(WebDriver driver) {
			this.driver= driver;
			PageFactory.initElements(driver, this);
		}
	 
	 @FindBy(name = "username")
	    private WebElement UserName;
	 @FindBy(name = "password")
	    private WebElement Password;
	 @FindBy(xpath = "//button[@id='kt_sign_in_submit']")
	    private WebElement SubmitButton;

    public void login(String User, String Pass) throws InterruptedException {
    	 WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         driver.manage().window().maximize();
         driver.get("https://stage-shop-admin.qwqer.in/");
         UserName.sendKeys(User);
         Password.sendKeys(Pass);
         SubmitButton.click();
    }
}