package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import praktikum.api.pojo.request.RegisterRequest;
import praktikum.pages.ForgotPasswordPage;
import praktikum.pages.MainPage;
import praktikum.pages.RegistrationPage;
import tests.base.BaseTest;

import static com.codeborne.selenide.Selenide.open;
import static praktikum.constants.Urls.*;

public class LoginPageTest extends BaseTest {

    @Before
    public void registration() {

        token = api.getToken(new RegisterRequest(email, password, name));
    }

    @Test
    @DisplayName("Вход по кнопке 'Войти в аккаунт' на главной.")
    @Description("Авторизация пользователя по кнопке 'Войти в аккаунт' на главной.")
    public void loginMainButtonTest() {
        open(BASE_URL, MainPage.class)
                .clickLoginButtonMain()
                .checkLoginPage()
                .setLoginData(email, password)
                .clickLoginButton()
                .checkMainPage();
    }

    @Test
    @DisplayName("Вход по кнопке 'Личный кабинет' в хедере.")
    @Description("Авторизация пользователя по кнопке 'Личный кабинет' в хедере.")
    public void loginAccountButtonTest() {
        open(BASE_URL, MainPage.class)
                .clickAccountButtonNonAuth()
                .checkLoginPage()
                .setLoginData(email, password)
                .clickLoginButton()
                .checkMainPage();
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации.")
    @Description("Авторизация пользователя по кнопке в форме регистрации.")
    public void loginButtonInRegisterFormTest() {
        open(REGISTER_URL, RegistrationPage.class)
                .clickLoginButtonRegisterPage()
                .checkLoginPage()
                .setLoginData(email, password)
                .clickLoginButton()
                .checkMainPage();
    }

    @Test
    @DisplayName("Вход через кнопку на странице восстановления пароля.")
    @Description("Авторизация пользователя по кнопке на странице восстановления пароля.")
    public void loginButtonInForgotPassPageTest() {
        open(FORGOT_PASSWORD_URL, ForgotPasswordPage.class)
                .clickLoginButtonInForgotPassPage()
                .checkLoginPage()
                .setLoginData(email, password)
                .clickLoginButton()
                .checkMainPage();
    }
}
