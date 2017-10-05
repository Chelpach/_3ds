package util;

/**
 * Created by user on 05.10.2017.
 */
import org.junit.runner.notification.Failure;
import ru.yandex.qatools.allure.junit.AllureRunListener;
import steps.BaseSteps;

/**
 * Created by 777 on 08.05.2017.
 */
public class AllureListener extends AllureRunListener {

    @Override
    public void testFailure(Failure failure){
        BaseSteps.takeScreenshot();
        super.testFailure(failure);
    }
}