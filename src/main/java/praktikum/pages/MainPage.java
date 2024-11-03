package praktikum.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;
import static praktikum.constants.Urls.BASE_URL;

public class MainPage {

    private final SelenideElement loginButtonMainPage =
            $(byXpath("//button[text()='Войти в аккаунт']"));

    private final SelenideElement orderButton =
            $(byXpath("//button[text()='Оформить заказ']"));

    private final SelenideElement constructorHeader =
            $(byXpath("//h1[text()='Соберите бургер']"));

    private final SelenideElement bunsTab =
            $(byXpath("//div[span[text()='Булки']]"));

    private final SelenideElement sauceTab =
            $(byXpath("//div[span[text()='Соусы']]"));

    private final SelenideElement fillingsTab =
            $(byXpath("//div[span[text()='Начинки']]"));

    private final SelenideElement bunsConstructorElement =
            $(byXpath("//img[@alt='Флюоресцентная булка R2-D3']"));

    private final SelenideElement sauceConstructorElement =
            $(byXpath("//img[@alt='Соус Spicy-X']"));

    private final SelenideElement fillingsConstructorElement =
            $(byXpath("//img[@alt='Мясо бессмертных моллюсков Protostomia']"));

    private final SelenideElement sectionIngredients =
            $(byClassName("tab_tab_type_current__2BEPc"));

    private final SelenideElement constructorContainer =
            $(byXpath("//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']"));

    private final Header header = new Header();

    @Step("Нажатие на кнопку 'Войти в аккаунт' на главной странице.")
    public LoginPage clickLoginButtonMain() {
        loginButtonMainPage.click();
        return page(LoginPage.class);
    }

    @Step("Нажатие на вкладку 'Булки'.")
    public MainPage clickBunsTab() {
        bunsTab.click();
        return this;
    }

    @Step("Нажатие на вкладку 'Соусы'.")
    public MainPage clickSauceTab() {
        sauceTab.click();
        return this;
    }

    @Step("Нажатие на вкладку 'Начинки'.")
    public MainPage clickFillingTab() {
        fillingsTab.click();
        return this;
    }

    @Step("Проверка, что элемент вкладки 'Булки' находится в видимой области окна браузера.")
    public void checkBunElement() {
        bunsConstructorElement.shouldBe(appear);
    }

    @Step("Проверка, что элемент вкладки 'Соусы' находится в видимой области окна браузера.")
    public void checkSauceElement() {
        sauceConstructorElement.shouldBe(appear);
    }

    @Step("Проверка, что элемент вкладки 'Начинки' находится в видимой области окна браузера.")
    public void checkFilingElement() {
        fillingsConstructorElement.shouldBe(appear);
    }

    @Step("Проверка видимоcти контейнера конструктора и соответсвия URL.")
    public void checkConstructorContainer() {
        constructorContainer.shouldBe(visible);
        assertEquals(BASE_URL, url());
    }


    @Step("Проверка наличия кнопки 'Оформить заказ' на главной странице и соответсвия URL.")
    public void checkMainPage() {
        orderButton.shouldBe(visible);
        assertEquals(BASE_URL, url());
    }

    @Step("Нажатие на кнопку 'Личный кабинет' с главной страницы(авторизованный пользователь).")
    public ProfilePage clickAccountButtonAuth() {
        header.clickAccountButtonInHeader();
        return page(ProfilePage.class);
    }

    @Step("Нажатие на кнопку 'Личный кабинет' с главной страницы(неавторизованный пользователь).")
    public LoginPage clickAccountButtonNonAuth() {
        header.clickAccountButtonInHeader();
        return page(LoginPage.class);
    }

}
