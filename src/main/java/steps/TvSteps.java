package steps;

import io.qameta.allure.Step;
import pages.TvPage;

public class TvSteps {

    @Step("ограничение количества товаров на странице")
    public void turnToTwelve() throws InterruptedException {
        new TvPage().turnToTwelve();
    }

    @Step("установка параметров поиска")
    public void setPrice(String value) {
        new TvPage().fillFieldPrice(value);
    }

    @Step("выбор производителей")
    public void setCheckBoxes() {
        new TvPage().setCheckboxes();
    }

    @Step("проверка количества товаров на странице")
    public void checkCountOfProducts() {
        new TvPage().checkTheCount();
    }

    @Step("копирование первого товара")
    public void getFirstProduct() {
        new TvPage().getFirstProduct();
    }

    @Step("ввод скопированного значения в поле поиска")
    public void searchFirstProduct() {
        new TvPage().searchFirstProduct();
    }

    @Step("проверка на соответствие найденного товара искомому")
    public void checkFirstIsSearched() {
        new TvPage().checkFirstIsSearched();
    }
}
