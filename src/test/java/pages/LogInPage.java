package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.Log;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LogInPage{

    public SelenideElement userNameField = $(byXpath("//input[@id='user-name']"));
    public SelenideElement passwordField = $(byXpath("//input[@id='password']"));
    public SelenideElement logInButton = $(byXpath("//input[@id='login-button']"));

    @Step(value = "Fill in login {0} and pass {1}")
    public ProductsPage logIn(String logIn, String password) {
        Log.info("Логинимся");
        userNameField.sendKeys(logIn);
        passwordField.sendKeys(password);
        logInButton.click();
        return new ProductsPage();
    }


}
