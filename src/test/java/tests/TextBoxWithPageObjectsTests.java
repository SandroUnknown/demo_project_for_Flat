package tests;

import org.junit.jupiter.api.Test;
import page.TextBoxPage;
import utils.RandomDataUtils;

public class TextBoxWithPageObjectsTests extends TestBase {

    private final TextBoxPage textBoxPage = new TextBoxPage();
    private final RandomDataUtils randomData = new RandomDataUtils();

    @Test
    void successfulTextBoxWithFullDataTest() {
        String userName         = String.format("%s %s", randomData.getRandomFirstName(), randomData.getRandomLastName());
        String userEmail        = randomData.getRandomUserEmail();
        String currentAddress   = randomData.getRandomAddress();
        String permanentAddress = randomData.getRandomAddress();

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