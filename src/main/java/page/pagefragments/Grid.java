package page.pagefragments;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.ClickOptions.usingJavaScript;
import static com.codeborne.selenide.Selenide.$;
import static util.Loader.waitForLoaderDisappear;

public class Grid {

    private final SelenideElement grid = $("[class*='productCards']");

    @Step("Otwarcie pierwszego rekordu z tabeli")
    public void openFirstRecord() {
        grid.click(usingJavaScript());
        waitForLoaderDisappear();
    }
}
