package page.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.LocalDate;
import java.util.Map;

import static com.codeborne.selenide.Condition.href;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class Footer {

    private final String
            phoneNumber     = "+7(499) 551-77-78",
            email           = "info@flat-soft.ru",
            operationMode   = "График работы Пн-Пт: 9:00-18:00 ",
            adress          = "Москва, ул. 8 Марта, д. 1, стр. 12, Бизнес Центр «Трио», 1 подъезд, 9 этаж",
            copyrightText   = "На сайте использованы иллюстрации и фотоматериалы ресурсов freepik и Unsplash, авторов: " +
                              "freepik, stockgiu, Glenn Carstens-Peters, Emile Perron, Luca Bravo, AltumCode. " +
                              "Если вы не нашли себя среди авторов, но Ваши материалы использованы на данном сайте, просим связаться с нами - news@flat-soft.ru";

    private final Map<String, String> menu = Map.of(
            "О компании",               "/o-kompanii",
            "Карьера",                  "/karera",
            "Новости и мероприятия",    "/novosti-i-meropriyatiya",
            "Контакты",                 "/kontaktj"
    );

    private final ElementsCollection
            menuSelector = $("#navbar113 ul").findAll("li");

    private final SelenideElement
            contactDetailsSelector  = $("#mod-custom115"),
            copyrightTextSelector   = $("#sp-footer #mod-custom197"),
            copyrightYearSelector   = $("#sp-footer .sp-copyright");

    @Step("Проверить меню.")
    public Footer checkMenu() {
        for (String item : menu.keySet()) {
            menuSelector.findBy(text(item)).$("a").shouldHave(href(menu.get(item)));
        }
        return this;
    }

    @Step("Проверить номер телефона.")
    public Footer checkPhoneNumber() {
        $(contactDetailsSelector).shouldHave(text(phoneNumber));
        return this;
    }

    @Step("Проверить email.")
    public Footer checkEmail() {
        $(contactDetailsSelector).shouldHave(text(email));
        return this;
    }

    @Step("Проверить график работы.")
    public Footer checkOperationMode() {
        $(contactDetailsSelector).shouldHave(text(operationMode));
        return this;
    }

    @Step("Проверить адрес.")
    public Footer checkAdress() {
        $(contactDetailsSelector).shouldHave(text(adress));
        return this;
    }

    @Step("Проверить текст авторских прав.")
    public Footer checkCopyrightText() {
        $(copyrightTextSelector).shouldHave(text(copyrightText));
        return this;
    }

    @Step("Проверить проверить значок копирайта и текущий год.")
    public Footer checkCopyrightYear() {
        String year = String.valueOf(LocalDate.now().getYear());
        $(copyrightYearSelector).shouldHave(text("© " + year));
        return this;
    }
}