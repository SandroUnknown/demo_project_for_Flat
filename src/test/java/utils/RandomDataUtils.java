package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class RandomDataUtils {
    private final String[] genders  = {"Male", "Female", "Other"};
    private final String[] hobbies  = {"Sports", "Reading", "Music"};
    private final String[] images   = {"angry.gif", "cool.jpg", "smile.png"};
    private final String[] subjects = {
            "Accounting",
            "Arts",
            "Biology",
            "Chemistry",
            "Civics",
            "Commerce",
            "Computer Science",
            "Economics",
            "English",
            "Hindi",
            "History",
            "Maths",
            "Physics",
            "Social Studies"};
    private final String[] states = {
            "NCR",
            "Uttar Pradesh",
            "Haryana",
            "Rajasthan"};
    private final String[][] cities = {
            {"Delhi", "Gurgaon", "Noida"},  //NCR
            {"Agra", "Lucknow", "Merrut"},  //Uttar Pradesh
            {"Karnal", "Panipat"},          //Haryana
            {"Jaipur", "Jaiselmer"}};       //Rajasthan

    private final Faker faker = new Faker(new Locale("en"));

    public String getRandomFirstName() {
        return faker.name().firstName();
    }

    public String getRandomLastName() {
        return faker.name().lastName();
    }

    public String getRandomUserEmail() {
        return faker.internet().emailAddress();
    }

    public String getRandomGender() {
        return faker.options().option(genders);
    }

    public String getRandomPhoneNumber(int count) {
        return faker.number().digits(count);
    }

    private final Date dateOfBirth = faker.date().birthday();

    public String getRandomYearOfBirth() {
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        return yearFormat.format(dateOfBirth);
    }

    public String getRandomMonthOfBirth() {
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM", Locale.ENGLISH);
        return monthFormat.format(dateOfBirth);
    }

    public String getRandomDayOfBirth() {
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        return dayFormat.format(dateOfBirth);
    }

    public String[] getRandomSubjects(int count) {
        return getRandomValuesFromArray(count, subjects);
    }

    public String[] getRandomHobbies(int count) {
        return getRandomValuesFromArray(count, hobbies);
    }

    private String[] getRandomValuesFromArray(int count, String[] array) {
        if (count >= array.length) return array;
        String[] newArray = new String[count];
        for (int i = 0; i < count; i++) {
            newArray[i] = faker.options().option(array);
            array = removeElement(newArray[i], array);
        }
        return newArray;
    }

    private String[] removeElement(String element, String[] array) {
        String[] newArray = new String[array.length - 1];
        int j = 0;
        for (String s : array) {
            if (element.equals(s)) continue;
            newArray[j++] = s;
        }
        return newArray;
    }

    public String getRandomImage() {
        return faker.options().option(images);
    }

    public String getRandomAddress() {
        return faker.address().fullAddress();
    }

    public String getRandomState() {
        return faker.options().option(states);
    }

    public String getRandomCity(String state) {
        int stateIndex = 0;
        for (int i = 0; i < states.length; i++) {
            if (states[i].equals(state)) {
                stateIndex = i;
                break;
            }
        }
        return faker.options().option(cities[stateIndex]);
    }
}
