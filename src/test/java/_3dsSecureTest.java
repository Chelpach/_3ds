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
@Title("Проверка 3Ds аутентификаций по картам различных МПС")
@RunWith(Parameterized.class)
public class _3dsSecureTest extends BaseSteps {
    private RequestsPageSteps requestsPageSteps = new RequestsPageSteps();
    private AcsPageSteps acsPageSteps = new AcsPageSteps();

    @Parameters(name = "Аутентификация 3ds: карта {0}, валюта {1}, сумма {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        // {"2202200282928173", "643", "100", "2"},
                        //{"4817810001515052", "643", "100", "2"},
                        // {"5479270010026524", "643", "100", "2"},
                        //{"2202200282928173", "840", "100", "2"},
                        // {"4817810001515052", "840", "100", "2"},
                        // {"5479270010026524", "840", "100", "2"},
                        //  {"2202200282928173", "978", "100", "2"},
                        // {"4817810001515052", "978", "100", "2"},
                        //{"5479270010026524", "978", "100", "2"},
                        //      {"2202200282928173", "643", "5000000", "2"},
                        //  {"4817810001515052", "643", "5000000", "2"},
                        //   {"5479270010026524", "643", "5000000", "2"}
                        //     {"2202200282928173", "840", "5000000", "2"},
                        //      {"4817810001515052", "840", "5000000", "2"},
                        //     {"5479270010026524", "840", "5000000", "2"},
                        //      {"2202200282928173", "978", "5000000", "2"},
                        //      {"4817810001515052", "978", "5000000", "2"},
                        //      {"5479270010026524", "978", "5000000", "2"},
                        //     {"2202200282928173", "203", "100", "2"},
                       {"4276839404305641", "156", "100", "2"},
                        {"4817810001515052", "392", "1", "0"},
                       // {"4817810001515052", "840", "12500000", "2"},
                        //{"5479270010026524", "643", "100", "2"},
                     //   {"5479270010026524", "643", "45000100", "2"},
                        //{"2202200196927980", "978", "100", "2"},
                        //{"2202200196927980", "978", "6504100", "2"}
                }
        );
    }

    private String cardNumber;
    private String currency;
    private String amount;
    private String exponent;


    public _3dsSecureTest(String cardNumber, String currency, String amount, String exponent) {
        this.cardNumber = cardNumber;
        this.currency = currency;
        this.amount = amount;
        this.exponent = exponent;
    }

    @Test
    public void Test3ds() throws InterruptedException {
        requestsPageSteps.clickRunAcsTestButton();
        Thread.sleep(1000);
        requestsPageSteps.selectTestCase();
        requestsPageSteps.changingCardNumberVeReq(cardNumber);
        requestsPageSteps.sendVeReq();
        requestsPageSteps.assertVeResponse("Success:Valid 3-D Secure message", "Success:Received a 3-D Secure VERes message, as expected.", "Success:Expected enrollment status 'Y' matches received enrollment status 'Y'.");
        requestsPageSteps.changingCardNumberPaReq(currency, amount, exponent);
        requestsPageSteps.sendPaReq();
        acsPageSteps.fillOneTimePassword("111111");
        acsPageSteps.clickSendOneTimPasswordButton();
        requestsPageSteps.assertPaResponse(cardNumber);
    }
}



