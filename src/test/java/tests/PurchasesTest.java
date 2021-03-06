package tests;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import utils.Log;
import utils.Person;

import static com.codeborne.selenide.Condition.visible;

public class PurchasesTest extends TestBeforeAllAfterAll {

    BaseMenu baseMenu = new BaseMenu();
    ProductsPage productsPage;
    CartPage cartPage = new CartPage();
    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();
    Person myPerson = new Person.Builder()
            .withFirstName("Jane")
            .withLastName("Doe")
            .withPostalCode("32")
            .build();

    @Parameters({"logIn", "password"})
    @BeforeClass
    public void logInBeforeTest(String logIn, String password) {
        LogInPage logInPage = new LogInPage();
        productsPage = logInPage.logIn(logIn, password);
        productsPage.productsTitle.shouldBe(visible);
    }

    @Step(value = "Go to 'AllItems' add items to cart")
    @BeforeMethod
    public void beforeTest() {
        Log.info("Переходим по пункту меню 'AllItems'");
        baseMenu.menuIcon.click();
        baseMenu.allItems.click();
        productsPage.productsTitle.shouldBe(visible);
        Log.info("Добавляем в корзину товары");
        productsPage.addToCart(productsPage.sauceLabsBackpackAddTooCartButton);
        productsPage.addToCart(productsPage.sauceLabsBikeLightAddTooCartButton);
    }

    @AfterMethod
    public void afterTest() {
        Log.info("Удаляем товары из корзины");
        baseMenu.moveToCart().cleanOutCart();
    }

    @Feature(value = "Tests for task 6")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Метод для проверки суммы покупки")
    @Test(groups = {"regressionTest"})
    public void countingGoodsCostTest() throws InterruptedException {
        Log.info("Метод для проверки суммы покупки");
        OverViewPage overViewPage = baseMenu.moveToCart().checkOut().yourInformationFill(myPerson);
        double sumPricesExpected = overViewPage.sumPrices();
        overViewPage.totalPriceLabel.shouldBe(visible);
        double sumPricesActual = overViewPage.getTotalPriceFromPage();
        Assert.assertEquals(sumPricesActual, sumPricesExpected);
    }

    @Feature(value = "Tests for task 6")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Метод для проверки отмены покупки")
    @Test(groups = {"regressionTest"})
    public void purchaseCancellingTest() {
        Log.info("Метод для проверки отмены покупки");
        baseMenu.moveToCart().checkOut().yourInformationFill(myPerson).cancelButton.click();
        productsPage.productsTitle.shouldBe(visible);
        Assert.assertEquals(productsPage.productsTitle.getText(), "PRODUCTS");
    }

    @Feature(value = "Tests for task 6")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Метод для проверки покупки")
    @Test(groups = {"regressionTest"})
    public void purchaseTest() {
        Log.info("Метод для проверки покупки");
        baseMenu.moveToCart().checkOut().yourInformationFill(myPerson).finishButton.click();
        String actualThankMessage = checkoutCompletePage.thankMessage.getText();
        Assert.assertEquals(actualThankMessage, "THANK YOU FOR YOUR ORDER");
    }

    @Feature(value = "Tests for task 6")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Метод для проверки удаления из корзины")
    @Test(groups = {"regressionTest"})
    public void removingFromCartTest() {
        Log.info("Метод для проверки удаления из корзины");
        baseMenu.moveToCart().cleanOutCart();
        Assert.assertTrue(cartPage.removeButtonCollection.isEmpty());
    }

    @Step(value = "Logging out")
    @AfterClass
    public void logOutAfterTest() {
        baseMenu.logOut();
    }
}
