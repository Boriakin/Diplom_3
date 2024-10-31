package praktikum.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;
import static praktikum.constants.Urls.BASE_URL;
import static praktikum.constants.Urls.LOGIN_URL;

public class LoginPage {

    private final SelenideElement emailField =
            $(byXpath("//input[@name='name']"));

    private final SelenideElement passwordField =
            $(byXpath("(//input[@name='Пароль'])"));

    private final SelenideElement loginButton =
            $(byXpath("//button[contains(text(),'Войти')]"));

    private final SelenideElement authForm =
            $(byXpath("//button[text()='Войти']/parent::form"));

    @Step("Ввод авторизационных данных(Email, Пароль).")
    public LoginPage setLoginData(String email, String password) {
        emailField.setValue(email);
        passwordField.setValue(password);
        return this;
    }

    @Step("Нажатие на кнопку 'Войти'.")
    public MainPage clickLoginButton() {
        loginButton.click();
        return page(MainPage.class);
    }

    @Step("Проверка наличия формы авторизации и соответствия URL страницы логина.")
    public LoginPage checkLoginPage() {
        authForm.shouldBe(visible);
        assertEquals(LOGIN_URL, url());
        return this;
    }

}
