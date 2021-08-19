package pages;

import com.codeborne.selenide.SelenideElement;
import utils.Log;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class BaseMenu {

    public SelenideElement menuIcon = $(byXpath("//button[@id='react-burger-menu-btn']"));
    public SelenideElement logOutItem = $(byXpath("//a[@id='logout_sidebar_link']"));
    public SelenideElement allItems = $(byXpath("//a[@id='inventory_sidebar_link']"));
    public SelenideElement shoppingCart = $(".shopping_cart_link");

    public CartPage moveToCart() {
        Log.info("Переходим в корзину");
        shoppingCart.click();
        return new CartPage();
    }

    public LogInPage logOut() {
        menuIcon.click();
        logOutItem.click();
        return new LogInPage();
    }
}
