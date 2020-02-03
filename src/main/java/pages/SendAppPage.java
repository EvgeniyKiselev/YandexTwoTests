package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;
import util.Init;

import static util.Init.getDriver;

public class SendAppPage extends BasePage {
    @FindBy(xpath = "//div[contains(@class, 'active') and contains(., 'Оформление')]")
    WebElement navMenu;

    @FindBy(xpath = "//input[@id = 'surname_vzr_ins_0']")
    WebElement insuredLastName;

    @FindBy(xpath = "//input[@id = 'name_vzr_ins_0']")
    WebElement insuredName;

    @FindBy(xpath = "//input[@id = 'birthDate_vzr_ins_0']")
    WebElement insuredDateOfBirth;

    @FindBy(xpath = "//input[@id = 'person_lastName']")
    WebElement payerLastName;

    @FindBy(xpath = "//input[@id = 'person_firstName']")
    WebElement payerName;

    @FindBy(xpath = "//input[@id = 'person_middleName']")
    WebElement payerMiddleName;

    @FindBy(xpath = "//input[@id = 'person_birthDate']")
    WebElement payerDateOfBirth;

    @FindBy(xpath = "//input[@id = 'passportSeries']")
    WebElement docSeries;

    @FindBy(xpath = "//input[@id = 'passportNumber']")
    WebElement docNumber;

    @FindBy(xpath = "//input[@id = 'documentDate']")
    WebElement docDate;

    @FindBy(xpath = "//input[@id = 'documentIssue']")
    WebElement docIssue;

    @FindBy(xpath = "//button[contains(text(), 'Продолжить')]")
    WebElement sendButton;

    @FindBy(xpath = "//div[@class ='alert-form alert-form-error']")
    WebElement validationMessage;

    public SendAppPage() {
        this.driver = getDriver();
    }

    public void waitNavClickable(){
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(navMenu));
    }

    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Фамилия застрахованного":
                fillField(insuredLastName, value);
                break;
            case "Имя застрахованного":
                fillField(insuredName, value);
                break;
            case "Дата рождения застрахованного":
                fillField(insuredDateOfBirth, value);
                break;
            case "Фамилия страхователя":
                fillField(payerLastName, value);
                break;
            case "Имя страхователя":
                fillField(payerName, value);
                break;
            case "Отчество страхователя":
                fillField(payerMiddleName, value);
                break;
            case "Дата рождения страхователя":
                fillField(payerDateOfBirth, value);
                break;
            case "Серия паспорта":
                fillField(docSeries, value);
                break;
            case "Номер паспорта":
                fillField(docNumber, value);
                break;
            case "Дата выдачи паспорта":
                fillField(docDate, value);
                break;
            case "Кем выдан":
                fillField(docIssue, value);
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

    public String getFillField(String fieldName) {
        switch (fieldName) {
            case "Фамилия застрахованного":
                return insuredLastName.getAttribute("value");
            case "Имя застрахованного":
                return insuredName.getAttribute("value");
            case "Дата рождения застрахованного":
                return insuredDateOfBirth.getAttribute("value");
            case "Фамилия страхователя":
                return payerLastName.getAttribute("value");
            case "Имя страхователя":
                return payerName.getAttribute("value");
            case "Отчество страхователя":
                return payerMiddleName.getAttribute("value");
            case "Дата рождения страхователя":
                return payerDateOfBirth.getAttribute("value");
            case "Серия паспорта":
                return docSeries.getAttribute("value");
            case "Номер паспорта":
                return docNumber.getAttribute("value");
            case "Дата выдачи паспорта":
                return docDate.getAttribute("value");
            case "Кем выдан":
                return docIssue.getAttribute("value");
        }
        throw new AssertionError("Поле не объявлено на странице");
    }

    public void checkFieldErrorMessage(String field, String errorMessage) {
        String actualValue = getFieldErrorMessage();
        Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualValue, errorMessage),
                actualValue.contains(errorMessage));
    }

    public String getFieldErrorMessage() {
        return validationMessage.getText();
    }

    public void sendResult() {
        sendButton.click();
    }
}
