package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.Log;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBeforeAllAfterAll {

    @BeforeSuite (groups = {"smokeTest"})
    public void setUp() {
        Log.info("Метод выполняется перед набором тестов, объединенных в suit");
        Configuration.startMaximized = true;
        Configuration.timeout = 60000;
           open("https://www.saucedemo.com/");
    }

    @AfterSuite (groups = {"smokeTest"})
    public void tearDown() {
        Log.info("Метод выполняется после набора тестов, объединенных в suit");
        closeWebDriver();
    }

}