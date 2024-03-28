package localhost.bookstore.qa.pages;

import localhost.bookstore.qa.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass{
    @FindBy(xpath = "//input[@id='email']")
    WebElement email;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//button[text()='Login']")
    WebElement login;

    @FindBy(xpath = "//button[text()='Facebook']")
    WebElement facebook;

    @FindBy(xpath = "//button[text()='Google']")
    WebElement google;


    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    // Method to sign in into the Bookstore website
    public Dashboard Login(String emailInput, String passwordInput) throws InterruptedException {
        email.sendKeys(emailInput);
        password.sendKeys(passwordInput);
        login.click();

        return new Dashboard();
    }

    // Method to sing in into the Bookstore application through Facebook
    public Dashboard FacebookLogin(){
        facebook.click();

        return new Dashboard();
    }

    // Method to sign in into the Bookstore application through Google
    public Dashboard GoogleLogin(){
        google.click();

        return new Dashboard();
    }

}
