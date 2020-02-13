package steps;

import io.qameta.allure.Step;
import pages.PhonesPage;

public class PhonesSteps {

    @Step("2ограничение количества товаров на странице")
    public void turnToTwelve() throws InterruptedException {
        new PhonesPage().turnToTwelve();
    }

    @Step("установка параметров поиска")
    public void setPrice(String value) {
        new PhonesPage().fillFieldPrice(value);
    }

    @Step("выбор производителей")
    public void setCheckBoxes() {
        new PhonesPage().setCheckboxes();
    }

    @Step("проверка количества товаров на странице")
    public void checkCountOfProducts() {
        new PhonesPage().checkTheCount();
    }

    @Step("копирование первого товара")
    public void getFirstProduct() {
        new PhonesPage().getFirstProduct();
    }

    @Step("ввод скопированного значения в поле поиска")
    public void searchFirstProduct() {
        new PhonesPage().searchFirstProduct();
    }

    @Step("проверка на соответствие найденного товара искомому")
    public void checkFirstIsSearched() {
        new PhonesPage().checkFirstIsSearched();
    }
}
