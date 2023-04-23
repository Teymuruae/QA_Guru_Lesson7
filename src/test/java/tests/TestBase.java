package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

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
        Configuration.holdBrowserOpen = true;
    }
}
