package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioSteps {
    private MainPageSteps mainPageSteps = new MainPageSteps();
    private ElectronicaSteps electronicaSteps = new ElectronicaSteps();
    private TvSteps tvSteps = new TvSteps();

    @When("^осуществлен переход в раздел ЯндексМаркет$")
    public void selectYandexMarket() {
        mainPageSteps.selectYandexMarket();
    }

    @When("^выбран раздел Электроника$")
    public void selectElectronics() {
        mainPageSteps.selectElectronics();
    }

    @When("^осуществлен переход в раздел Телевизоры$")
    public void selectTvCatalog() {
        electronicaSteps.selectTvCatalog();
    }

    @When("ограничиваем количество телевизоров до 12")
    public void turnTvToTwelve() throws InterruptedException {
        tvSteps.turnToTwelve();
    }

    @When("^Фильтруем поиск по цене от: \"(.*)\"")
    public void setStartTvPrice(String value) {
        tvSteps.setPrice(value);
    }

    @When("^выбираем производителей LG и Samsung$")
    public void setTvCheckBox() {
        tvSteps.setCheckBoxes();
    }

    @Then("^проверяем, что на странице телевизоров 12 элементов$")
    public void checkCountOfTvElements() throws InterruptedException {
        tvSteps.checkCountOfProducts();
        Thread.sleep(6000);
    }

    @When("^запоминаем первый телевизор в списке$")
    public void getFirstTvProduct() {
        tvSteps.getFirstProduct();
    }

    @When("^вводим первый телевизор в поиск$")
    public void searchFirstTvProduct() {
        tvSteps.searchFirstProduct();
    }

    @Then("^проверяем соответствие искомого и найденного телевизора$")
    public void checkFirstTvIsSearhed() {
        tvSteps.checkFirstIsSearched();
    }

}
