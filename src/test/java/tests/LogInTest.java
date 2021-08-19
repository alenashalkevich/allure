package tests;

import com.opencsv.CSVReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BaseMenu;
import pages.LogInPage;
import pages.ProductsPage;
import utils.Log;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;

public class LogInTest extends TestBeforeAllAfterAll{

    @DataProvider
    public Object[][] dataProvider() {
        Object[][] loginData = null;
        try (CSVReader reader = new CSVReader(new FileReader("src/test/resources/loginData.csv"))) {
            List<String[]> r = reader.readAll();
            loginData = new Object[r.size()][r.get(0).length]; //5 rows * 2 columns
            for (int i = 0; i < r.size(); i++) {
                loginData[i][0] = r.get(i)[0];
                loginData[i][1] = r.get(i)[1];
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loginData;
    }

    @Test(groups = {"smokeTest"}, dataProvider = "dataProvider")
    public void logInTest(String logIn, String password) {
        Log.info("Метод для проверки logIn");
        LogInPage logInPage = new LogInPage();
        ProductsPage productsPage = logInPage.logIn(logIn, password);
        productsPage.productsTitle.shouldBe(visible);
        Assert.assertEquals(productsPage.productsTitle.getText(), "PRODUCTS");
        BaseMenu baseMenu = new BaseMenu();
        baseMenu.logOut();
    }

}