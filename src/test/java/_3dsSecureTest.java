import org.junit.Test;
import steps.BaseSteps;
import steps.LoginPageSteps;

/**
 * Created by user on 24.09.2017.
 */
public class _3dsSecureTest extends BaseSteps{
    BaseSteps baseSteps = new BaseSteps();
    LoginPageSteps loginPageSteps = new LoginPageSteps();

    @Test
    public void firstScenarion() {
        loginPageSteps.login(login);
    }
}
