package page.pagefragments;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.openqa.selenium.interactions.Actions;

import java.util.*;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class NavigationBar {

    private final ElementsCollection navigationBarItems = $$("#main-menu");

    @Step("Przejście do zakładki {string}")
    public SelenideElement goToTab(String tabName) {
        SelenideElement tab = navigationBarItems.asDynamicIterable().stream()
                .filter(tabs -> tabs.getText().contains(tabName))
                .findFirst().orElseThrow(() -> new NoSuchElementException("No tab with name: " + tabName));
        tab.hover();
        waitForLoaderDisappear();
        return tab;
    }

    @Step("Sprawdzenie czy wszystkie pola na widoku są nieedytowalne")
    public static void areAllFieldsReadOnly(List<SelenideElement> fieldsList) {
        fieldsList.forEach(field -> field.shouldBe(or
                ("Check if field is read only", disabled, hidden, not(interactable), not(editable))));
    }

    @SneakyThrows
    public SelenideElement clickDropdownButton(String column, String button) {

        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement($$("[id='main-menu'] button").first()).perform();
        SelenideElement elm = $$(".more-columns p").find(ownText(column)).shouldBe(visible);
        return elm.ancestor("li a").find(button);
//                .forEach(s -> s.ancestor("li a").find(button));
//
//                .forEach(c -> c.getText().equals(column));
//        SelenideElement menuTitle = navigationBarItems.asDynamicIterable().stream()
//                .filter(item -> item.find(".more-columns p").text().trim().equals(column))
//                .findAny()
//                .orElseThrow(() -> new IllegalArgumentException("Column not found: " + column))
//                .ancestor("li a")
//                .find(button);
//        menuTitle.click();
//        waitForLoaderDisappear();
    }

    public void isDropdownListIsVisible() {
        navigationBarItems.asDynamicIterable().stream()
                .map(list -> list.find(".more-columns p").text())
                .collect(Collectors.joining());
//        String str = navigationBarItems.asDynamicIterable().stream().forEach(list -> list.find(".more-columns p"));
    }

    private void waitForLoaderDisappear() {
        $("i[class*='fepProcessing']").shouldNotBe(visible);
    }
}
