package util;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Loader {

    public static void waitForLoaderDisappear() {
        $("i[class*='fepProcessing']").shouldNotBe(visible);
    }
}
