package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import packagePages.AcsPage;
import ru.yandex.qatools.allure.annotations.Step;

import static steps.BaseSteps.driver;
import static steps.BaseSteps.getDriver;
import static steps.BaseSteps.takeScreenshot;

/**
 * Created by user on 05.10.2017.
 */
public class AcsPageSteps {
    @Step("Ввод одноразового пароля {0}")
    public void fillOneTimePassword(String oneTimePassword) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(new AcsPage(getDriver()).oneTimePassword));
        new AcsPage(getDriver()).fillFieldIfPresent(new AcsPage(getDriver()).oneTimePassword, oneTimePassword);
        takeScreenshot();
    }

    @Step("Нажатие на кнопку отправить")
    public void clickSendOneTimPasswordButton() {
        new AcsPage(getDriver()).sendButton.click();
    }
}
