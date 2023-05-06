package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.time.Duration;

public class TestBase {

    private static String baseUrl = "https://demoqa.com";
    private static String browserSize = "1920x1080";
    @BeforeAll
    public static void beforeAll(){
        Configuration.baseUrl = baseUrl;
        Configuration.browserSize = browserSize;
//        Configuration.pageLoadTimeout = 15000;
//        Configuration.browser = "fireFox";
        Configuration.pageLoadStrategy = "eager";
//        Configuration.holdBrowserOpen = true;
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
