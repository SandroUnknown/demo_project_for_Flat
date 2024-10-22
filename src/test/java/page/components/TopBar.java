package page.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TopBar {

    private final SelenideElement
            phoneNumberSelector = $("#sp-top-bar li.sp-contact-mobile"),
            emailSelector       = $("#sp-top-bar li.sp-contact-email");

    //TODO
    // Вынести в файл эти данные?
    private final String
            phoneNumber = "+7(499) 551-77-78",
            email       = "info@flat-soft.ru";

    @Step("Проверить номер телефона.")
    public TopBar checkPhoneNumber() {
        $(phoneNumberSelector).shouldHave(text(phoneNumber));
        return this;
    }

    @Step("Проверить email.")
    public TopBar checkEmail() {
        $(emailSelector).shouldHave(text(email));
        return this;
    }
}