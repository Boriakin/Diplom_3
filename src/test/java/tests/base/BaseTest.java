package tests.base;

import org.junit.After;
import org.junit.BeforeClass;
import praktikum.api.apis.UserApi;
import browser.BrowserFactory;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static tests.base.testdata.FakeData.*;

public class BaseTest {

    protected final String name = getFakeName();
    protected final String email = getFakeEmail();
    protected final String password = getFakePassword();
    protected final String wrongPassword = getWrongPass();
    protected UserApi api = new UserApi();
    protected String token;


    @BeforeClass
    public static void setUp() {
        BrowserFactory.createWebDriver();
    }

    @After
    public void tearDown() {
        closeWebDriver();
        if (token != null) api.deleteUser(token);
    }

}
