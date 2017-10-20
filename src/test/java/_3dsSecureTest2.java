import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.AcsPageSteps;
import steps.BaseSteps;
import steps.RequestsPageSteps;

/**
 * Created by user on 19.10.2017.
 */
@Title("Проверка получения нескольких паролей и не верно введённого пароля")
public class _3dsSecureTest2 extends BaseSteps {
    private RequestsPageSteps requestsPageSteps = new RequestsPageSteps();
    private AcsPageSteps acsPageSteps = new AcsPageSteps();

    @Test
    public void Test3ds2() throws InterruptedException {
        String defaultCardNumber = "4173980023926732";
        requestsPageSteps.clickRunAcsTestButton();
        Thread.sleep(1000);
        requestsPageSteps.selectTestCase();
        requestsPageSteps.changingCardNumberVeReq(defaultCardNumber);
        requestsPageSteps.sendVeReq();
        requestsPageSteps.assertVeResponse("Success:Valid 3-D Secure message", "Success:Received a 3-D Secure VERes message, as expected.", "Success:Expected enrollment status 'Y' matches received enrollment status 'Y'.");
        requestsPageSteps.sendPaReq();
        acsPageSteps.passwordAgainClick();
        acsPageSteps.passwordAgainClick();
        acsPageSteps.passwordAgainClick();
        //acsPageSteps.fillOneTimePassword("111111");
        //acsPageSteps.clickSendOneTimPasswordButton();
        requestsPageSteps.assertPaResponse(defaultCardNumber);
    }
}
