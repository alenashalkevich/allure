package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.Log;
import utils.Person;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class YourInformationPage{

    public SelenideElement firstNameField = $(byXpath("//input[@id='first-name']"));
    public SelenideElement lastNameField = $(byXpath("//input[@id='last-name']"));
    public SelenideElement postalCodeField = $(byXpath("//input[@id='postal-code']"));
    public SelenideElement continueButton = $(byXpath("//input[@id='continue']"));

    @Step(value = "Filling your information")
    public OverViewPage  yourInformationFill(Person person) {
        Log.info("Заполняем информацию для покупки");
        firstNameField.setValue(person.getFirstName());
        lastNameField.setValue(person.getLastName());
        postalCodeField.setValue(person.getPostalCode());
        continueButton.click();
        return new OverViewPage();
    }
}
