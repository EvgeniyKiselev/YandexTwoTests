
package steps;
import io.qameta.allure.Step;
import pages.MainPage;

public class MainPageSteps {
    @Step("выбран пункт меню {0}")
    public void selectMenuItem() {
        new MainPage().selectMenuItem();
    }

    @Step("выбран вид страхования {0}")
    public void selectMenuInsurance() {
        new MainPage().selectInsuranceItem();
    }

}


