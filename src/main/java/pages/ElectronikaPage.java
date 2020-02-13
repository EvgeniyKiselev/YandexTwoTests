package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.Init;

public class ElectronikaPage extends BasePage {
    @FindBy(xpath = "//a[@href = '/catalog--televizory/59601/list?hid=90639']")
    private static WebElement tv;

    @FindBy(xpath = "//a[@href = '/catalog--naushniki-i-bluetooth-garnitury/56179/list?hid=90555']")
    private WebElement phones;

    public void selectTv() {
        waitForElement(tv);
        waitForClickable(tv);
        tv.click();
    }

    public void selectPhones() {
        waitForElement(phones);
        waitForClickable(phones);
        phones.click();
    }

    public ElectronikaPage() {
        this.driver = Init.getDriver();
    }
}
