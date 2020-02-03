import com.google.common.collect.SortedSetMultimap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.MainPage;
import pages.PolicyPage;
import pages.SberPage;
import pages.SendAppPage;
import steps.*;
import util.Init;

import java.util.*;

import static util.Init.initDriver;

public class TestSberValidationAllureTest {

    MainPageSteps mainPageSteps = new MainPageSteps();
    SberSteps sberSteps = new SberSteps();
    PolicySteps policySteps = new PolicySteps();
    SendAppSteps sendAppSteps = new SendAppSteps();

    LinkedHashMap<String, String> testData = new LinkedHashMap<>();

    @Before
    public void setUp(){
        initDriver();
    }

    @After
    public void close() {
        Init.closeDriver();
    }

    @Test
    public void testSberInsurance()  throws Exception {

        testData.put("Фамилия застрахованного", "Prokofiev");
        testData.put("Имя застрахованного", "Sergey");
        testData.put("Дата рождения застрахованного", "18.08.1980");
        testData.put("Фамилия страхователя", "Достоевский");
        testData.put("Имя страхователя", "Федор");
        testData.put("Отчество страхователя", "Михайлович");
        testData.put("Дата рождения страхователя", "18.05.1980");
        testData.put("Серия паспорта", "1111");
        testData.put("Номер паспорта", "123456");
        testData.put("Дата выдачи паспорта", "15.05.2013");
        testData.put("Кем выдан", "Паспортный стол");

        mainPageSteps.selectMenuItem();
        mainPageSteps.selectMenuInsurance();
        sberSteps.checkPageTitle();
        sberSteps.goToPolicyPage();
        policySteps.selectMinimal();
        policySteps.goToSendAppPage();
        sendAppSteps.fillFields(testData);
        sendAppSteps.checkFillFields(testData);
        sendAppSteps.clickSendButton();
        sendAppSteps.checkErrorMessage("При заполнении данных произошла ошибка");
    }
}
