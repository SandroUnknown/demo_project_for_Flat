package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {

    private final SelenideElement
            fullNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            addressCurrentInput = $("#currentAddress"),
            addressPermanentInput = $("#permanentAddress"),
            submitInput = $("button#submit");

    public TextBoxPage openPage() {
        open("/text-box");
        return this;
    }

    public TextBoxPage setFullName(String value) {
        fullNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        addressCurrentInput.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        addressPermanentInput.setValue(value);
        return this;
    }

    public void clickSubmit() {
        submitInput.click();
    }

    public TextBoxPage checkResult(String key, String value) {
        $("div#output").shouldHave(text(key + value));
        return this;
    }
}