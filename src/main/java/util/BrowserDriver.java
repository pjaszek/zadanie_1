package util;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserDriver {

    public static void configureBrowser() {
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.timeout = 30000L;
        Configuration.pollingInterval = 500L;
        Configuration.pageLoadTimeout = 60000L;
        Configuration.reportsFolder = "allure-results";
        Configuration.fastSetValue = true;

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--user-data-dir=" + System.getProperty("java.io.tmpdir"));
        Configuration.browserCapabilities = chromeOptions;
    }

    @After
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
        WebDriverRunner.clearBrowserCache();
    }
}
