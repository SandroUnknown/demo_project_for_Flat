package utils;

public enum Gender {
    MALE("Male"), FEMALE("Female"), OTHER("Other");
    private final String title;

    Gender(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}