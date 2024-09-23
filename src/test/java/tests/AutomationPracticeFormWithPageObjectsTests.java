package tests;

import org.junit.jupiter.api.Test;
import page.RegistrationPage;
import utils.RandomDataUtils;

import static page.components.TableResponsive.arrayToString;

public class AutomationPracticeFormWithPageObjectsTests extends TestBase {

    private final RegistrationPage registrationPage = new RegistrationPage();
    private final RandomDataUtils randomDataUtils = new RandomDataUtils();

    @Test
    void successfulRegistrationWithFullDataTest() {
        String firstName        = randomDataUtils.getRandomFirstName();
        String lastName         = randomDataUtils.getRandomLastName();
        String userEmail        = randomDataUtils.getRandomUserEmail(firstName, lastName);
        String gender           = randomDataUtils.getRandomGender();
        String phoneNumber      = randomDataUtils.getRandomPhoneNumber(10);
        String yearOfBirth      = randomDataUtils.getRandomYearOfBirth(1970, 2010);
        String monthOfBirth     = randomDataUtils.getRandomMonthOfBirth();
        String dayOfBirth       = randomDataUtils.getRandomDayOfBirth(monthOfBirth);
        String[] subjects       = randomDataUtils.getRandomSubjects(4);
        String[] hobbies        = randomDataUtils.getRandomHobbies(2);
        String picName          = randomDataUtils.getRandomImage();
        String currentAddress   = randomDataUtils.getRandomAddress();
        String state            = randomDataUtils.getRandomState();
        String city             = randomDataUtils.getRandomCity(state);

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
                .checkResult("Subjects", arrayToString(subjects))
                .checkResult("Hobbies", arrayToString(hobbies))
                .checkResult("Picture", picName)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    void successfulRegistrationWithOnlyRequiredFieldsTest() {
        String firstName        = randomDataUtils.getRandomFirstName();
        String lastName         = randomDataUtils.getRandomLastName();
        String gender           = randomDataUtils.getRandomGender();
        String phoneNumber      = randomDataUtils.getRandomPhoneNumber(10);

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