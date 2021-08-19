package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutCompletePage{

    public SelenideElement thankMessage = $(byXpath("//h2[contains(text(),'THANK YOU FOR YOUR ORDER')]"));

}
