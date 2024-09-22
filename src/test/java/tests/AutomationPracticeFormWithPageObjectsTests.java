package tests;

import org.junit.jupiter.api.Test;
import page.RegistrationPage;
import utils.RandomDataUtils;

import java.util.Date;

import static com.codeborne.selenide.Selenide.sleep;

public class AutomationPracticeFormWithPageObjectsTests extends TestBase {

    private final RegistrationPage registrationPage = new RegistrationPage();
    private final RandomDataUtils randomDataUtils = new RandomDataUtils();

    @Test
    void successfulRegistrationWithFullDataTest() {
        String[] subjects2 = new String[] {"Maths", "Computer Science"};
        String[] hobbies = new String[] {"Reading", "Music"};
        String  firstName2 = "Anna",
                lastName2 = "Karenina",
                userEmail2 = "anna@karenina.com",
                gender2 = "Female",
                phoneNumber2 = "9031112233",
                dayOfBirth2 = "30", monthOfBirth2 = "July", yearOfBirth2 = "1991",
                picName2 = "ava.png",
                currentAddress2 = "Moscow, Russia",
                state = "Haryana", city = "Panipat";

        String firstName        = randomDataUtils.getRandomFirstName();
        String lastName         = randomDataUtils.getRandomLastName();
        String userEmail        = randomDataUtils.getRandomUserEmail(firstName, lastName);
        String gender           = randomDataUtils.getRandomGender();
        String phoneNumber      = randomDataUtils.getRandomPhoneNumber(10);
        String yearOfBirth      = randomDataUtils.getRandomYearOfBirth(1970, 2010);
        String monthOfBirth     = randomDataUtils.getRandomMonthOfBirth();
        String dayOfBirth       = randomDataUtils.getRandomDayOfBirth(monthOfBirth);
        String[] subjects       = randomDataUtils.getRandomSubjects(2);
        String picName          = "ava.png";
        String currentAddress   = randomDataUtils.getRandomCurrentAddress();




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
                .checkResult("Subjects", subjects[0] + ", " + subjects[1])
                .checkResult("Hobbies", hobbies[0] + ", " + hobbies[1])
                .checkResult("Picture", picName)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);

        sleep(4000);
    }

    @Test
    void successfulRegistrationWithOnlyRequiredFieldsTest() {
        String firstName = "Anna";
        String lastName = "Karenina";
        String gender = "Female";
        String phoneNumber = "9031112233";

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