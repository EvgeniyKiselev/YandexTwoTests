package steps;
import io.qameta.allure.Step;
import pages.MainPage;

public class MainPageSteps {
    @Step("осуществлен вход на ЯндексМаркет")
    public void selectYandexMarket() {
        new MainPage().selectMarket();
    }

    @Step("выбран раздел Электроника")
    public void selectElectronics() {
        new MainPage().selectElectronic();
    }

}


