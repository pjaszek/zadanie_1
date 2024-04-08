package page.pagefragments;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class Header {

    private final SelenideElement logo = $("#logo-svg");

    @Step("Powrót do strony głównej")
    public void isTMobileHomePageDisplayed() {
        logo.isDisplayed();
    }

    @Step("Powrót do strony głównej")
    public void returnToHomePage() {
        logo.click();
    }
}
