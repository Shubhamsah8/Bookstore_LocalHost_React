package localhost.bookstore.qa.baseclass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    public static WebDriver driver;
    public static Properties properties;
    public static Logger logger = Logger.getLogger(BaseClass.class);

    public ExtentReports extentReports = new ExtentReports();
    public ExtentSparkReporter sparkReporter = new ExtentSparkReporter("outputFile\\ExtentReport.html");


    public BaseClass(){
        try{
            properties = new Properties();

            FileInputStream inputStream = new FileInputStream("C:\\Users\\RYZEN\\IdeaProjects\\Bookstore_LocalHost_React\\src\\main\\java\\localhost\\bookstore\\qa\\config\\config.properties");
            properties.load(inputStream);
            logger.info("Properties loaded successfully: " + properties);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void initialization(){
        new BaseClass();
        String browserName = properties.getProperty("browser");

        if(browserName.equals("Chrome")){
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
//        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);

        driver.get(properties.getProperty("url"));
    }
}
