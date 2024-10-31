package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import models.Partners;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import page.components.Footer;
import page.components.TopBar;
import page.components.TopMenu;

import java.io.IOException;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.fail;

public class PartnerPage {

    private final SelenideElement
            cityListSelector      = $(".jlmf-list-2"),
            filterButtonSelector  = $(".jlmf-button"),
            partnerSearchSelector = $("input#naimenovanie-kompanii-164");

    private final ElementsCollection
            partnerCardsSelector = $$("div.col-lg-6");

    @DisplayName("Открыть страницу.")
    public PartnerPage openPage(String url) {
        open(url);
        return this;
    }

    @DisplayName("Проверить top-bar.")
    public PartnerPage checkTopBar() {
        new TopBar()
                .checkPhoneNumber()
                .checkEmail();
        return this;
    }

    @DisplayName("Проверить top-menu.")
    public PartnerPage checkTopMenu() throws IOException {
        new TopMenu().checkMenuItems();
        return this;
    }

    @DisplayName("Проверить контакты в footer.")
    public PartnerPage checkFooterMenu() {
        new Footer().checkMenu();
        return this;
    }

    @DisplayName("Проверить контакты в footer.")
    public PartnerPage checkFooterContacts() {
        new Footer()
                .checkPhoneNumber()
                .checkEmail()
                .checkOperationMode()
                .checkAdress();
        return this;
    }

    @DisplayName("Проверить авторские права в footer.")
    public PartnerPage checkFooterCopyright() {
        new Footer()
                .checkCopyrightText()
                .checkCopyrightYear();
        return this;
    }

    @DisplayName("Проверить партнеров.")
    public PartnerPage checkPartners(String cityName, List<Partners.Partner> partners) {
        step("Выбрать город " + cityName + ".", () -> {
            cityListSelector.$(byText(cityName)).click();
        });
        step("Нажать 'Применить фильтр'.", () -> {
            filterButtonSelector.click();
        });
        step("Проверить партнеров.", () -> {
            for (models.Partners.Partner partner : partners) {
                partnerCardsSelector
                         .findBy(text(partner.getName())).scrollIntoView(true)
                         .shouldHave(text(partner.getPhone()))
                         .shouldHave(text(partner.getLevel()))
                         .$("a").shouldHave(href(partner.getURL()));
            }
        });
        return this;
    }

    @DisplayName("Найти партнера (через поиск) и проверить его.")
    public PartnerPage searchPartner(String name, String url, String phone, String level) {
        step("Ввести в поле поиска '" + name + "' и нажать [enter].", () -> {
            partnerSearchSelector.setValue(name).pressEnter();
        });
        step("Проверить результат поиска.", () -> {
            partnerCardsSelector
                .findBy(text(name))
                .shouldHave(text(phone))
                .shouldHave(text(level))
                .$("a").shouldHave(href(url));
        });
        return this;
    }
}