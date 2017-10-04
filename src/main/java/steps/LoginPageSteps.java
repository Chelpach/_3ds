package steps;

import packagePages.BasePage;
import packagePages.LoginPage;
import ru.yandex.qatools.allure.annotations.Step;


/**
 * Created by user on 24.09.2017.
 */
public class LoginPageSteps extends BaseSteps {
    @Step("Ввод в поле login логин")
    public void login(String login) {
        new LoginPage(getDriver()).fillField(new LoginPage(getDriver()).loginField, login);
    }

    @Step("Ввод в поле password пароль")
    public void password(String password) {
        new LoginPage(getDriver()).fillField(new LoginPage(getDriver()).passwordField, password);
    }

    @Step("Нажатие кнопки login")
    public void clickLoginButton() {
        new LoginPage(getDriver()).loginButton.click();
    }

    @Step("Нажатие на кнопку ОК при появлении предупреждения")
    public void allertClick() {
        getDriver().switchTo().alert().accept();
    }

}
