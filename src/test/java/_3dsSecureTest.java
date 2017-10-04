import org.junit.Test;
import steps.BaseSteps;
import steps.LoginPageSteps;
import steps.RequestsPageSteps;

/**
 * Created by user on 24.09.2017.
 */
public class _3dsSecureTest extends BaseSteps {
    BaseSteps baseSteps = new BaseSteps();
    LoginPageSteps loginPageSteps = new LoginPageSteps();
    RequestsPageSteps requestsPageSteps = new RequestsPageSteps();

    @Test
    public void firstScenarion() throws InterruptedException {
        loginPageSteps.login(login);
        loginPageSteps.password(password);
        loginPageSteps.clickLoginButton();
        loginPageSteps.allertClick();
        requestsPageSteps.clickRunAcsTestButton();
        requestsPageSteps.selectTestCase();
        requestsPageSteps.changingCardNumber("4817810001515052");
        Thread.sleep(5000);
    }
}
