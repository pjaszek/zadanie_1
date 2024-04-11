package StepDefinition;

import com.codeborne.selenide.ElementsCollection;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import page.TMobileProcess;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.BrowserDriver.configureBrowser;
import static util.Loader.waitForLoaderDisappear;

@Slf4j
public class StepDefinitions {

    private final TMobileProcess tMobileProcess = new TMobileProcess();

    @Given("Otwórz odpowiednią przeglądarkę")
    public void otwórz_odpowiednią_przeglądarkę() {
        configureBrowser();
    }

    @When("Klient przechodzi na stronę {string}")
    public void klient_przechodzi_na_stronę(String url) {
        open(url);
    }

    @Then("Strona główna jest wyświetlona")
    public void strona_główna_jest_wyświetlona() {
        assertEquals("https://www.t-mobile.pl/", tMobileProcess.getHomePage().getUrl());
        tMobileProcess.getHomePage().confirmCookies();
        waitForLoaderDisappear();
    }

    @Then("Klient wybiera {string} z górnego menu")
    public void klient_wybiera_z_górnego_menu(String buttonName) {
        tMobileProcess.getNavigationBar().goToTab("Urządzenia");
        assertEquals("Urządzenia", buttonName);

    }

    @Then("Pojawia się rozwijana lista")
    public void pojawia_się_rozwijana_lista() {
        tMobileProcess.getNavigationBar().isDropdownListIsVisible();
    }

    @Then("Klient wybiera {string} z kolumny {string}")
    public void klient_wybiera_bez_abonamentu_z_kolumny_smartwatche_i_opaski(String button, String column) {
        assertEquals("Smartwatche i opaski", column);
        assertEquals("Bez abonamentu", button);
        tMobileProcess.getNavigationBar().clickDropdownButton(column, button).click();
    }

    @Then("Widoczna lista smartfonów")
    public void widoczna_lista_smartfonów() {

    }

    @Then("Klient klika w pierwszy element z listy")
    public void klient_klika_w_pierwszy_element_z_listy() {

    }

    @Then("Widoczna strona produktu")
    public void widoczna_strona_produktu() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Klient dodaje produkt do koszyka")
    public void klient_dodaje_produkt_do_koszyka() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Widoczna strona Twój koszyk. Kwoty {string} oraz {string} zgadzają się z kwotami z poprzedniej strony.")
    public void widoczna_strona_twój_koszyk_kwoty_oraz_zgadzają_się_z_kwotami_z_poprzedniej_strony(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Klient przechodzi na stronę główną T-Mobile")
    public void klient_przechodzi_na_stronę_główną_t_mobile() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Widoczna strona główna. W prawym górnym rogu widoczna jest ikonka koszyka z liczbą produktów w koszyku")
    public void widoczna_strona_główna_w_prawym_górnym_rogu_widoczna_jest_ikonka_koszyka_z_liczbą_produktów_w_koszyku() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
