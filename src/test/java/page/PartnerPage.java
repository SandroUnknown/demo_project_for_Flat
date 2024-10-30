package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import models.Partners;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import page.components.Footer;
import page.components.TopBar;
import page.components.TopMenu;

import java.io.IOException;
import java.lang.reflect.Array;
import java.text.Format;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.fail;

@Tag("PartnerPage")
@Feature("Проверка страницы партнеров https://flat-soft.ru/partner/partnery/")
@DisplayName("Проверка страницы партнеров.")
@Link(value = "Test page", url = "https://flat-soft.ru/partner/partnery/")
@Owner("Petyukov Alexander")
public class PartnerPage {

    private final SelenideElement
            cityListSelector     = $(".jlmf-list-2"),
            filterButtonSelector = $(".jlmf-button");

    private final ElementsCollection
            partnerCardsSelector = $$("div.col-lg-6");

    @DisplayName("Открыть страницу.")
    public PartnerPage openPage(String url) {
        open(url);
        return this;
    }

    @DisplayName("Проверить top-bar.")
    public PartnerPage checkTopBar() {
        new TopBar()
                .checkPhoneNumber()
                .checkEmail();
        return this;
    }

    @DisplayName("Проверить top-menu.")
    public PartnerPage checkTopMenu() throws IOException {
        new TopMenu().checkMenuItems();
        return this;
    }

    @DisplayName("Проверить контакты в footer.")
    public PartnerPage checkFooterMenu() {
        new Footer().checkMenu();
        return this;
    }

    @DisplayName("Проверить контакты в footer.")
    public PartnerPage checkFooterContacts() {
        new Footer()
                .checkPhoneNumber()
                .checkEmail()
                .checkOperationMode()
                .checkAdress();
        return this;
    }

    @DisplayName("Проверить авторские права в footer.")
    public PartnerPage checkFooterCopyright() {
        new Footer()
                .checkCopyrightText()
                .checkCopyrightYear();
        return this;
    }

    @DisplayName("Проверить партнеров.")
    public PartnerPage checkPartners(String cityName, List<Partners.Partner> partners) {
        step("Выбрать город " + cityName + ".", () -> {
            cityListSelector.$(byText(cityName)).click();
        });
        step("Нажать 'Применить фильтр'.", () -> {
            filterButtonSelector.click();
        });
        step("Проверить партнеров.", () -> {
            int pageCount = $$(".pagination li").size();
            int currentPage = 0;
            int arraySize = Math.max(pageCount - 4, 0);

            for (models.Partners.Partner partner : partners) {

                boolean[] checkedPages = new boolean[arraySize];

                do {
                    try{
                        partnerCardsSelector
                                .findBy(text(partner.getName())).scrollIntoView(true)
                                .shouldHave(text(partner.getPhone()))
                                .shouldHave(text(partner.getLevel()))
                                .$("a").shouldHave(href(partner.getURL()));
                        break;
                    }
                    catch (com.codeborne.selenide.ex.ElementNotFound e) {

                        checkedPages[currentPage] = true;
                        currentPage = getNonCheckedPage(checkedPages, currentPage);

                        if (currentPage == -1) {
                            fail(String.format("Элемент '%s' не найден ни на одной из страниц.", partner.getName()));
                        }

                        $(".pagination").scrollIntoView(true);
                        sleep(2000);
                        $$(".pagination li").get(currentPage + 2).click();
                    }
                } while (currentPage >= 0);
            }
        });
        return this;
    }

    private int getNonCheckedPage(boolean[] checkedPages, int currentPage){
        int arraySize = checkedPages.length;

        for (int i = currentPage + 1; i < arraySize; i++) {
            if (checkedPages[i] == false) return i;
        }

        for (int i = 0; i < currentPage; i++) {
            if (checkedPages[i] == false) return i;
        }

        return -1;
    }
}
