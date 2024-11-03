package praktikum.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage {

    private final SelenideElement nameField =
            $(byXpath("//label[text()='Имя']/following-sibling::input"));

    private final SelenideElement emailField =
            $(byXpath("//*[text()='Email']/following-sibling::input"));

    private final SelenideElement passwordField =
            $(byXpath("//*[text()='Пароль']/following-sibling::input"));

    private final SelenideElement registrationButton =
            $(byXpath("//button[text()='Зарегистрироваться']"));

    private final SelenideElement loginButton =
            $(byXpath("//a[text()='Войти']"));

    private final SelenideElement passwordError =
            $(byXpath("//p[text()='Некорректный пароль']"));

    @Step("Ввод регистрационных данных(Имя, Email, Пароль).")
    public RegistrationPage setRegistrationData(String name, String email, String password) {
        nameField.setValue(name);
        emailField.setValue(email);
        passwordField.setValue(password);
        return this;
    }

    @Step("Нажатие на кнопку 'Зарегистрироваться'.")
    public LoginPage clickRegistrationButton() {
        registrationButton.click();
        return page(LoginPage.class);
    }

    @Step("Нажатие на кнопку 'Войти'.")
    public LoginPage clickLoginButtonRegisterPage() {
        loginButton.click();
        return page(LoginPage.class);
    }

    @Step("Проверка наличия сообщения о некорректном вводе пароля.")
    public void checkPasswordError() {
        clickRegistrationButton();
        passwordError.shouldBe(visible);
    }


}
