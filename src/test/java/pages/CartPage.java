package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import utils.Log;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage{

    public ElementsCollection removeButtonCollection = $$(byXpath("//button[text()='Remove']"));
    public SelenideElement checkoutButton = $(byXpath("//button[@id='checkout']"));

    public void cleanOutCart() {
        Log.info("Очищаем корзину");
        for (SelenideElement removeButton: removeButtonCollection) {
            removeButton.click();
        }
    }
    public YourInformationPage checkOut() {
        Log.info("Заполняем поля информации для покупки");
        checkoutButton.click();
        return new YourInformationPage();
    }





}
