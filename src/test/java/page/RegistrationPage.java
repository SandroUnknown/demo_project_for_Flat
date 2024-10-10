package page;

import com.codeborne.selenide.SelenideElement;
import page.components.CalendarComponent;
import page.components.TableResponsive;

import java.util.List;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
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
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirth.click();
        new CalendarComponent().setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(List<String> values) {
        for (String value : values) {
            subjectsInput.setValue(value).pressEnter();
        }
        return this;
    }

    public RegistrationPage setHobbies(List<String> values) {
        for (String value : values) {
            hobbiesInput.$(byText(value)).click();
        }
        return this;
    }

    public RegistrationPage setPicture(String value) {
        pictureInput.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        addressCurrentInput.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        stateInput.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value) {
        cityInput.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    public void clickSubmit() {
        submitInput.click();
    }

    public RegistrationPage checkResult(String key, String value) {
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