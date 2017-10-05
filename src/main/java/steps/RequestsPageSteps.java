package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    @Step("Замена значения карты в veReq")
    public void changingCardNumberVeReq(String cardNumber) throws InterruptedException {
        Thread.sleep(1000);
        WebElement textArea = new RequestsPage(getDriver()).veReqTextArea;

        //  Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        //  wait.until(ExpectedConditions.visibilityOf(textArea));

        String veReg = textArea.getAttribute("value");
        String selectAll = Keys.chord(Keys.CONTROL, "a");
        textArea.sendKeys(selectAll);
        textArea.clear();
        String newVeReq = veReg.replace("4012001037664444", cardNumber);
        textArea.sendKeys(newVeReq);
    }

    @Step("Нажатие на кнопку \"send VeReq\"")
    public void sendVeReq() {
        new RequestsPage(getDriver()).sendVeReqButton.click();
    }

    @Step("Замена значения карты в paReq")
    public void changingCardNumberPaReq(String currency, String amount) {
        String selectAll = Keys.chord(Keys.CONTROL, "a");
        WebElement textArea = new RequestsPage(getDriver()).paReqTextArea;
        textArea.sendKeys(selectAll);
        String paReq = textArea.getAttribute("value");
        String newPaReq = paReq.replace("<purchAmount>100</purchAmount>", "<purchAmount>"+amount+"</purchAmount>").replace("<currency>840</currency>", "<currency>"+currency+"</currency>");
        textArea.clear();
        textArea.sendKeys(newPaReq);
    }

    @Step("Нажатие на кнопку \"send VeReq\"")
    public void sendPaReq() {
        new RequestsPage(getDriver()).sendPaReqButton.click();
    }


}
