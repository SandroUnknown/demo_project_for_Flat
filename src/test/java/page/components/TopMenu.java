package page.components;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import models.Menu;
import org.junit.jupiter.api.DisplayName;

import java.io.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TopMenu {

    private final ElementsCollection
            menuSelector = $("#sp-menu ul").findAll("li");

    @DisplayName("Проверить наличие всех основных пунктов меню.")
    public void checkMenuItems() throws IOException {
        Menu menu = new ObjectMapper().readValue(new File("src/test/resources/data/menu.json"), Menu.class);

        for (models.Menu.Item item : menu.getItem()) {
            if (item.getURL().isEmpty()) {
                for (Menu.SubItem subItem : item.getSubItem()) {
                    menuSelector.
                            findBy(text(item.getName())).hover().
                            $$("ul li").findBy(text(subItem.getName())).
                            $("a").shouldHave(href(subItem.getURL()));
                }
            } else {
                menuSelector.
                        findBy(text(item.getName())).
                        $("a").shouldHave(href(item.getURL()));
            }
        }
    }
}