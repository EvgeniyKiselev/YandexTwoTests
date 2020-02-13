package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Init;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(xpath = "//input[@id='header-search']")
    private static WebElement search;

    @FindBy(xpath = "//button[@role='button' and @type='submit']")
    private static WebElement submit;

    @FindBy(xpath = "//button[@role='listbox']")
    private static WebElement listbox;

    @FindBy(xpath = "//span[@class='select__text' and contains(text(), 'Показывать по 12')]")
    private static WebElement chooseTheTwelve;

    @FindBy(xpath = "//div[contains(@class, 'n-snippet-') and contains(@data-bem,'snippet-card')]")
    private static List<WebElement> twelve;

    @FindBy(xpath = "//div[contains(@class, 'n-snippet-') and contains(@data-bem,'snippet-card')]//h3//a")
    private static List<WebElement> firstProducts;

    @FindBy(xpath = "//div[contains(@class, 'n-snippet-') and contains(@data-bem,'snippet-card')]//h3//a")
    private static List<WebElement> chechedProducts;

    void waitForElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    void waitForClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    BasePage() {
        this.driver = Init.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5);
    }

    void turnCountsToTwelve() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(listbox);
        listbox.click();
        waitForElement(chooseTheTwelve);
        waitForClickable(chooseTheTwelve);
        chooseTheTwelve.click();
        Thread.sleep(6000);
    }

    void fillField(WebElement element, String value) {
        waitForElement(element);
        waitForClickable(element);
        element.click();
        element.clear();
        element.sendKeys(value);
    }

    void setCheckBoxed(WebElement element) {
        waitForElement(element);
        waitForClickable(element);
        element.click();
    }

    public void checkTheCount() {
        if (twelve.size() != 12) {
            System.out.println("Количество товаров на странице не равно 12!");
        }
    }

    public String getFirstProduct() {
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        return firstProducts.get(0).getText();
    }

    public void searchFirstProduct() {
        fillField(search, getFirstProduct());
        submit.click();
    }

    public void checkFirstIsSearched() {
        String checkedProduct = chechedProducts.get(0).getText();
        Assert.assertEquals("Наименование товара не соответствует запомненному значению", getFirstProduct(), checkedProduct);
    }
}