package tests;

import org.junit.jupiter.api.Test;
import page.TextBoxPage;

public class TextBoxWithPageObjectsTests extends TestBase {

    private final TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void successfulTextBoxWithFullDataTest() {
        String userName = "Alexander Petyukov";
        String userEmail = "alexander@petyukov.com";
        String currentAddress = "Milan, Italy";
        String permanentAddress = "Moscow, Russia";

        textBoxPage.openPage()
                .setFullName(userName)
                .setUserEmail(userEmail)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .clickSubmit();

        textBoxPage
                .checkResult("Name:", userName)
                .checkResult("Email:", userEmail)
                .checkResult("Current Address :", currentAddress)
                .checkResult("Permananet Address :", permanentAddress);
    }
}