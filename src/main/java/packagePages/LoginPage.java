package packagePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by user on 24.09.2017.
 */
public class LoginPage extends BasePage{
    @FindBy(xpath = "//input[@name='userName']")
    public WebElement loginField;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordField;

    @FindBy(xpath = "//input[@password]")
    public WebElement loginButton;

}
