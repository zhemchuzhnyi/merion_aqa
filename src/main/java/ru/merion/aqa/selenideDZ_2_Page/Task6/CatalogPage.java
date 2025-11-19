package ru.merion.aqa.selenideDZ_2_Page.Task6;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collection;
import java.util.Set;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class CatalogPage {
    private final ElementsCollection items = $$(".inventory-item");

    public void addItems(Collection<String> itemNames) {
        items.forEach(item -> {
            String productName = item.find(".inventory-item-name").text();
            if(itemNames.contains(productName)) {
                item.find("button").click();
            }
        });
    }
}


