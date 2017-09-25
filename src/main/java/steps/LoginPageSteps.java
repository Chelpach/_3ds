package steps;

import packagePages.LoginPage;
import ru.yandex.qatools.allure.annotations.Step;


/**
 * Created by user on 24.09.2017.
 */
public class LoginPageSteps extends BaseSteps{
@Step("Ввод в поле login логин")
    public void login(String login){
    new LoginPage().fillField(new LoginPage().loginField, login);
    }

}
