package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import page.components.TableResponsive;
import page.components.TopBar;
import page.components.TopMenu;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static io.qameta.allure.Allure.step;

public class MainPage {

    private final String
            slogan = "Надежность и устойчивая функциональность коммуникационной инфраструктуры и интегрированных сервисов вашего бизнеса";

    private final SelenideElement
            sloganSelector      = $("div.page-content"),
            lastNameInput       = $("#lastName"),
            userEmailInput      = $("#userEmail"),
            genderInput         = $("#genterWrapper"),
            userNumberInput     = $("#userNumber"),
            dateOfBirth         = $("#dateOfBirthInput"),
            subjectsInput       = $("#subjectsInput"),
            hobbiesInput        = $("#hobbiesWrapper"),
            pictureInput        = $("#uploadPicture"),
            addressCurrentInput = $("#currentAddress"),
            stateInput          = $("#state"),
            cityInput           = $("#city"),
            stateCityWrapper    = $("#stateCity-wrapper"),
            submitInput         = $("#submit");

    @Step("Открыть страницу.")
    public MainPage openPage() {
        open("/");
        return this;
    }

    @Step("Удалить баннеры.")
    public MainPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Проверить top-bar.")
    public MainPage checkTopBar() {
        new TopBar()
                .checkPhoneNumber()
                .checkEmail();
        return this;
    }

    @Step("Проверить top-menu.")
    public MainPage checkTopMenu() {
        new TopMenu()
                .checkMenuItems()
                .checkSubItems();
        return this;
    }

    @Step("Проверить тело страницы.")
    public MainPage checkBody() {
        step("Проверить слоган.", () -> {
            $("div.page-content").findAll("section").findBy(text(slogan)).should(exist);;
        });

        // TODO
        // что делать с мапой тут?
        step("Проверить наличие услуг (и соответствие им ссылок).", () -> {
            Map<String,String> services = Map.of(
                    "ФЛАТ SoftSwitch",          "https://flat-soft.ru/produkty/flat-softswitch",
                    "ФЛАТ Device Manager",      "https://flat-soft.ru/produkty/flat-device-manager",
                    "Партнёрство и развитие",   "https://flat-soft.ru/images/files/pdf/partnerskaya_i_marketingovaya_programma_flat_2024.pdf"
            );

            for (String service : services.keySet()) {
                $("div.page-content").findAll("section").findBy(text(service)).should(exist);
                $("div.page-content").findAll("section").findBy(text(service)).$("a").shouldHave(href(services.get(service)));;
            }
        });

        return this;
    }

}
