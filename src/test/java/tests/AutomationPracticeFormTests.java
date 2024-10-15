package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import page.RegistrationPage;
import utils.Gender;
import utils.RandomDataUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;

@Feature("Проверка PracticeFormTest на demoqa.com")
@DisplayName("Проверка PracticeFormTest")
@Link(value = "Test page", url = "https://demoqa.com/automation-practice-form")
@Owner("Petyukov Alexander")
public class AutomationPracticeFormTests extends TestBase {

    private final RegistrationPage registrationPage = new RegistrationPage();
    private final RandomDataUtils randomData = new RandomDataUtils();

    static Stream<Arguments> successfulRegistrationWithMethodSourceAnnotation() {
        return Stream.of(
            Arguments.of(
                Gender.MALE,
                List.of("Arts", "Hindi", "Physics")
            ),
            Arguments.of(
                Gender.FEMALE,
                List.of("English")
            )
            ,
            Arguments.of(
                Gender.OTHER,
                List.of("Commerce", "Civics")
            )
        );
    }

    @Tag("End-to-end")
    @Story("Проверка с полным заполнением формы (с использованием аннотации @MethodSource)")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Регистрация с параметрами 'gender' и 'subjects':")
    @ParameterizedTest(name = "{0} и {1}")
    @MethodSource
    void successfulRegistrationWithMethodSourceAnnotation(Gender gender, List<String> subjects) {
        String firstName        = randomData.getRandomFirstName();
        String lastName         = randomData.getRandomLastName();
        String userEmail        = randomData.getRandomUserEmail();
        String phoneNumber      = randomData.getRandomPhoneNumber(10);
        Date dateOfBirth        = randomData.getRandomDateOfBirth();
        String yearOfBirth      = randomData.getYearOfBirth(dateOfBirth);
        String monthOfBirth     = randomData.getMonthOfBirth(dateOfBirth);
        String dayOfBirth       = randomData.getDayOfBirth(dateOfBirth);
        List<String> hobbies    = randomData.getRandomHobbies(2);
        String picName          = randomData.getRandomImage();
        String currentAddress   = randomData.getRandomAddress();
        String state            = randomData.getRandomState();
        String city             = randomData.getRandomCity(state);

        step("Open form", () -> {
            registrationPage.openPage().removeBanners();
        });
        step("Fill form", ()-> {
            registrationPage
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setUserEmail(userEmail)
                    .setGender(gender.getTitle())
                    .setUserNumber(phoneNumber)
                    .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                    .setSubjects(subjects)
                    .setHobbies(hobbies)
                    .setPicture("pictures/" + picName)
                    .setCurrentAddress(currentAddress)
                    .setState(state)
                    .setCity(city)
                    .clickSubmit();
        });
        step("Check results", () -> {
            registrationPage
                    .checkResult("Student Name", firstName + " " + lastName)
                    .checkResult("Student Email", userEmail)
                    .checkResult("Gender", gender.getTitle())
                    .checkResult("Mobile", phoneNumber)
                    .checkResult("Date of Birth",dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                    .checkResult("Subjects", subjects)
                    .checkResult("Hobbies", hobbies)
                    .checkResult("Picture", picName)
                    .checkResult("Address", currentAddress)
                    .checkResult("State and City", state + " " + city);
        });
    }

    @Tag("Smoke")
    @Story("Проверка формы с заполнением только обязательных полей")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Проверка формы с заполнением только обязательных полей")
    @Test
    void successfulRegistrationWithOnlyRequiredFieldsTest() {
        String firstName        = randomData.getRandomFirstName();
        String lastName         = randomData.getRandomLastName();
        String gender           = randomData.getRandomGender();
        String phoneNumber      = randomData.getRandomPhoneNumber(10);

        step("Open form", () -> {
            registrationPage.openPage().removeBanners();
        });
        step("Fill form", ()-> {
            registrationPage
                    .openPage()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setGender(gender)
                    .setUserNumber(phoneNumber)
                    .clickSubmit();
        });
        step("Check results", () -> {
            registrationPage
                    .checkResult("Student Name", firstName + " " + lastName)
                    .checkResult("Gender", gender)
                    .checkResult("Mobile", phoneNumber);
        });
    }

    @Tag("Negative")
    @Story("'Негативная' проверка формы (без заполнения полей)")
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("'Негативная' проверка формы (без заполнения полей)")
    @Test
    void negativeRegistrationTest() {
        step("Open form", () -> {
            registrationPage.openPage().removeBanners();
        });
        step("Click submit", () -> {
            registrationPage.clickSubmit();
        });
        step("Check results", () -> {
            registrationPage.negativeCheck();
        });
    }
}