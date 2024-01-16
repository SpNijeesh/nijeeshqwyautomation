package qwy.automationqwy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class sample {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		String mobile= "9999888999";
		String password="111111111111111";
		driver.get("https://stage-shop-merchant.qwqer.in/");
		driver.findElement(By.id("customerPhone")).sendKeys(mobile);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//span[@class='login-text']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[normalize-space()='Orders']")).click();
		String orderIDToMatch = "QS10723";
		Thread.sleep(2000);
		List<WebElement> orderRows = driver.findElements(By.xpath("//tr[@class='ng-star-inserted']"));
			for (WebElement row : orderRows) {
	            // Get the orderID from each row
	            WebElement orderIDElement = row.findElement(By.xpath("//tr[@class='ng-star-inserted']/td[1]")); // Assuming the orderID is in the first column (adjust the XPath accordingly)
	            String orderID = orderIDElement.getText();

	            // Check if the current orderID matches the one you're looking for
	            if (orderID.equals(orderIDToMatch)) {
	                // If a match is found, click on the "View" button associated with that row
	                WebElement viewButton = row.findElement(By.xpath("//td/div/button[normalize-space()='View']"));
	                viewButton.click();
	                break; // Exit the loop once the matching order is found
	            }
	        }
//	driver.findElement(By.xpath("//span[@class='p-dropdown-trigger-icon ng-tns-c50-4 pi pi-chevron-down']")).click();
//		Thread.sleep(2000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='p-ripple p-element p-dropdown-item']")));
//		 List<WebElement> elements=driver.findElements(By.xpath("//li[@class='p-ripple p-element p-dropdown-item']"));
//		 for (WebElement element : elements) {
//	            // Get the text of each element
//	            String text = element.getText();
////System.out.println(text);
//	            // Check if the text matches the expected text
//	            if (text.equals("MBS")) {
//	                // Display the name of the selected shop and Click on the shop if the text matches
//	                System.out.println("The shop Selected is " + element.getText());
//	                element.click();
//	                break; // Stop iterating through elements once a match is found
//	            }
     }
   
		
	

}
