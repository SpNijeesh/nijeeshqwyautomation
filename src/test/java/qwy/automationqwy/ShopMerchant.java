package qwy.automationqwy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShopMerchant {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://stage-shop-merchant.qwqer.in/");
		driver.findElement(By.id("customerPhone")).sendKeys("9999888999");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("111111111111111");
		driver.findElement(By.xpath("//span[@class='login-text']")).click();
		//Order Module
		driver.findElement(By.xpath("//label[normalize-space()='Orders']")).click();
		Thread.sleep(2000);
		
		 String orderIdToVerify = "QS10682";

	        // Find the rows of the table
	        WebElement table = driver.findElement(By.xpath("//table[@class='p-datatable-table ng-star-inserted']"));

	        WebElement tbody = table.findElement(By.xpath("//tbody[@class='p-element p-datatable-tbody']"));

	        List<WebElement> rows = tbody.findElements(By.xpath("//tbody[@class='p-element p-datatable-tbody']/tr[@class='ng-star-inserted']"));

	        // Loop through each row in the table
	        for (WebElement row : rows) {
	            // Find the OrderID column in each row
	            WebElement orderIdElement = row.findElement(By.xpath("//tr[@class='ng-star-inserted']/td")); // Update the XPath based on your table structure

	            // Get the text of the OrderID
	            String orderId = orderIdElement.getText();

	            // Check if the OrderID matches the one you're looking for
	            if (orderId.equals(orderIdToVerify)) {
	                // Find and click the "View" button in the same row
	                WebElement viewButton = row.findElement(By.xpath("//div[@class='d-flex']/button[@class='btn view-button']")); // Update the XPath based on your table structure
	                viewButton.click();
	                break; // Break the loop after clicking the View button for the matching OrderID
//		List<WebElement> orders = driver.findElements(By.xpath("//tbody/tr/td"));
//		
//		for (WebElement order : orders) {
//            // Get the text of each element
//            String text = order.getText();
//            if(text.contentEquals("QS10682"))
//            {
//            System.out.println(text);
//            List<WebElement> ordersList = driver.findElements(By.xpath("//div[@class='d-flex']/button[@class='btn view-button']"));
//            for (WebElement orderlist : ordersList) {
//            	String viewbutton=orderlist.getText();
//            	System.out.println(viewbutton);
//            	
//            }
//            }
//            if(text.contentEquals("QS10682"))
//            {
//            	List<WebElement> elements = driver.findElements(By.xpath("//button[@class='btn view-button']"));
//            	
//            	for (WebElement element : elements) 
//            	{
//            		System.out.println(element);
//            	}
//            }
            //System.out.println(text);
          //tbody[@class='p-element p-datatable-tbody']/tr
            //tbody[@class='p-element p-datatable-tbody']/tr/td - 

	}
	}}}

