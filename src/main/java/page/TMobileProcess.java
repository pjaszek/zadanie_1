package page;

import lombok.AllArgsConstructor;
import lombok.Getter;
import page.pagefragments.Header;
import page.pagefragments.NavigationBar;
import page.pagefragments.NavigationTab;

@Getter
public class TMobileProcess {

    private final Header header = new Header();
    private final NavigationBar navigationBar = new NavigationBar();
    private final HomePage homePage = new HomePage();

    @AllArgsConstructor
    @Getter
    public enum Tab implements NavigationTab {

        DEVICES("Urządzenia");

        private final String tabName;
    }
}
