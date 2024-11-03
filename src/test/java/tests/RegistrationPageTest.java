package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import praktikum.pages.RegistrationPage;
import tests.base.BaseTest;

import static com.codeborne.selenide.Selenide.open;
import static praktikum.constants.Urls.REGISTER_URL;

public class RegistrationPageTest extends BaseTest {

    @Test
    @DisplayName("Успешная регистрация.")
    @Description("Проверка регистрации пользователя с валидными данными.")
    public void registrationSuccessTest() {
        open(REGISTER_URL, RegistrationPage.class)
                .setRegistrationData(name, email, password)
                .clickRegistrationButton()
                .checkLoginPage();
    }

    @Test
    @DisplayName("Регистрация с невалидным паролем.")
    @Description("Проверка регистрации пользователя с паролем меньше 6 символов.")
    public void registrationWrongPasswordTest() {
        open(REGISTER_URL, RegistrationPage.class)
                .setRegistrationData(name, email, wrongPassword)
                .checkPasswordError();
    }
}
