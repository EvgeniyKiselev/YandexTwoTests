package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class ScenarioSteps {
    MainPageSteps mainPageSteps = new MainPageSteps();
    SberSteps sberSteps = new SberSteps();
    PolicySteps policySteps = new PolicySteps();
    SendAppSteps sendAppSteps = new SendAppSteps();

    @When("^выбран пункт меню \"(.+)\"$")
    public void selectMenuItem(){
        mainPageSteps.selectMenuItem();
    }

    @When("^выбран вид страхования \"(.+)\"$")
    public void selectMenuInsurance(){
        mainPageSteps.selectMenuInsurance();
    }

    @Then("^заголовок страницы - Страхование путешественников равен \"(.+)\"$")
    public void checkTitleSberPage(){
        sberSteps.checkPageTitle();
    }

    @When("^выполнено нажатие на кнопку Оформить онлайн$")
    public void clickBtnSendApp(){
        sberSteps.goToPolicyPage();
    }

    @When("^выбрана Минимальная сумма страховой защиты$")
    public void clickMinimal(){
        policySteps.selectMinimal();
    }

    @When("^нажата кнопка Оформить$")
    public void clickGoToSendAppPage(){
        policySteps.goToSendAppPage();
    }

    @When("^заполняются поля:$")
    public void fillForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> sendAppSteps.fillField(field, value));

    }

    @Then("^значения полей равны:$")
    public void checkFillFields(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> sendAppSteps.checkFillField(field, value));
    }

    @When("^нажата кнопка продолжить$")
    public void clickSendButton(){
        sendAppSteps.clickSendButton();
    }


    @Then("^выведено сообщение об ошибке")
    public void checkErrorMessage(){
        sendAppSteps.getErrorMessageField();
        sendAppSteps.checkErrorMessage("При заполнении данных произошла ошибка");
    }

}
