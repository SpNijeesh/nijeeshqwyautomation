package qwy.automationqwy;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import qwy.automationqwy.Pageobject.DashboardPage;
import qwy.automationqwy.Pageobject.LoginPage;

public class ShopAdminFrameWork {
	private String RegionName = "Trivandrum";
    public WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeClass
    public void setup() throws InterruptedException {

        loginPage = new LoginPage(null);
        loginPage.login("Q A", "123456789");
    }

    @Test(priority = 1)
    public void dashboardFilter() throws InterruptedException {
     dashboardPage = new DashboardPage(driver);
        dashboardPage.dashboardFilter(RegionName);
    }

    @AfterClass
    public void teardown() {
     //   loginPage.quitDriver();
    }
}