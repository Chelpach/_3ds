package packagePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 04.10.2017.
 */
public class RequestsPage extends BasePage {
    @FindBy(linkText = "Run ACS Test")
    public WebElement runAcsTestButton;

    @FindBy(xpath = "html/body/div[1]/div/div[2]/div/div/div/div[3]/form/div[2]/div/div/select")
    public WebElement testCaseSelect;

    @FindBy(xpath = "html/body/div[1]/div/div[2]/div/div/div/div[3]/form/div[3]/div/div/textarea")
    public WebElement veReqTextArea;

    @FindBy(css = ".btn.btn-primary.btn-sm")
    public WebElement sendVeReqButton;

    @FindBy(xpath = "html/body/div[1]/div/div[2]/div/div/div/form/div[2]/div/div[4]/div/div/textarea")
    public WebElement paReqTextArea;

    @FindBy(css = ".btn.btn-primary.btn-sm.ng-scope")
    public WebElement sendPaReqButton;

    public RequestsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

}
