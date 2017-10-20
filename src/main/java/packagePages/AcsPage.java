package packagePages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 05.10.2017.
 */
public class AcsPage extends BasePage {
    @FindBy(css = "#psw_id")
    public WebElement oneTimePassword;

    @FindBy(css = "#btnSubmit")
    public WebElement sendButton;

    @FindBy(css="body > div > form > div:nth-child(4) > p > a")
    public WebElement passwordAgain;

    public AcsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
