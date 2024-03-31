package localhost.bookstore.qa.pages;

import localhost.bookstore.qa.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Dashboard extends BaseClass {

    @FindBy(xpath = "//div[text()='BookStore']")
    WebElement bookStoreText;

    @FindBy(xpath = "//img[contains(@role, 'presentation')]")
    WebElement bookStoreIcon;

    @FindBy(xpath = "//input[contains(@aria-label, 'search')]")
    WebElement searchBar;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/header/div/div[4]/button[1]")
    WebElement profile;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/header/div/div[4]/button[2]")
    WebElement cart;

    @FindBy(xpath = "//li[text()='Log Out']")
    WebElement logout;

    public Dashboard(){
        PageFactory.initElements(driver, this);
    }

    // Method to search the item in the Dashboard
    public void SearchBar(String searchItem){
        searchBar.sendKeys(searchItem);
    }

    // Method to log out from the dashboard
    public LoginPage Logout(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div/header/div/div[4]/button[1]")));
        profile.click();
        logout.click();

        return new LoginPage();
    }

    // Method to click and check the functionality of the Cart option
    public void Cart(){
        cart.click();
    }
}
