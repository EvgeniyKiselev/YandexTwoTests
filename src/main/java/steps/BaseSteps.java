package steps;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.Init;

import java.util.concurrent.TimeUnit;

public class BaseSteps {
    @Before
    public void initDriver(){
        Init.initDriver();

    }
    @After
    public void closeDriver(){
        Init.closeDriver();

    }
}


