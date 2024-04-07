package page.common;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class CookiesModal {

    private final String BUTTON_LOCATOR = "//span[text()='%s']//ancestor::button";

    @Step("Wybór przycisku dotyczącego ciasteczek na stronie głównej: {button}")
    public SelenideElement getButton(ButtonsHomePage button) {
        return $x(String.format(BUTTON_LOCATOR, button.buttonName));
    }

    @AllArgsConstructor
    @Getter
    public enum ButtonsHomePage {

        CONFIRM_COOKIES("Zaakceptuj wszystkie"),
        DECLINE_COOKIES("Zmień ustawienia");

        private final String buttonName;
    }
}
