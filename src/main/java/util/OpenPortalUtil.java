package util;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static util.PropertiesUtil.getProperties;

public class OpenPortalUtil {

    @Step("Otwarcie portalu t-mobile")
    public static void openExternalPortal(String url) {
        getProperties().getProperty("base_url");
        Selenide.open(url);
    }
}
