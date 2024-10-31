package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import models.Partners;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import page.PartnerPage;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;

@Tag("PartnerPage")
@Feature("Проверить страницу партнеров: https://flat-soft.ru/partner/partnery/")
@DisplayName("Проверить страницу партнеров.")
@Link(value = "Test page", url = "https://flat-soft.ru/partner/partnery/")
@Owner("Petyukov Alexander")
public class PartnerPageTest extends TestBase {

    private final PartnerPage partnerPage = new PartnerPage();
    private final String url = "/partner/partnery";

    @Tag("Smoke")
    @Tag("TopBar")
    @DisplayName("Проверить 'top-bar'.")
    @Test
    void topBarTest() {
        step("Открыть страницу.", () -> {
            partnerPage.openPage(url);
        });
        step("Проверить, что 'top-bar' содержит контактные данные (телефон и email).", () -> {
            partnerPage.checkTopBar();
        });
    }

    @Tag("TopMenu")
    @DisplayName("Проверить меню.")
    @Test
    void topMenuTest() {
        step("Открыть страницу.", () -> {
            partnerPage.openPage(url);
        });
        step("Проверить, что в меню (и подменю) есть необходимые ссылки на страницы сайта.", () -> {
            partnerPage.checkTopMenu();
        });
    }

    @Tag("Smoke")
    @Tag("Footer")
    @DisplayName("Проверить 'footer'.")
    @Test
    void footerTest() {
        step("Открыть страницу.", () -> {
            partnerPage.openPage(url);
        });
        step("Проверить, что меню в footer содержит корректные ссылки.", () -> {
            partnerPage.checkFooterMenu();
        });
        step("Проверить, что footer содержит правильные 'контактные данные'.", () -> {
            partnerPage.checkFooterContacts();
        });
        step("Проверить, что footer есть текст авторских прав и корректно указан год.", () -> {
            partnerPage.checkFooterCopyright();
        });
    }

    static Stream<Arguments> checkPartners() throws IOException {
        Partners partners = new ObjectMapper().readValue(new File("src/test/resources/data/partnersList.json"), Partners.class);

        return partners.getCities().stream()
                .map(data -> Arguments.of(data.getName(), data.getPartners()));
    }

    @Tag("PartnerPageContent")
    @DisplayName("Проверить партнеров.")
    @MethodSource
    @ParameterizedTest(name = "Город: {0}")
    void checkPartners(String cityName, List<models.Partners.Partner> partners) {
        step("Открыть страницу.", () -> {
            partnerPage.openPage(url);
        });
        step("Проверить всех партнеров в городе " + cityName, () -> {
            partnerPage.checkPartners(cityName, partners);
        });
    }

    @Tag("PartnerPageContent")
    @DisplayName("Найти партнера (через поиск) и проверить его.")
    @CsvFileSource(resources = "/data/partnersForSearch.scv")
    @ParameterizedTest(name = "Партнер: {0}")
    void searchPartner(String partnerName, String partnerUrl, String partnerPhone, String partnerLevel) {
        step("Открыть страницу.", () -> {
            partnerPage.openPage(url);
        });
        step("Найти партнера (через поиск) и проверить его.", () -> {
            partnerPage.searchPartner(partnerName, partnerUrl, partnerPhone, partnerLevel);
        });
    }
}