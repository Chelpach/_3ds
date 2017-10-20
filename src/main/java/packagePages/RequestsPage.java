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

    @FindBy(css="#respinfoId > font:nth-child(1)")
    public WebElement veResResponseInfoLine1;

    @FindBy(css="#respinfoId > font:nth-child(3)")
    public WebElement veResResponseInfoLine2;

    @FindBy(css="#respinfoId > font:nth-child(5)")
    public WebElement veResResponseInfoLine3;

    @FindBy(xpath = "html/body/div[1]/div/div[2]/div/div/div/form/div[2]/div/div[4]/div/div/textarea")
    public WebElement paReqTextArea;

    @FindBy(css = ".btn.btn-primary.btn-sm.ng-scope")
    public WebElement sendPaReqButton;

    @FindBy(css="#respinfoId > font:nth-child(1)")
    public WebElement paResResponseInfoLine1;

    @FindBy(css="#respinfoId > font:nth-child(3)")
    public WebElement paResResponseInfoLine2;

    @FindBy(css="#respinfoId > font:nth-child(5)")
    public WebElement paResResponseInfoLine3;

    @FindBy(css="#respinfoId > font:nth-child(7)")
    public WebElement paResResponseInfoLine4;

    @FindBy(css="#respinfoId > font")
    public WebElement paResResponseInfoLine5;

    @FindBy(css="body > div > div > div:nth-child(2) > div > div > div > form > div > div.row.ng-scope > div > div > div > font")
    public WebElement paResResponseInfoLine6;

    public RequestsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }



}
