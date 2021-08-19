package tests;

import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BaseMenu;
import pages.LogInPage;
import utils.Log;
import static com.codeborne.selenide.WebDriverRunner.url;

public class LogOutTest extends TestBeforeAllAfterAll{

    @Parameters({"logIn", "password"})
    @Test(groups = {"smokeTest"})
    public void logOutTest(String logIn, String password) {
        LogInPage logInPage = new LogInPage();
        logInPage.logIn(logIn, password);
        Log.info("Метод для проверки logOut");
        BaseMenu baseMenu = new BaseMenu();
        baseMenu.logOut();
        logInPage.logInButton.shouldBe(Condition.visible);
        String currentURL = url();
        Assert.assertEquals("https://www.saucedemo.com/", currentURL, "Открыта страница не https://www.saucedemo.com/ или указан некорректный URL");
    }
}
