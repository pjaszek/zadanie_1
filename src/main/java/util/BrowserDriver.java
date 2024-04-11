package util;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;

public class BrowserDriver {

    public static void configureBrowser() {
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.timeout = 30000L;
        Configuration.pollingInterval = 500L;
        Configuration.pageLoadTimeout = 60000L;
        Configuration.reportsFolder = "allure-results";
        Configuration.fastSetValue = true;
    }

    @After
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
        WebDriverRunner.clearBrowserCache();
    }
}
