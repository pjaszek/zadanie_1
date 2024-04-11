package page;

import lombok.Getter;
import page.pagefragments.Header;
import page.pagefragments.NavigationBar;

@Getter
public class TMobileProcess {

    private final Header header = new Header();
    private final NavigationBar navigationBar = new NavigationBar();
    private final HomePage homePage = new HomePage();
}
