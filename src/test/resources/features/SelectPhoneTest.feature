Feature: Zadanie 1

  Scenario: Wybranie smartwatcha z listy ofert
    Given Otwórz odpowiednią przeglądarkę
    When Klient przechodzi na stronę "https://www.t-mobile.pl/"
    Then Strona główna jest wyświetlona
    And Klient wybiera "Urządzenia" z górnego menu
    And Pojawia się rozwijana lista
    And Klient wybiera "Bez abonamentu" z kolumny "Smartwatche i opaski"
    And Widoczna lista smartfonów
    And Klient klika w pierwszy element z listy
    And Widoczna strona produktu
    And Klient dodaje produkt do koszyka
    And Widoczna strona Twój koszyk. Kwoty "Cena na start" oraz "Rata miesięczna" zgadzają się z kwotami z poprzedniej strony.
    And Klient przechodzi na stronę główną T-Mobile
    And Widoczna strona główna. W prawym górnym rogu widoczna jest ikonka koszyka z liczbą produktów w koszyku

