import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.*;
import util.Init;
import java.util.*;

import static util.Init.initDriver;

public class TestYandexAllureTest {

    MainPageSteps mainPageSteps = new MainPageSteps();
    ElectronicaSteps electronicaSteps = new ElectronicaSteps();
    TvSteps tvSteps = new TvSteps();
    PhonesSteps phonesSteps = new PhonesSteps();
    LinkedHashMap<String, String> testData = new LinkedHashMap<>();

    @Before
    public void setUp(){
        initDriver();
    }

    @After
    public void close() {
        Init.closeDriver();
    }

    @Test
    public void testYandexTvTest()  throws Exception {

        mainPageSteps.selectYandexMarket();
        mainPageSteps.selectElectronics();
        electronicaSteps.selectTvCatalog();
        tvSteps.turnToTwelve();
        tvSteps.setPrice("20000");
        tvSteps.setCheckBoxes();
        tvSteps.checkCountOfProducts();
        Thread.sleep(6000);
        tvSteps.getFirstProduct();
        tvSteps.searchFirstProduct();
        tvSteps.checkFirstIsSearched();
    }

    @Test
    public void testYandexPhonesTest() throws Exception {

        mainPageSteps.selectYandexMarket();
        mainPageSteps.selectElectronics();
        electronicaSteps.selectPhonesCatalog();
        phonesSteps.turnToTwelve();
        phonesSteps.setPrice("5000");
        phonesSteps.setCheckBoxes();
        phonesSteps.checkCountOfProducts();
        Thread.sleep(6000);
        phonesSteps.getFirstProduct();
        phonesSteps.searchFirstProduct();
        phonesSteps.checkFirstIsSearched();
    }
}
