package browser;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;

public class BrowserFactory {

    private static final String BROWSER_PROPERTY = "browser";
    private static final String DEFAULT_BROWSER = "chrome";
    private static final String WEBDRIVER_CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

// Для выбора браузера в конфигурации запуска нужно указать ключ -Dbrowser=chrome или -Dbrowser=yandex

    public static void createWebDriver() {
        String browser = System.getProperty(BROWSER_PROPERTY, DEFAULT_BROWSER);
        WebDriverConfig webDriverConfig = ConfigFactory.create(WebDriverConfig.class);
        switch (browser) {
            case "chrome":
                System.setProperty(WEBDRIVER_CHROME_DRIVER_PROPERTY, webDriverConfig.chromeDriverPath());
                Configuration.browserSize = webDriverConfig.browserSize();
                break;
            case "yandex":
                System.setProperty(WEBDRIVER_CHROME_DRIVER_PROPERTY, webDriverConfig.yandexDriverPath());
                Configuration.browserSize = webDriverConfig.browserSize();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }
}
