package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {

    private static String browser = System.getProperty("browser", "chrome");
    private static String browserVersion = System.getProperty("browserVersion", "99.0");
    private static String remoteBrowser = System
            .getProperty("remoteBrowser", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
    private static String baseUrl = System.getProperty("baseUrl", "https://demoqa.com");
    private static String browserSize = System.getProperty("browserSize", "1125x2436");
//    private static String browserSize = System.getProperty("browserSize", "1920x1080");

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        Configuration.baseUrl = baseUrl;
        Configuration.browserSize = browserSize;
        Configuration.pageLoadTimeout = 15000;
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = remoteBrowser;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
        switcher(browser);

    }

    @BeforeEach
    public void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    public void afterEach() {
        Attachments.attachScreenshot();
        Attachments.addVideo();
//        Attachments.browserConsoleLogs();
        Attachments.pageSource();
    }

    public static void switcher(String browser1) {
        switch (browser1) {
            case "chrome:100":
                Configuration.browserVersion = "100.0";
                Configuration.browser = "chrome";
                break;
            case "fireFox:97":
                Configuration.browserVersion = "97.0";
                Configuration.browser = "fireFox";
                break;
            case "fireFox:98":
                Configuration.browserVersion = "98.0";
                Configuration.browser = "fireFox";
                break;
            default:
                Configuration.browserVersion = "99.0";
                Configuration.browser = "chrome";
                break;
        }

    }
}
