package packagePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 24.09.2017.
 */
public class LoginPage extends BasePage{
    @FindBy(xpath = "//input[@name='userName']")
    public WebElement loginField;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordField;

    @FindBy(css = ".btn.btn-primary.btn-sm")
    public WebElement loginButton;



    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
