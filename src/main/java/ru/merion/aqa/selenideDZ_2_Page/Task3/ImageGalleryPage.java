package ru.merion.aqa.selenideDZ_2_Page.Task3;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

import java.time.Duration;
import java.util.Collection;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$$;

public class ImageGalleryPage {
    public ImageGalleryPage open() {
        Selenide.open("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
        return this;
    }

    public String getImageProperty(int imageIndex, String propertyName) {
        long timeoutBefore = Configuration.timeout;
        Configuration.timeout = 20 * 1000;
        String value = $$("#image-container img")
                .shouldHave(CollectionCondition.sizeGreaterThan(imageIndex))
                .get(imageIndex)
                .attr(propertyName);
        Configuration.timeout = timeoutBefore;
        return value;
    }
}
