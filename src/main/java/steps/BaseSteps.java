package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import util.Init;

public class BaseSteps {
    @Before
    public void initDriver() {
        Init.initDriver();
    }

    @After
    public void closeDriver() {
        Init.closeDriver();
    }
}


