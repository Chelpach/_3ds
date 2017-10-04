package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import packagePages.RequestsPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by user on 04.10.2017.
 */
public class RequestsPageSteps extends BaseSteps {
    @Step("Нажатие на кнопку Run Acs Test")
    public void clickRunAcsTestButton() {
        new RequestsPage(getDriver()).runAcsTestButton.click();
    }

    @Step("Выбор нужного тест кейса, под номером 2")
    public void selectTestCase() {
        Select select = new Select(new RequestsPage(getDriver()).testCaseSelect);
        select.selectByValue("number:201");
    }

    @Step("Замена значения карты")
    public void changingCardNumber(String cardNumber){
        String selectAll = Keys.chord(Keys.CONTROL, "a");
        WebElement textArea = new RequestsPage(getDriver()).veReqTextArea;
        textArea.sendKeys(selectAll);
        String veReg = textArea.getAttribute("value");
        textArea.clear();
        String newVeReq = veReg.replace("4012001037664444", cardNumber);
        textArea.sendKeys(newVeReq);
    }
}
