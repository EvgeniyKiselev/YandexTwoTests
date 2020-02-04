package steps;

import io.qameta.allure.Step;
import pages.ElectronikaPage;

public class ElectronicaSteps {
    @Step("осуществлен переход в раздел Телевизоры")
    public void selectTvCatalog() {
        new ElectronikaPage().selectTv();
    }

    @Step("осуществлен переход в раздел Наушники")
    public void selectPhonesCatalog() {
        new ElectronikaPage().selectPhones();
    }
}
