package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import page.RegistrationPage;
import utils.Gender;
import utils.RandomDataUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;

@Tag("demoqa")
@Feature("Проверка PracticeFormTest на demoqa.com")
@DisplayName("Проверка PracticeFormTest")
@Owner("Petyukov Alexander")
public class AutomationPracticeFormTests extends TestBase {

    private final RegistrationPage registrationPage = new RegistrationPage();
    private final RandomDataUtils randomData = new RandomDataUtils();

    @Tag("First")
    @Story("Проверка с использованием аннотации @ValueSource")
    @Link(value = "Test page", url = "https://demoqa.com/automation-practice-form")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Регистрация с параметром 'email':")
    @ParameterizedTest(name = "{0}")
    @ValueSource (strings = {"test@qa.guru", "test123.qa@guru.qa"})
    void successfulRegistrationWithValueSourceAnnotation(String userEmail) {
        String firstName        = randomData.getRandomFirstName();
        String lastName         = randomData.getRandomLastName();
        String gender           = randomData.getRandomGender();
        String phoneNumber      = randomData.getRandomPhoneNumber(10);
        Date dateOfBirth        = randomData.getRandomDateOfBirth();
        String yearOfBirth      = randomData.getYearOfBirth(dateOfBirth);
        String monthOfBirth     = randomData.getMonthOfBirth(dateOfBirth);
        String dayOfBirth       = randomData.getDayOfBirth(dateOfBirth);
        List<String> subjects   = randomData.getRandomSubjects(3);
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
                    .setGender(gender)
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
                    .checkResult("Gender", gender)
                    .checkResult("Mobile", phoneNumber)
                    .checkResult("Date of Birth",dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                    .checkResult("Subjects", subjects)
                    .checkResult("Hobbies", hobbies)
                    .checkResult("Picture", picName)
                    .checkResult("Address", currentAddress)
                    .checkResult("State and City", state + " " + city);
        });
    }

    @Tag("Second")
    @Story("Проверка с использованием аннотации @CsvFileSource")
    @Link(value = "Test page", url = "https://demoqa.com/automation-practice-form")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Регистрация с параметрами 'firstName' и 'lastName':")
    @ParameterizedTest(name = "{0} {1}")
    @CsvFileSource(resources = "/data/testData.csv")
    void successfulRegistrationWithCsvFileSourceAnnotation(String firstName, String lastName) {
        String userEmail        = randomData.getRandomUserEmail();
        String gender           = randomData.getRandomGender();
        String phoneNumber      = randomData.getRandomPhoneNumber(10);
        Date dateOfBirth        = randomData.getRandomDateOfBirth();
        String yearOfBirth      = randomData.getYearOfBirth(dateOfBirth);
        String monthOfBirth     = randomData.getMonthOfBirth(dateOfBirth);
        String dayOfBirth       = randomData.getDayOfBirth(dateOfBirth);
        List<String> subjects   = randomData.getRandomSubjects(3);
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
                    .setGender(gender)
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
                    .checkResult("Gender", gender)
                    .checkResult("Mobile", phoneNumber)
                    .checkResult("Date of Birth",dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                    .checkResult("Subjects", subjects)
                    .checkResult("Hobbies", hobbies)
                    .checkResult("Picture", picName)
                    .checkResult("Address", currentAddress)
                    .checkResult("State and City", state + " " + city);
        });
    }

    @Tag("Third")
    @Story("Проверка с использованием аннотации @EnumSource")
    @Link(value = "Test page", url = "https://demoqa.com/automation-practice-form")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Регистрация с параметром 'gender':")
    @ParameterizedTest(name = "{0}")
    @EnumSource(Gender.class)
    void successfulRegistrationWithEnumSourceAnnotation(Gender gender) {
        String firstName        = randomData.getRandomFirstName();
        String lastName         = randomData.getRandomLastName();
        String userEmail        = randomData.getRandomUserEmail();
        String phoneNumber      = randomData.getRandomPhoneNumber(10);
        Date dateOfBirth        = randomData.getRandomDateOfBirth();
        String yearOfBirth      = randomData.getYearOfBirth(dateOfBirth);
        String monthOfBirth     = randomData.getMonthOfBirth(dateOfBirth);
        String dayOfBirth       = randomData.getDayOfBirth(dateOfBirth);
        List<String> subjects   = randomData.getRandomSubjects(3);
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

    static Stream<Arguments> successfulRegistrationWithMethodSourceAnnotation() {
        return Stream.of(
            Arguments.of(
                Gender.MALE,
                List.of("Arts", "Hindi", "Physics")
            ),
            Arguments.of(
                Gender.FEMALE,
                List.of("English", "Civics")
            )
        );
    }

    @Tag("Fourth")
    @Story("Проверка с использованием аннотации @MethodSource")
    @Link(value = "Test page", url = "https://demoqa.com/automation-practice-form")
    @Severity(SeverityLevel.MINOR)
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
}