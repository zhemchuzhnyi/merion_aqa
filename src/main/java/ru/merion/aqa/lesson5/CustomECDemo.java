package ru.merion.aqa.lesson5;

import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CustomECDemo {

    public static void main(String[] args) {
        Path relativePath = Path.of("/Users/a0000/IdeaProjects/merion_aqa/src/main/resources/dummu_pages/old_vk.html");
        String filePath = Paths.get("").toAbsolutePath().resolve(relativePath).toString();

        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("file://" + filePath);

    }
}
