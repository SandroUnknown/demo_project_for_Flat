package tests;

import org.junit.jupiter.api.Test;
import page.TextBoxPage;
import utils.RandomDataUtils;

public class TextBoxWithPageObjectsTests extends TestBase {

    private final TextBoxPage textBoxPage = new TextBoxPage();
    private final RandomDataUtils randomDataUtils = new RandomDataUtils();

    @Test
    void successfulTextBoxWithFullDataTest() {
        String firstName        = randomDataUtils.getRandomFirstName();
        String lastName         = randomDataUtils.getRandomLastName();
        String userName         = firstName + " " + lastName;
        String userEmail        = randomDataUtils.getRandomUserEmail(firstName, lastName);
        String currentAddress   = randomDataUtils.getRandomAddress();
        String permanentAddress = randomDataUtils.getRandomAddress();

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