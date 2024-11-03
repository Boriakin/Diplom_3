package praktikum.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;
import static praktikum.constants.Urls.PROFILE_URL;

public class ProfilePage {

    private final SelenideElement logoutButton =
            $$(".Account_button__14Yp3").findBy(text("Выход"));

    private final SelenideElement profileButton =
            $(byXpath("//a[text()='Профиль']"));

    private final Header header = new Header();

    @Step("Нажатие на кнопку выхода.")
    public LoginPage clickLogoutButton() {
        logoutButton.click();
        return page(LoginPage.class);
    }

    @Step("Проверка наличия вкладки 'Профиль' и соответсвия URL страницы.")
    public void checkProfilePage() {
        profileButton.shouldBe(visible);
        assertEquals(PROFILE_URL, url());
    }

    @Step("Нажатие на логотип со страницы профиля.")
    public MainPage clickLogo() {
        header.clickLogo();
        return page(MainPage.class);
    }

    @Step("Нажатие на кнопку 'Конструктор' со страницы профиля.")
    public MainPage clickConstructor() {
        header.clickLogo();
        return page(MainPage.class);
    }
}
