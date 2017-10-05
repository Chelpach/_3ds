import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;
import ru.yandex.qatools.allure.annotations.Title;
import steps.AcsPageSteps;
import steps.BaseSteps;
import steps.RequestsPageSteps;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by user on 24.09.2017.
 */

@RunWith(Parameterized.class)
public class _3dsSecureTest extends BaseSteps {
    private RequestsPageSteps requestsPageSteps = new RequestsPageSteps();
    private AcsPageSteps acsPageSteps = new AcsPageSteps();

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {"2202200282928173", "643", "100"},
                        {"4817810001515052", "643", "100"},
                        {"5479270010026524", "643", "100"},
                        /*{"2202200282928173", "840", "100"},
                        {"4817810001515052", "840", "100"},
                        {"5479270010026524", "840", "100"},
                        {"2202200282928173", "978", "100"},
                        {"4817810001515052", "978", "100"},
                        {"5479270010026524", "978", "100"},
                        {"2202200282928173", "643", "50000"},
                        {"4817810001515052", "643", "50000"},
                        {"5479270010026524", "643", "50000"},
                        {"2202200282928173", "840", "50000"},
                        {"4817810001515052", "840", "50000"},
                        {"5479270010026524", "840", "50000"},
                        {"2202200282928173", "978", "50000"},
                        {"4817810001515052", "978", "50000"},*/
                        {"5479270010026524", "978", "50000"}
                }
        );
    }

    private String cardNumber;
    private String currency;
    private String amount;

    public _3dsSecureTest(String cardNumber, String currency, String amount) {
        this.cardNumber = cardNumber;
        this.currency = currency;
        this.amount = amount;

    }

    @Title("Аутентификации 3Ds, номер карты {cardNumber0}, валюта {1}")
    @Test
    public void firstScenario() throws InterruptedException {
        requestsPageSteps.clickRunAcsTestButton();
        Thread.sleep(1000);
        requestsPageSteps.selectTestCase();
        requestsPageSteps.changingCardNumberVeReq(cardNumber);
        requestsPageSteps.sendVeReq();
        requestsPageSteps.changingCardNumberPaReq(currency, amount);
        requestsPageSteps.sendPaReq();
        acsPageSteps.fillOneTimePassword("111111");
        acsPageSteps.clickSendOneTimPasswordButton();
    }

}
