package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static java.lang.String.format;

public class TestBase {

    @BeforeAll
    static void setup() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";


        /*Configuration.baseUrl = "https://demoqa.com";
        Configuration.remote = format("https://%s@%s/wd/hub", System.getProperty("login"), System.getProperty("rwhost"));

        String browser = System.getProperty("browser", "chrome 125.0");
        int spaceIndex = browser.indexOf(" ");
        Configuration.browser = browser.substring(0, spaceIndex);
        Configuration.browserVersion = browser.substring(spaceIndex + 1);
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");*/

        Configuration.pageLoadStrategy = "eager";
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        if (!Configuration.browser.equals("firefox")) {
            Attach.pageSource();
            Attach.browserConsoleLogs();
        }
        Attach.addVideo();
        closeWebDriver();
    }
}