package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import page.MainPage;

import static io.qameta.allure.Allure.step;

@Tag("MainPage")
@Feature("Проверка главной страницы сайта https://flat-soft.ru/")
@DisplayName("Проверка главной страницы.")
@Link(value = "Test page", url = "https://flat-soft.ru/")
@Owner("Petyukov Alexander")
public class MainPageTest extends TestBase {

    private final MainPage mainPage = new MainPage();
    private final String url = "/";

    @Tag("Smoke")
    @Tag("TopBar")
    @DisplayName("Проверить 'top-bar'.")
    @Test
    void topBarTest() {
        step("Открыть страницу.", () -> {
            mainPage.openPage(url);
        });
        step("Проверить, что 'top-bar' содержит контактные данные (телефон и email).", () -> {
            mainPage.checkTopBar();
        });
    }

    @Tag("TopMenu")
    @DisplayName("Проверить меню.")
    @Test
    void topMenuTest() {
        step("Открыть страницу.", () -> {
            mainPage.openPage(url);
        });
        step("Проверить, что в меню (и подменю) есть необходимые ссылки на страницы сайта.", () -> {
            mainPage.checkTopMenu();
        });
    }

    @Tag("Smoke")
    @Tag("Footer")
    @DisplayName("Проверить 'footer'.")
    @Test
    void footerTest() {
        step("Открыть страницу.", () -> {
            mainPage.openPage(url);
        });
        step("Проверить, что меню в footer содержит корректные ссылки.", () -> {
            mainPage.checkFooterMenu();
        });
        step("Проверить, что footer содержит правильные 'контактные данные'.", () -> {
            mainPage.checkFooterContacts();
        });
        step("Проверить, что footer есть текст авторских прав и корректно указан год.", () -> {
            mainPage.checkFooterCopyright();
        });
    }

    @DisplayName("Проверить содержимое страницы.")
    @Test
    void pageContentTest() {
        step("Открыть страницу.", () -> {
            mainPage.openPage(url);
        });
        step("Проверить слоган.", () -> {
            mainPage.checkSlogan();
        });
        step("Проверить услуги (и корректность ссылок в них).", () -> {
            mainPage.checkServices();
        });
    }
}