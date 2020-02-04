package steps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioSteps {
    MainPageSteps mainPageSteps = new MainPageSteps();
    ElectronicaSteps electronicaSteps = new ElectronicaSteps();
    TvSteps tvSteps = new TvSteps();
    PhonesSteps phonesSteps = new PhonesSteps();

    @When("^осуществлен переход в раздел ЯндексМаркет$")
    public void selectYandexMarket(){
        mainPageSteps.selectYandexMarket();
    }

    @When("^выбран раздел Электроника$")
    public void selectElectronics(){
        mainPageSteps.selectElectronics();
    }

    @When("^осуществлен переход в раздел Телевизоры$")
    public void selectTvCatalog(){
        electronicaSteps.selectTvCatalog();
    }

    @When("ограничиваем количество телевизоров до 12")
    public void turnTvToTwelve() throws InterruptedException {
        tvSteps.turnToTwelve();
    }

    @When("^Фильтруем поиск по цене от: \"(.*)\"")
    public void setStartTvPrice(String value){
        tvSteps.setPrice(value);
    }

    @When("^выбираем производителей LG и Samsung$")
    public void setTvCheckBox(){
        tvSteps.setCheckBoxes();
    }

    @Then("^проверяем, что на странице телевизоров 12 элементов$")
    public void checkCountOfTvElements() throws InterruptedException {
        tvSteps.checkCountOfProducts();
        Thread.sleep(6000);
    }

    @When("^переход в раздел ЯндексМаркет$")
    public void select2YandexMarket(){
        mainPageSteps.selectYandexMarket();
    }

    @When("^переход в раздел Электроника$")
    public void select2Electronics(){
        mainPageSteps.selectElectronics();
    }

    @When("^запоминаем первый телевизор в списке$")
    public void getFirstTvProduct(){
        tvSteps.getFirstProduct();
    }

    @When("^вводим первый телевизор в поиск$")
    public void searchFirstTvProduct(){
       tvSteps.searchFirstProduct();
    }

    @Then("^проверяем соответствие искомого и найденного телевизора$")
    public void checkFirstTvIsSearhed(){
        tvSteps.checkFirstIsSearched();
    }

    @When("^осуществлен переход в раздел Наушники$")
    public void selectPhonesCatalog(){
        electronicaSteps.selectPhonesCatalog();
    }

    @When("ограничиваем количество наушников до 12")
    public void turnPhonesToTwelve() throws InterruptedException {
        phonesSteps.turnToTwelve();
    }

    @When("^Фильтруем поиск по цене от: \"(.*)\"")
    public void setStartPhonesPrice(String value){
        phonesSteps.setPrice(value);
    }

    @When("^выбираем производителя Beats$")
    public void setPhonesCheckBox(){
        phonesSteps.setCheckBoxes();
    }

    @Then("^проверяем, что на странице наушников 12 элементов$")
    public void checkCountOfPhonesElements() throws InterruptedException {
        phonesSteps.checkCountOfProducts();
        Thread.sleep(6000);
    }

    @When("^запоминаем первые наушники в списке$")
    public void getFirstPhonesProduct(){
        phonesSteps.getFirstProduct();
    }

    @When("^вводим первые наушники в поиск$")
    public void searchFirstPhonesProduct(){
        phonesSteps.searchFirstProduct();
    }

    @Then("^проверяем соответствие искомых и найденный наушников$")
    public void checkFirstPhonesIsSearched(){
        phonesSteps.checkFirstIsSearched();
    }
}
