package praktikum.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ForgotPasswordPage {

    private final SelenideElement loginButton =
            $(byXpath("//a[text()='Войти']"));

    @Step("Нажатие кнопки 'Войти' на странице восстановления пароля.")
    public LoginPage clickLoginButtonInForgotPassPage() {
        loginButton.click();
        return page(LoginPage.class);
    }

}
