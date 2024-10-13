package page;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import page.components.CalendarComponent;
import page.components.TableResponsive;

import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final SelenideElement
            firstNameInput      = $("#firstName"),
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

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.scrollTo().setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.scrollTo().setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.scrollTo().setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderInput.scrollTo().$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.scrollTo().setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirth.scrollTo().click();
        new CalendarComponent().setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(List<String> values) {
        subjectsInput.scrollTo();
        for (String value : values) {
            subjectsInput.setValue(value).pressEnter();
        }
        return this;
    }

    public RegistrationPage setHobbies(List<String> values) {
        hobbiesInput.scrollTo();
        for (String value : values) {
            hobbiesInput.$(byText(value)).click();
        }
        return this;
    }

    public RegistrationPage setPicture(String value) {
        if (Configuration.browser.equals("firefox")) return this;
        pictureInput.scrollTo().uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        addressCurrentInput.scrollTo().setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        stateInput.scrollTo().click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value) {
        cityInput.scrollTo().click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    public void clickSubmit() {
        submitInput.scrollTo().click();
    }

    public RegistrationPage checkResult(String key, String value) {
        if (Configuration.browser.equals("firefox") && key.equals("Picture")) return this;
        new TableResponsive().checkResult(key, value);
        return this;
    }

    public RegistrationPage checkResult(String key, List<String> values) {
        for (String value : values) {
            new TableResponsive().checkResult(key, value);
        }
        return this;
    }
}