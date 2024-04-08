package page;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import lombok.Getter;
import page.common.CookiesModal;
import page.pagefragments.Header;

import static com.codeborne.selenide.Selenide.$;
import static page.common.CookiesModal.ButtonsHomePage.CONFIRM_COOKIES;

@Getter
public class HomePage {

    private final CookiesModal cookiesModal = new CookiesModal();
    private final Header header = new Header();
    private final SelenideElement logoImage = $("[id='back-top']").as("logo");

    @Step("Wybranie przycisku 'Zaakceptuj wszystkie' dla cookies")
    public void confirmCookies() {
        cookiesModal.getButton(CONFIRM_COOKIES).click();
    }

    @Step("Pobranie adresu URL")
    public String getUrl() {
        return WebDriverRunner.getAndCheckWebDriver().getTitle();
    }

    @Step("Weryfikacja czy logo na stronie głównej jest widoczne")
    public boolean isDisplayHomePage() {
        return logoImage.isDisplayed();
    }
}