package page.pagefragments;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.NoSuchElementException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class NavigationBar {

    private final ElementsCollection navigationBarItems = $$("#main-menu>div");
    private final SelenideElement expandNavigationTabsButton = $("#applicationRestBtn");

    @Step("Przejście do zakładki {navigationTab.tabName}")
    public void goToTab(NavigationTab navigationTab) {
        expandNavigationTabs();
        SelenideElement tab = navigationBarItems.asDynamicIterable().stream()
                .filter(tabs -> tabs.getText().contains(navigationTab.getTabName()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No tab with name: " + navigationTab.getTabName()));
        tab.click();
        waitForLoaderDisappear();
    }

    private void expandNavigationTabs() {
        if (expandNavigationTabsButton.isDisplayed()) {
            expandNavigationTabsButton.click();
            waitForLoaderDisappear();
        }
    }

    private void waitForLoaderDisappear() {
        $("i[class*='fepProcessing']").shouldNotBe(visible);
    }
}
