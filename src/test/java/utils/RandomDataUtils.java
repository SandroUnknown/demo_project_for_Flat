package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDataUtils {

    private final Faker faker = new Faker(new Locale("en"));

    public String getRandomFirstName() {
        return faker.name().firstName();
    }

    public String getRandomLastName() {
        return faker.name().lastName();
    }

    public String getRandomUserEmail(String firstName, String lastName) {
        String result = String.format("%s.%s@qa.guru", firstName, lastName);
        return result.toLowerCase();
    }

    public String getRandomItemFromArray(String[] array) {
        int index = ThreadLocalRandom.current().nextInt(0, array.length - 1);
        return array[index];
    }

    public String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return getRandomItemFromArray(genders);
    }

    public String getRandomPhoneNumber(int count) {
        String result = "";
        for (int i = 0; i < count; i++)
        {
            result += String.valueOf(ThreadLocalRandom.current().nextInt(0, 9));
        }
        return result;
    }

    public String getRandomYearOfBirth(int startYear, int finishYear) {
        return String.valueOf(ThreadLocalRandom.current().nextInt(startYear, finishYear));
    }

    public String getRandomMonthOfBirth() {
        String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int monthCount = ThreadLocalRandom.current().nextInt(0, 11);
        return months[monthCount];
    }

    public String getRandomDayOfBirth(String month) {
        String dayOfBirth = "";
        switch (month) {
            case "February":
                dayOfBirth = String.valueOf(ThreadLocalRandom.current().nextInt(0, 28));
                break;
            case "April":
            case "June":
            case "September":
            case "November":
                dayOfBirth = String.valueOf(ThreadLocalRandom.current().nextInt(0, 30));
                break;
            case "January":
            case "March":
            case "May":
            case "July":
            case "August":
            case "October":
            case "December":
                dayOfBirth = String.valueOf(ThreadLocalRandom.current().nextInt(0, 31));
                break;
        }
        if (dayOfBirth.length() < 2) dayOfBirth = "0" + dayOfBirth;

        return dayOfBirth;
    }

    public String[] getRandomSubjects(int countSubjects) {
        String[] allSubjects = {"", ""};
        String[] mySubjects = new String[]{};

        //mySubjects.add

        return mySubjects;
    }

    public String getRandomCurrentAddress() {
        return faker.address().fullAddress();
    }



}
