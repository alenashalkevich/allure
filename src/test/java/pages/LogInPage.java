package pages;

import com.codeborne.selenide.SelenideElement;
import utils.Log;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LogInPage{

    public SelenideElement userNameField = $(byXpath("//input[@id='user-name']"));
    public SelenideElement passwordField = $(byXpath("//input[@id='password']"));
    public SelenideElement logInButton = $(byXpath("//input[@id='login-button']"));

    public ProductsPage logIn(String logIn, String password) {
        Log.info("Логинимся");
        userNameField.sendKeys(logIn);
        passwordField.sendKeys(password);
        logInButton.click();
        return new ProductsPage();
    }


}
