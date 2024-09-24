package tests;

import org.junit.jupiter.api.Test;
import page.RegistrationPage;
import utils.RandomDataUtils;

public class AutomationPracticeFormWithPageObjectsTests extends TestBase {

    private final RegistrationPage registrationPage = new RegistrationPage();
    private final RandomDataUtils randomData = new RandomDataUtils();

    @Test
    void successfulRegistrationWithFullDataTest() {
        String firstName        = randomData.getRandomFirstName();
        String lastName         = randomData.getRandomLastName();
        String userEmail        = randomData.getRandomUserEmail();
        String gender           = randomData.getRandomGender();
        String phoneNumber      = randomData.getRandomPhoneNumber(10);
        String yearOfBirth      = randomData.getRandomYearOfBirth();
        String monthOfBirth     = randomData.getRandomMonthOfBirth();
        String dayOfBirth       = randomData.getRandomDayOfBirth();
        String[] subjects       = randomData.getRandomSubjects(5);
        String[] hobbies        = randomData.getRandomHobbies(2);
        String picName          = randomData.getRandomImage();
        String currentAddress   = randomData.getRandomAddress();
        String state            = randomData.getRandomState();
        String city             = randomData.getRandomCity(state);

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setPicture(picName)
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

    @Test
    void successfulRegistrationWithOnlyRequiredFieldsTest() {
        String firstName        = randomData.getRandomFirstName();
        String lastName         = randomData.getRandomLastName();
        String gender           = randomData.getRandomGender();
        String phoneNumber      = randomData.getRandomPhoneNumber(10);

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .clickSubmit();

        registrationPage
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber);
    }

    @Test
    void negativeRegistrationTest() {
        registrationPage.openPage().clickSubmit();
        registrationPage.negativeCheck();
    }
}