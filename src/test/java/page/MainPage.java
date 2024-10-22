package page;

import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.DisplayName;
import page.components.TopBar;
import page.components.TopMenu;

import java.io.IOException;
import java.util.Map;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class MainPage {

    private final ElementsCollection
            contentSelector = $("div.page-content").findAll("section");

    // TODO
    // Убрать данные в файл а-ля MainPage.json?

    private final String
            slogan = "Надежность и устойчивая функциональность коммуникационной инфраструктуры и интегрированных сервисов вашего бизнеса";

    private final Map<String, String> services = Map.of(
            "ФЛАТ SoftSwitch",          "https://flat-soft.ru/produkty/flat-softswitch",
            "ФЛАТ Device Manager",      "https://flat-soft.ru/produkty/flat-device-manager",
            "Партнёрство и развитие",   "https://flat-soft.ru/images/files/pdf/partnerskaya_i_marketingovaya_programma_flat_2024.pdf"
    );

    // ==========================================

    @DisplayName("Открыть страницу [TEST].")
    public MainPage openPage(String url) {
        open(url);
        return this;
    }

    @DisplayName("Удалить баннеры [TEST].")
    public MainPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @DisplayName("Проверить top-bar [TEST].")
    public MainPage checkTopBar() {
        new TopBar()
                .checkPhoneNumber()
                .checkEmail();
        return this;
    }

    @DisplayName("роверить top-menu [TEST].")
    public MainPage checkTopMenu() throws IOException {
        new TopMenu().checkMenuItems();
        return this;
    }

    @DisplayName("Проверить слоган [TEST].")
    public MainPage checkSlogan() {
        contentSelector.findBy(text(slogan)).should(exist);
        return this;
    }

    @DisplayName("Проверить услуги [TEST].")
    public MainPage checkServices() {
        for (String service : services.keySet()) {
            contentSelector.findBy(text(service)).$("a").shouldHave(href(services.get(service)));
        }
        return this;
    }
}