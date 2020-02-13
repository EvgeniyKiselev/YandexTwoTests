package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Init;

public class MainPage extends BasePage {

    @FindBy(xpath = "//a[@data-id='market']")
    private WebElement market;

    @FindBy(xpath = "//a[@href = '/catalog--elektronika/54440']")
    private WebElement electronic;

    public MainPage() {
        this.driver = Init.getDriver();
    }

    public void selectMarket() {
        market.click();
    }

    public void selectElectronic() {
        electronic.click();
    }
}
