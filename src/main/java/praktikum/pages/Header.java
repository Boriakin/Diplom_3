package praktikum.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class Header {

    private final SelenideElement constructorButton =
            $(byXpath("//p[text()='Конструктор']"));

    private final SelenideElement logo =
            $(byXpath("//div[@class='AppHeader_header__logo__2D0X2']"));

    private final SelenideElement accountButton =
            $(byXpath("//p[text()='Личный Кабинет']"));

    public void clickAccountButtonInHeader() {
        accountButton.click();
    }

    public void clickConstructorButton() {
        constructorButton.click();
    }

    public void clickLogo() {
        logo.click();
    }

}
