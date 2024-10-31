package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import praktikum.api.pojo.request.RegisterRequest;
import praktikum.pages.LoginPage;
import praktikum.pages.MainPage;
import tests.base.BaseTest;

import static com.codeborne.selenide.Selenide.*;
import static praktikum.constants.Urls.BASE_URL;
import static praktikum.constants.Urls.LOGIN_URL;

public class ProfilePageTest extends BaseTest {

    @Before
    public void login() {
        token = api.getToken(new RegisterRequest(email, password, name));
        open(LOGIN_URL, LoginPage.class)
                .setLoginData(email, password)
                .clickLoginButton()
                .checkMainPage();
    }

    @Test
    @DisplayName("Проверка выхода из аккаунта.")
    @Description("Проверка выхода из аккаунта по кнопке 'Выйти' в личном кабинете.")
    public void logOutTest() {
        open(BASE_URL, MainPage.class)
                .clickAccountButtonAuth()
                .clickLogoutButton()
                .checkLoginPage();
    }

    @Test
    @DisplayName("Проверка перехода по клику на кнопку 'Личный кабинет'.")
    @Description("Проверка перехода в личный кабинет, проверка отображения страницы.")
    public void clickAccountButtonTest() {
        open(BASE_URL, MainPage.class)
                .clickAccountButtonAuth()
                .checkProfilePage();
    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета на главную, через кнопку 'Конструктор' в хедере.")
    @Description("Проверка корректного перехода, проверка наличия меню в конструкторе.")
    public void fromProfileToHomeConstructTest() {
        open(BASE_URL, MainPage.class)
                .clickAccountButtonAuth()
                .clickConstructor()
                .checkConstructorContainer();
    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета на главную, через лого в хедере.")
    @Description("Проверка корректного перехода, проверка наличия меню в конструкторе.")
    public void fromProfileToHomeLogoTest() {
        open(BASE_URL, MainPage.class)
                .clickAccountButtonAuth()
                .clickLogo()
                .checkConstructorContainer();
    }

}
