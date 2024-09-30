package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import page.RegistrationPage;
import utils.Gender;
import utils.RandomDataUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class AutomationPracticeFormTests extends TestBase {

    private final RegistrationPage registrationPage = new RegistrationPage();
    private final RandomDataUtils randomData = new RandomDataUtils();

    @ValueSource (strings = {"test@qa.guru", "test.test@gu.ru", "test123.qa@guru.qa"})
    @ParameterizedTest(name = "Успешная регистрация с параметром: email = {0}")
    void successfulRegistrationWithValueSourceAnnotation(String userEmail) {
        String firstName        = randomData.getRandomFirstName();
        String lastName         = randomData.getRandomLastName();
        String gender           = randomData.getRandomGender();
        String phoneNumber      = randomData.getRandomPhoneNumber(10);
        Date dateOfBirth        = randomData.getRandomDateOfBirth();
        String yearOfBirth      = randomData.getYearOfBirth(dateOfBirth);
        String monthOfBirth     = randomData.getMonthOfBirth(dateOfBirth);
        String dayOfBirth       = randomData.getDayOfBirth(dateOfBirth);
        List<String> subjects   = randomData.getRandomSubjects(5);
        List<String> hobbies    = randomData.getRandomHobbies(2);
        String picName          = randomData.getRandomImage();
        String currentAddress   = randomData.getRandomAddress();
        String state            = randomData.getRandomState();
        String city             = randomData.getRandomCity(state);

        registrationPage.openPage().removeBanners()
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
    }

    @CsvFileSource(resources = "/data/testData.csv")
    @ParameterizedTest(name = "Успешная регистрация с параметрами: firstName = {0} и lastName = {1}")
    void successfulRegistrationWithCsvFileSourceAnnotation(String firstName, String lastName) {
        String userEmail        = randomData.getRandomUserEmail();
        String gender           = randomData.getRandomGender();
        String phoneNumber      = randomData.getRandomPhoneNumber(10);
        Date dateOfBirth        = randomData.getRandomDateOfBirth();
        String yearOfBirth      = randomData.getYearOfBirth(dateOfBirth);
        String monthOfBirth     = randomData.getMonthOfBirth(dateOfBirth);
        String dayOfBirth       = randomData.getDayOfBirth(dateOfBirth);
        List<String> subjects   = randomData.getRandomSubjects(5);
        List<String> hobbies    = randomData.getRandomHobbies(2);
        String picName          = randomData.getRandomImage();
        String currentAddress   = randomData.getRandomAddress();
        String state            = randomData.getRandomState();
        String city             = randomData.getRandomCity(state);

        registrationPage.openPage().removeBanners()
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
    }

    @EnumSource(Gender.class)
    @ParameterizedTest(name = "Успешная регистрация с параметром: gender = {0}")
    void successfulRegistrationWithEnumSourceAnnotation(Gender gender) {
        String firstName        = randomData.getRandomFirstName();
        String lastName         = randomData.getRandomLastName();
        String userEmail        = randomData.getRandomUserEmail();
        String phoneNumber      = randomData.getRandomPhoneNumber(10);
        Date dateOfBirth        = randomData.getRandomDateOfBirth();
        String yearOfBirth      = randomData.getYearOfBirth(dateOfBirth);
        String monthOfBirth     = randomData.getMonthOfBirth(dateOfBirth);
        String dayOfBirth       = randomData.getDayOfBirth(dateOfBirth);
        List<String> subjects   = randomData.getRandomSubjects(5);
        List<String> hobbies    = randomData.getRandomHobbies(2);
        String picName          = randomData.getRandomImage();
        String currentAddress   = randomData.getRandomAddress();
        String state            = randomData.getRandomState();
        String city             = randomData.getRandomCity(state);

        registrationPage.openPage().removeBanners()
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
    }

    static Stream<Arguments> successfulRegistrationWithMethodSourceAnnotation() {
        return Stream.of(
            Arguments.of(
                Gender.MALE,
                List.of("Arts", "Computer Science", "Hindi", "Physics")
            ),
            Arguments.of(
                Gender.FEMALE,
                List.of("English")
            ),
            Arguments.of(
                Gender.OTHER,
                List.of("Social Studies", "Civics")
            )
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Успешная регистрация с параметрами: gender = {0} и subjects = {1}")
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

        registrationPage.openPage().removeBanners()
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
    }
}