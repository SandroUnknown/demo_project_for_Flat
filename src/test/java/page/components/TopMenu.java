package page.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.Map;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class TopMenu {

    // TODO
    // Убрать в файл мапу????

    private final Map<Map<String, String>, Map<String, String>> collectionMenuItems = Map.of (
            Map.of ("Продукты", ""), Map.of (
                    "ФЛАТ SoftSwitch",      "https://flat-soft.ru/produkty/flat-softswitch",
                    "ФЛАТ Device Manager",  "https://flat-soft.ru/produkty/flat-device-manager",
                    "ФЛАТ Партнер",         "https://flat-soft.ru/produkty/flat-partner",
                    "ФЛАТ Тарификация",     "https://flat-soft.ru/produkty/flat-tarifikatsiya",
                    "ФЛАТ Контакт",         "https://flat-soft.ru/produkty/flat-kontakt",
                    "ФЛАТ Запись",          "https://flat-soft.ru/produkty/flat-zapis",
                    "ФЛАТ Оповещение",      "https://flat-soft.ru/produkty/flat-opoveshchenie",
                    "ФЛАТ Конференция",     "https://flat-soft.ru/produkty/flat-konferentsiya",
                    "ФЛАТ Факс",            "https://flat-soft.ru/produkty/flat-faks",
                    "Флат SBC",           "https://flat-soft.ru/produkty/flat-sbc"
            ),
            Map.of ("Решения", ""), Map.of (
                    "Топливно-энергетический комплекс", "https://flat-soft.ru/resheniya/toplivno-energeticheskij-kompleks",
                    "Государственный сектор",           "https://flat-soft.ru/resheniya/gosudarstvennyj-sektor",
                    "Финансовый сектор",                "https://flat-soft.ru/resheniya/finansovyj-sektor",
                    "Ритейл и сфера услуг",             "https://flat-soft.ru/resheniya/ritejl-i-sfera-uslug",
                    "Здравоохранение",                  "https://flat-soft.ru/resheniya/zdravookhranenie"
            ),
            Map.of ("Миграция", "https://flat-soft.ru/migratsiya"), Map.of (
            ),
            Map.of ("Партнеры", ""), Map.of (
                    "Партнеры",     "https://flat-soft.ru/partner/partnery",
                    "Дистрибуторы", "https://flat-soft.ru/partner/distributory"
            ),
            Map.of ("Учебный центр", ""), Map.of (
                    "Интерактивный календарь",  "https://flat-soft.ru/uchebnyj-tsent/raspisanie-kursov",
                    "Базовый курс",             "https://flat-soft.ru/uchebnyj-tsent/bazovyj-kurs",
                    "Продвинутый курс",         "https://flat-soft.ru/uchebnyj-tsent/prodvinutyj-kurs",
                    "Онлайн обучение",          "https://flat-soft.ru/uchebnyj-tsent/onlajn-obuchenie"
            ),
            Map.of ("Поддержка", "https://flat-soft.ru/support"), Map.of (
            ),
            Map.of ("Стать партнером", "https://flat-soft.ru/stat-partnerom"), Map.of (
            ),
            Map.of ("ФЛАТ-ПРО", "https://flat-pro.ru/"), Map.of (
            ),
            Map.of ("Вход", "https://partnerportal.flat-soft.ru/"), Map.of (
            )
    );

    private final SelenideElement
            menuSelector = $("#sp-menu ul");

    @Step("Проверить наличие всех основных пунктов меню.")
    public TopMenu checkMenuItems() {
        for (Map<String,String> menuItems : collectionMenuItems.keySet()) {
            for (String menuItem : menuItems.keySet()) {
                step("Проверить наличие пункта <" + menuItem + "> и соответствия ему ссылки.", () -> {
                    menuSelector.findAll("li").findBy(text(menuItem)).$("a").shouldHave(href(menuItems.get(menuItem)));
                });
            }
        }
        return this;
    }

    @Step("Проверить наличие всех подпунктов в меню, где есть выпадающий список.")
    public TopMenu checkSubItems() {
        for (Map<String,String> menuItems : collectionMenuItems.keySet()) {
            for (String menuItem : menuItems.keySet()) {

                if (!menuItems.get(menuItem).isEmpty()) continue;

                step("Проверить наличие всех подпунктов в меню <" + menuItem + ">.", () -> {
                    step("Навести мышку на <" + menuItem + ">.", () -> {
                        menuSelector.findAll("li").findBy(text(menuItem)).hover();
                    });

                    Map <String,String> subMenuItems = collectionMenuItems.get(menuItems);

                    for (String item : subMenuItems.keySet()) {
                        step("Проверить наличие подпункта <" + item + "> и соответствия ему ссылки.", () -> {
                            menuSelector.findAll("li").findBy(text(menuItem)).$$("ul li").findBy(text(item)).$("a").shouldHave(href(subMenuItems.get(item)));
                        });
                    }
                });
            }
        }
        return this;
    }


}