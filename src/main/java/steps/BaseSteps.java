package steps;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Attachment;
import util.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 23.09.2017.
 */
public class BaseSteps {

    protected static WebDriver driver;
    public static String baseUrl, login, password;
    private static Properties properties = TestProperties.getInstance().getProperties();

    public static WebDriver getDriver() {
        return driver;
    }


    @BeforeClass
    public static void setUp() throws Exception {
        switch (properties.getProperty("browser")) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
        }
        baseUrl = properties.getProperty("url");
        login = properties.getProperty("login");
        password = properties.getProperty("password");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
        driver.manage().window().maximize();
        loginToVisaPit();


    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }

    public void switchWindow() {
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

    private static void loginToVisaPit() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps.login(login);
        loginPageSteps.password(password);
        loginPageSteps.clickLoginButton();
        loginPageSteps.allertClick();
    }

 @Attachment(type = "image/png", value = "Screenshot")
  public static byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
