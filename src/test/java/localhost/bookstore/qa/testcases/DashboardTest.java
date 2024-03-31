package localhost.bookstore.qa.testcases;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import localhost.bookstore.qa.baseclass.BaseClass;
import localhost.bookstore.qa.pages.Dashboard;
import localhost.bookstore.qa.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DashboardTest extends BaseClass {

    Dashboard dashboard;
    LoginPage loginPage;

    public DashboardTest(){
        super();
    }

    @BeforeMethod
    public void setup() throws InterruptedException {
        try{
            initialization();
            loginPage = new LoginPage();
            dashboard = loginPage.Login(properties.getProperty("email"), properties.getProperty("password"));
        }
        catch (WebDriverException e){
            e.printStackTrace();
        }
    }

    // Method to test the search bar
    @Test(priority = 1)
    @Description("Verify if the Search bar is properly working or not")
    @Severity(SeverityLevel.NORMAL)
    @Story("Searching Items")
    public void searchBarTest() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@aria-label, 'search')]")));
        dashboard.SearchBar(properties.getProperty("searchItem"));
    }

    // Method to test Log out feature
    @Test(priority = 2)
    @Description("Verify if the user is properly is logging out or not")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Logging out")
    public void logOutTest() throws InterruptedException{
        dashboard.Logout();
    }

    // Method to test the Cart option feature
    @Test(priority = 3)
    @Description("Verify if the user navigate to the Cart page or not")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Go to the Cart")
    public void cartTest() throws InterruptedException{
        dashboard.Cart();
    }

    @AfterMethod
    public void tearUp(){
        //driver.quit();
    }
}
