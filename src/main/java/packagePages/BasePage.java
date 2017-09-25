package packagePages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 12.09.2017.
 */
public class BasePage {

    WebDriver driver;

    public void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public void fillFieldIfPresent(WebElement element, String value) {
        if (isElementPresent(element)) {
            element.clear();
            element.sendKeys(value);
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }finally {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        return false;
    }

    public boolean checkTelephone(WebElement element){
        return isElementPresent(element);
    }

}
