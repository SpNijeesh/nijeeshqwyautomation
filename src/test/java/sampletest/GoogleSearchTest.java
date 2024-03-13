package sampletest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleSearchTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver
        driver = new ChromeDriver();
    }

    @Test
    public void openGoogle() {
        // Open Google.com
        driver.get("https://www.google.com");

        // Add additional test steps if needed
        // For example, you might want to assert that the title contains "Google"
        // Assert.assertTrue(driver.getTitle().contains("Google"));
    }}