package steps;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import packagePages.AssertionsVariables;
import packagePages.BasePage;
import packagePages.RequestsPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by user on 04.10.2017.
 */
public class RequestsPageSteps extends BaseSteps {


    @Step("Нажатие на кнопку \"Run Acs Test\"")
    public void clickRunAcsTestButton() {
        new RequestsPage(getDriver()).runAcsTestButton.click();
    }

    @Step("Выбор тестового сценария- \"02 - Authentication via a 16-digit PAN (VEReq)\"")
    public void selectTestCase() {
        Select select = new Select(new RequestsPage(getDriver()).testCaseSelect);
        select.selectByValue("number:201");
    }

    @Step("Замена значения карты {0} в veReq")
    public void changingCardNumberVeReq(String cardNumber) throws InterruptedException {
        Thread.sleep(1000);
        WebElement textArea = new RequestsPage(getDriver()).veReqTextArea;
        String veReg = textArea.getAttribute("value");
        String selectAll = Keys.chord(Keys.CONTROL, "a");
        textArea.sendKeys(selectAll);
        textArea.clear();
        String newVeReq = veReg.replace("4012001037664444", cardNumber);
        textArea.sendKeys(newVeReq);
    }

    @Step("Нажатие на кнопку \"send VeReq\"")
    public void sendVeReq() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(new RequestsPage(getDriver()).sendVeReqButton));
        new RequestsPage(getDriver()).sendVeReqButton.click();
    }

    @Step("Проверка ответа на VeReq : {0} {1} {2}")
    public void assertVeResponse(String expected1, String expected2, String expected3) {
        new BasePage().assertResponse(new RequestsPage(getDriver()).veResResponseInfoLine1.getAttribute("innerHTML"), expected1);
        new BasePage().assertResponse(new RequestsPage(getDriver()).veResResponseInfoLine2.getAttribute("innerText"), expected2);
        new BasePage().assertResponse(new RequestsPage(getDriver()).veResResponseInfoLine3.getAttribute("innerText"), expected3);
    }

    @Step("Замена значения валюты {0} и суммы {1} в paReq")
    public void changingCardNumberPaReq(String currency, String amount, String exponent) {
        String selectAll = Keys.chord(Keys.CONTROL, "a");
        WebElement textArea = new RequestsPage(getDriver()).paReqTextArea;
        textArea.sendKeys(selectAll);
        String paReq = textArea.getAttribute("value");
        String newPaReq = paReq.replace("<purchAmount>100</purchAmount>", "<purchAmount>" + amount + "</purchAmount>").replace("<currency>840</currency>", "<currency>" + currency + "</currency>").replace("<exponent>2</exponent>", "<exponent>" + exponent + "</exponent>");
        textArea.clear();
        textArea.sendKeys(newPaReq);
    }

    @Step("Нажатие на кнопку \"send VeReq\"")
    public void sendPaReq() {
        new RequestsPage(getDriver()).sendPaReqButton.click();
    }

    @Step("Проверка ответа на PaReq")
    public void assertPaResponse(String cardNumber) {
        switch (cardNumber.charAt(0)) {
            case '4':
                new BasePage().assertResponse(new RequestsPage(getDriver()).paResResponseInfoLine1.getAttribute("innerHTML"), AssertionsVariables.expected1);
                new BasePage().assertResponse(new RequestsPage(getDriver()).paResResponseInfoLine2.getAttribute("innerText"), AssertionsVariables.expected2);
                new BasePage().assertResponse(new RequestsPage(getDriver()).paResResponseInfoLine3.getAttribute("innerText"), AssertionsVariables.expected3);
                new BasePage().assertResponse(new RequestsPage(getDriver()).paResResponseInfoLine4.getAttribute("innerText"), AssertionsVariables.expected4);
                takeScreenshot();
                break;
            case '5':
                new BasePage().assertResponse(new RequestsPage(getDriver()).paResResponseInfoLine5.getAttribute("innerHTML"), AssertionsVariables.expected5);
                new BasePage().assertResponse(new RequestsPage(getDriver()).paResResponseInfoLine6.getAttribute("innerText"), AssertionsVariables.expected6);
                takeScreenshot();
                break;
            case '2':
                new BasePage().assertResponse(new RequestsPage(getDriver()).paResResponseInfoLine5.getAttribute("innerHTML"), AssertionsVariables.expected5);
                new BasePage().assertResponse(new RequestsPage(getDriver()).paResResponseInfoLine6.getAttribute("innerText"), AssertionsVariables.expected6);
                takeScreenshot();
                break;
        }

    }

}
