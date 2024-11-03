package browser;


import org.aeonbits.owner.Config;

@Config.Sources("classpath:config.properties")
public interface WebDriverConfig extends Config {


    @Key("chromeDriverPath")
    String chromeDriverPath();

    @Key("yandexDriverPath")
    String yandexDriverPath();

    @Key("browserSize")
    String browserSize();


}
