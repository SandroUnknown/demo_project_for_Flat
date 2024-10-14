package page;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
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

    @Step("Открываем форму.")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    @Step("Убираем баннеры со страницы.")
    public RegistrationPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Вводим имя.")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.scrollTo().setValue(value);
        return this;
    }

    @Step("Вводим фамилию.")
    public RegistrationPage setLastName(String value) {
        lastNameInput.scrollTo().setValue(value);
        return this;
    }

    @Step("Вводим email.")
    public RegistrationPage setUserEmail(String value) {
        userEmailInput.scrollTo().setValue(value);
        return this;
    }

    @Step("Выбираем пол.")
    public RegistrationPage setGender(String value) {
        genderInput.scrollTo().$(byText(value)).click();
        return this;
    }

    @Step("Вводим номер телефона.")
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.scrollTo().setValue(value);
        return this;
    }

    @Step("Выбираем дату рождения.")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirth.scrollTo().click();
        new CalendarComponent().setDate(day, month, year);
        return this;
    }

    @Step("Выбираем предметы.")
    public RegistrationPage setSubjects(List<String> values) {
        subjectsInput.scrollTo();
        for (String value : values) {
            subjectsInput.setValue(value).pressEnter();
        }
        return this;
    }

    @Step("Выбираем увлечения.")
    public RegistrationPage setHobbies(List<String> values) {
        hobbiesInput.scrollTo();
        for (String value : values) {
            hobbiesInput.$(byText(value)).click();
        }
        return this;
    }

    @Step("Загружаем картинку.")
    public RegistrationPage setPicture(String value) {
        if (Configuration.browser.equals("firefox")) return this;
        pictureInput.scrollTo().uploadFromClasspath(value);
        return this;
    }

    @Step("Выбираем адрес.")
    public RegistrationPage setCurrentAddress(String value) {
        addressCurrentInput.scrollTo().setValue(value);
        return this;
    }

    @Step("Выбираем штат.")
    public RegistrationPage setState(String value) {
        stateInput.scrollTo().click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Выбираем город.")
    public RegistrationPage setCity(String value) {
        cityInput.scrollTo().click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Нажимаем на кнопку 'submit'.")
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

    public void negativeCheck() {
        new TableResponsive().negativeCheck();
    }
}