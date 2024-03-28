package localhost.bookstore.qa.testcases;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import localhost.bookstore.qa.baseclass.BaseClass;
import localhost.bookstore.qa.pages.LoginPage;
import localhost.bookstore.qa.utility.TestUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.annotation.Priority;
import java.util.Arrays;

public class LoginPageTest extends BaseClass {

    LoginPage loginPage;

    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        initialization();
        loginPage = new LoginPage();
    }

    @DataProvider(name = "credentials")
    public Object[][] getCredentials() {
        Object[][] testData = TestUtil.getTestData("Sheet1");
        Object[][] credentialsData = new Object[testData.length][3]; // 3 columns: username, password, isValidCredentials
        for (int i = 0; i < testData.length; i++) {
            String username = (String) testData[i][0];
            String password = (String) testData[i][1];
            String isValidCredentialsStr = (String) testData[i][2];
            Boolean isValidCredentials = Boolean.parseBoolean(isValidCredentialsStr); // Convert string to boolean
            credentialsData[i] = new Object[]{username, password, isValidCredentials};
        }
        return credentialsData;
    }


    @Test(dataProvider = "credentials")
    @Description("Verify login with valid credentials")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Authentication")
    public void loginTest(String username, String password, Boolean isValidCredentials) throws InterruptedException {
        if (isValidCredentials != null) {
            loginPage.Login(username, password);
            Thread.sleep(5000);
            if (isValidCredentials) {
                Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:3000/dashboard");
            } else {
                Assert.assertNotEquals(driver.getCurrentUrl(), "http://localhost:3000/dashboard");
                Thread.sleep(5000);
            }
        } else {
            Assert.fail("isValidCredentials is null");
        }
    }

    @Test(priority = 2)
    @Description("Verify login with facebook button")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Authentication")
    public void facebookLoginTest() throws InterruptedException{
        loginPage.FacebookLogin();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://localhost:3000/dashboard");
    }

    @Test(priority = 3)
    @Description("Verify login with Google button")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Authentication")
    public void googleLoginTest() throws InterruptedException{
        loginPage.GoogleLogin();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://localhost:3000/dashboard");
    }


}
