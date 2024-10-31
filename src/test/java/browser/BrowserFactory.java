package browser;


import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;

public class BrowserFactory {

    public static void setBrowser(Browser browser) {
        switch (browser) {
            case CHROME:
                Configuration.browser = Browsers.CHROME;
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                break;
            case YANDEX:
                Configuration.browser = Browsers.CHROME;
                System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver");
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }
}
