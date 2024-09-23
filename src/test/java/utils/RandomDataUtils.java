package utils;

import com.github.javafaker.Faker;
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

    public String[] getRandomSubjects(int count) {
        String[] subjects = {"Accounting",
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

        if (count >= subjects.length) return subjects;

        String[] result = new String[count];
        for(int i = 0; i < count; i++) {
            int index = ThreadLocalRandom.current().nextInt(0, subjects.length - 1 - i);
            result[i] = subjects[index];
            String lastElement = subjects[subjects.length - 1 - i];
            subjects[subjects.length - 1 - i] = subjects[index];
            subjects[index] = lastElement;
        }
        return result;
    }

    public String[] getRandomHobbies(int count) {
        String[] hobbies = {"Sports", "Reading", "Music"};

        if (count >= hobbies.length) return hobbies;

        String[] result = new String[count];
        for(int i = 0; i < count; i++) {
            int index = ThreadLocalRandom.current().nextInt(0, hobbies.length - 1 - i);
            result[i] = hobbies[index];
            String lastElement = hobbies[hobbies.length - 1 - i];
            hobbies[hobbies.length - 1 - i] = hobbies[index];
            hobbies[index] = lastElement;
        }
        return result;
    }

    public String getRandomImage() {
        String[] images = {"angry.gif", "cool.jpg", "smile.png"};
        int index = ThreadLocalRandom.current().nextInt(0, images.length - 1);
        return images[index];
    }

    public String getRandomAddress() {
        return faker.address().fullAddress();
    }

    public String[][] stateCity =  {{"NCR", "Delhi", "Gurgaon", "Noida"},
                                    {"Uttar Pradesh", "Agra", "Lucknow", "Merrut"},
                                    {"Haryana", "Karnal", "Panipat"},
                                    {"Rajasthan", "Jaipur", "Jaiselmer"} };

    public String getRandomState() {
        int stateIndex = ThreadLocalRandom.current().nextInt(0, stateCity.length - 1);
        return stateCity[stateIndex][0];
    }

    public String getRandomCity(String state) {
        int stateIndex = 0;
        for (int i = 0; i < stateCity.length; i++){
            if (stateCity[i][0] == state) {
                stateIndex = i;
                break;
            }
        }
        int cityIndex = ThreadLocalRandom.current().nextInt(1, stateCity[stateIndex].length - 1);
        return stateCity[stateIndex][cityIndex];
    }
}
