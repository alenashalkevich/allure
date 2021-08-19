package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OverViewPage{

    public ElementsCollection productsCollection = $$(byXpath("//div[@class='inventory_item_price']"));
    public SelenideElement totalPrise = $(".summary_subtotal_label");
    public SelenideElement finishButton = $(byXpath("//button[@id='finish']"));
    public SelenideElement cancelButton = $(byXpath("//button[@id='cancel']"));
    public SelenideElement totalPriceLabel = $(byXpath("//div[@class='summary_total_label']"));

    public double sumPrices() {
        double sum = 0;
        for (SelenideElement product: productsCollection) {
            String price = product.getText().substring(1);
            sum += Double.parseDouble(price);
        }
        return sum;
    }

    public double getTotalPriceFromPage() {
        return Double.parseDouble(totalPrise.getText().substring(13));
    }



}
