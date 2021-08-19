package pages;

import com.codeborne.selenide.SelenideElement;
import utils.Log;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ProductsPage{

    public SelenideElement sauceLabsBackpackAddTooCartButton = $(byId("add-to-cart-sauce-labs-backpack"));
    public SelenideElement sauceLabsBikeLightAddTooCartButton = $(byId("add-to-cart-sauce-labs-bike-light"));
    public SelenideElement productsTitle = $(byXpath("//span[contains(text(),'Products')]"));

    public void addToCart(SelenideElement AddTooCartButton) {
        Log.info("Добавляем в корзину товар");
        AddTooCartButton.click();
    }
}
