package localhost.bookstore.qa.testcases;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import localhost.bookstore.qa.baseclass.BaseClass;
import localhost.bookstore.qa.pages.LoginPage;
import localhost.bookstore.qa.utility.TestUtil;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

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
    public Object[][] getCredentials(){
        return TestUtil.getTestData("Sheet1");
    }

    @Test(dataProvider = "credentials")
    @Description("Verify login with valid credentials")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Authentication")
    public void loginTest(String username, String password) throws InterruptedException {
        loginPage.Login(username, password);
    }


}
