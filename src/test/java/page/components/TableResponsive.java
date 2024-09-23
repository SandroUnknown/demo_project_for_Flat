package page.components;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;

public class TableResponsive {

    public static String arrayToString(String[] array) {
        String result = "";
        for (String element : array) {
            result += element + ", ";
        }
        return result.substring(0, result.length() - 2);
    }

    public void checkResult(String key, String value) {
        $(".table-responsive").$(byTagAndText("td", key)).sibling(0).shouldHave(text(value));
    }

    public void negativeCheck() {
        $("form#userForm").shouldHave(attribute("class", "was-validated"));
    }
}