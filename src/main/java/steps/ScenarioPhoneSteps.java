package steps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioPhoneSteps {
    MainPageSteps mainPageSteps = new MainPageSteps();
    ElectronicaSteps electronicaSteps = new ElectronicaSteps();
    PhonesSteps phonesSteps = new PhonesSteps();

    @When("^переход в раздел ЯндексМаркет$")
    public void select2YandexMarket(){
        mainPageSteps.selectYandexMarket();
    }

    @When("^переход в раздел Электроника$")
    public void select2Electronics(){
        mainPageSteps.selectElectronics();
    }

    @When("^осуществлен переход в раздел Наушники$")
    public void selectPhonesCatalog(){
        electronicaSteps.selectPhonesCatalog();
    }

    @When("ограничиваем количество наушников до 12")
    public void turnPhonesToTwelve() throws InterruptedException {
        phonesSteps.turnToTwelve();
    }

    @When("^Устанавливаем цену от: \"(.*)\"")
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
