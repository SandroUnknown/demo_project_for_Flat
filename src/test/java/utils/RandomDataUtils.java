package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.*;

public class RandomDataUtils {

    private final String[] genders  = {
            "Male", "Female", "Other"
    };
    private final List<String> subjects  = List.of(
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
            "Social Studies"
    );
    private final List<String> hobbies  = List.of(
            "Sports", "Reading", "Music"
    );
    private final String[] images   = {
            "angry.gif", "cool.jpg", "smile.png"
    };
    private final Map<String, String[]> stateCity = Map.of(
            "NCR",              new String[]{"Delhi", "Gurgaon", "Noida"},
            "Uttar Pradesh",    new String[]{"Agra", "Lucknow", "Merrut"},
            "Haryana",          new String[]{"Karnal", "Panipat"},
            "Rajasthan",        new String[]{"Jaipur", "Jaiselmer"}
    );

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

    public Date getRandomDateOfBirth() {  // ДОБАВИТЬ
        return faker.date().birthday();
    }

    public String getYearOfBirth(Date dateOfBirth) {
        return new SimpleDateFormat("yyyy").format(dateOfBirth);
    }

    public String getMonthOfBirth(Date dateOfBirth) {
        return new SimpleDateFormat("MMMM", Locale.ENGLISH).format(dateOfBirth);
    }

    public String getDayOfBirth(Date dateOfBirth) {
        return new SimpleDateFormat("dd").format(dateOfBirth);
    }

    public List<String> getRandomSubjects(int count) {
        return getRandomValuesFromList(count, subjects);
    }

    public List<String> getRandomHobbies(int count) {
        return getRandomValuesFromList(count, hobbies);
    }

    private List<String> getRandomValuesFromList(int count, List<String> list) {
        if (count >= list.size()) return list;
        List<String> newList = new ArrayList<>();
        List<String> listCopy = new ArrayList<>(list);
        for (int i = 0; i < count; i++) {
            int rnd = faker.number().numberBetween(0, listCopy.size());
            newList.add(listCopy.get(rnd));
            listCopy.remove(rnd);
        }
        return newList;
    }

    public String getRandomImage() {
        return faker.options().option(images);
    }

    public String getRandomAddress() {
        return faker.address().fullAddress();
    }

    public String getRandomState() {
        return faker.options().option(stateCity.keySet().toArray(new String[0]));
    }

    public String getRandomCity(String state) {
        return faker.options().option(stateCity.get(state));
    }
}