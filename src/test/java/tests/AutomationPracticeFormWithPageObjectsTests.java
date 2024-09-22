package tests;

import org.junit.jupiter.api.Test;
import page.RegistrationPage;

public class AutomationPracticeFormWithPageObjectsTests extends TestBase {

    private final RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationWithFullDataTest() {
        String[] subjects = new String[] {"Maths", "Computer Science"};
        String[] hobbies = new String[] {"Reading", "Music"};
        String  firstName = "Anna",
                lastName = "Karenina",
                userEmail = "anna@karenina.com",
                gender = "Female",
                phoneNumber = "9031112233",
                dayOfBirth = "30", monthOfBirth = "July", yearOfBirth = "1991",
                picName = "ava.png",
                currentAddress = "Moscow, Russia",
                state = "Haryana", city = "Panipat";

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