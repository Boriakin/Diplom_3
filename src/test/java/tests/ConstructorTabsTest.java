package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import praktikum.pages.MainPage;
import tests.base.BaseTest;

import static com.codeborne.selenide.Selenide.open;
import static praktikum.constants.Urls.BASE_URL;

public class ConstructorTabsTest extends BaseTest {

    @Test
    @DisplayName("Проверка перехода к разделу 'Булки'.")
    public void transitionBunsTabTest() {
        open(BASE_URL, MainPage.class)
                .clickSauceTab()
                .clickBunsTab()
                .checkBunElement();
    }

    @Test
    @DisplayName("Проверка перехода к разделу 'Соусы'.")
    public void transitionSauceTabTest() {
        open(BASE_URL, MainPage.class)
                .clickFillingTab()
                .clickSauceTab()
                .checkSauceElement();
    }

    @Test
    @DisplayName("Проверка перехода к разделу 'Начинки'.")
    public void transitionFillingTabTest() {
        open(BASE_URL, MainPage.class)
                .clickFillingTab()
                .checkFilingElement();
    }
}
