package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;
import java.util.Map;

public class TestBase {

    private static String browser = System.getProperty("browser", "chrome");
    private static String browserVersion = System.getProperty("browserVersion", "100.0");
    private static String remoteBrowser = System.getProperty("remoteBrowser", "selenoid.autotests.cloud");
    private static String baseUrl = System.getProperty("baseUrl", "https://demoqa.com" );
    private static String browserSize = System.getProperty("browserSize", "1920x1080" );

    @BeforeAll
    public static void beforeAll(){


        WebDriverManager.chromedriver().setup();
        Configuration.baseUrl = baseUrl;
        Configuration.browserSize = browserSize;
        Configuration.pageLoadTimeout = 15000;
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = browser;
        Configuration.browserVersion = browserVersion;

        Configuration.remote = String.format("https://user1:1234@%s/wd/hub", remoteBrowser);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;


    }

    @BeforeEach
    public void setUp(){
        SelenideLogger.addListener("allure", new AllureSelenide());
    }


    @AfterEach
    public void afterEach(){
        Attachments.attachScreenshot();
        Attachments.addVideo();
        Attachments.browserConsoleLogs();
        Attachments.pageSource();
    }
}
