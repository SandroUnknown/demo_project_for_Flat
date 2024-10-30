package page;

import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.DisplayName;
import page.components.Footer;
import page.components.TopBar;
import page.components.TopMenu;

import java.io.IOException;
import java.util.Map;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final String
            slogan = "Надежность и устойчивая функциональность коммуникационной инфраструктуры и интегрированных сервисов вашего бизнеса";

    private final Map<String, String> services = Map.of(
            "ФЛАТ SoftSwitch",          "https://flat-soft.ru/produkty/flat-softswitch",
            "ФЛАТ Device Manager",      "https://flat-soft.ru/produkty/flat-device-manager",
            "Партнёрство и развитие",   "https://flat-soft.ru/images/files/pdf/partnerskaya_i_marketingovaya_programma_flat_2024.pdf"
    );

    private final ElementsCollection
            contentSelector = $("div.page-content").findAll("section");

    @DisplayName("Открыть страницу.")
    public MainPage openPage(String url) {
        open(url);
        return this;
    }

    @DisplayName("Проверить top-bar.")
    public MainPage checkTopBar() {
        new TopBar()
                .checkPhoneNumber()
                .checkEmail();
        return this;
    }

    @DisplayName("Проверить top-menu.")
    public MainPage checkTopMenu() throws IOException {
        new TopMenu().checkMenuItems();
        return this;
    }

    @DisplayName("Проверить контакты в footer.")
    public MainPage checkFooterMenu() {
        new Footer().checkMenu();
        return this;
    }

    @DisplayName("Проверить контакты в footer.")
    public MainPage checkFooterContacts() {
        new Footer()
                .checkPhoneNumber()
                .checkEmail()
                .checkOperationMode()
                .checkAdress();
        return this;
    }

    @DisplayName("Проверить авторские права в footer.")
    public MainPage checkFooterCopyright() {
        new Footer()
                .checkCopyrightText()
                .checkCopyrightYear();
        return this;
    }

    @DisplayName("Проверить слоган.")
    public MainPage checkSlogan() {
        contentSelector.findBy(text(slogan)).should(exist);
        return this;
    }

    @DisplayName("Проверить услуги.")
    public MainPage checkServices() {
        for (String service : services.keySet()) {
            contentSelector.findBy(text(service)).$("a").shouldHave(href(services.get(service)));
        }
        return this;
    }
}