package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static util.Init.getDriver;

public class MainPage extends BasePage {

    @FindBy(xpath = "//a[@data-id='market']")
    WebElement market;

    @FindBy(xpath = "//a[@href = '/catalog--elektronika/54440']")
    WebElement electronic;

    public MainPage(){
        this.driver = getDriver();
    }

    public void selectMarket(){
         WebElement market = driver.findElement(By.xpath("//a[@data-id='market']"));
        market.click();
    }

    public void selectElectronic(){
        WebElement electronic = driver.findElement(By.xpath("//a[@href = '/catalog--elektronika/54440']"));
        electronic.click();
    }
}
