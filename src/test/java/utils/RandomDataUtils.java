package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.*;

public class RandomDataUtils {
    private final String[] genders  = {
            "Male", "Female", "Other"
    };
    private final List<String> subjects  = new ArrayList<>(); {
            subjects.add("Accounting");
            subjects.add("Arts");
            subjects.add("Biology");
            subjects.add("Chemistry");
            subjects.add("Civics");
            subjects.add("Commerce");
            subjects.add("Computer Science");
            subjects.add("Economics");
            subjects.add("English");
            subjects.add("Hindi");
            subjects.add("History");
            subjects.add("Maths");
            subjects.add("Physics");
            subjects.add("Social Studies");
    };
    private final List<String> hobbies  = new ArrayList<>(); {
            hobbies.add("Sports");
            hobbies.add("Reading");
            hobbies.add("Music");
    }
    private final String[] images   = {
            "angry.gif", "cool.jpg", "smile.png"
    };
    private final Map<String, String[]> stateCity = new HashMap<>(); {
            stateCity.put("NCR",            new String[] {"Delhi", "Gurgaon", "Noida"});
            stateCity.put("Uttar Pradesh",  new String[]{"Agra", "Lucknow", "Merrut"});
            stateCity.put("Haryana",        new String[]{"Karnal", "Panipat"});
            stateCity.put("Rajasthan",      new String[]{"Jaipur", "Jaiselmer"});
    }

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
        return getRandomValuesFromList(count, subjects).toArray(new String[0]);
    }

    public String[] getRandomHobbies(int count) {
        return getRandomValuesFromList(count, hobbies).toArray(new String[0]);
    }

    private List<String> getRandomValuesFromList(int count, List<String> list) {
        if (count >= list.size()) return list;;
        List<String> newList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int rnd = faker.number().numberBetween(0, list.size());
            newList.add(list.get(rnd));
            list.remove(rnd);
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
