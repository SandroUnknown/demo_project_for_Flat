package page.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class Header {

    private final String
            phoneNumber = "+7(499) 551-77-78",
            email       = "info@flat-soft.ru";

    private final SelenideElement
            phoneNumberSelector = $("#sp-top-bar li.sp-contact-mobile"),
            emailSelector       = $("#sp-top-bar li.sp-contact-email");

    @Step("Проверить номер телефона.")
    public Header checkPhoneNumber() {
        $(phoneNumberSelector).shouldHave(text(phoneNumber));
        return this;
    }

    @Step("Проверить email.")
    public Header checkEmail() {
        $(emailSelector).shouldHave(text(email));
        return this;
    }
}