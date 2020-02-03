package steps;
import io.qameta.allure.Step;
import pages.MainPage;
import pages.SberPage;
import pages.PolicyPage;

public class PolicySteps {
    @Step("выбрана минимальная сумма страховой защиты")
    public void selectMinimal() {
        new PolicyPage().selectMinimal();;
    }

    @Step("выполнено нажатие на кнопку Оформить")
    public void goToSendAppPage() {
        new PolicyPage().selectSendButton();
    }
}


