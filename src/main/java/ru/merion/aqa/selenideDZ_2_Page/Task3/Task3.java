package ru.merion.aqa.selenideDZ_2_Page.Task3;

/*
Дождаться картинки

Напишите скрипт. Шаги:

Перейти на сайт https://bonigarcia.dev/selenium-webdriver-java/loading-images.html
Дождаться загрузки 3й картинки
Получить значение атрибута
src - у 3й картинки
Вывести значение в консоль
 */

import com.codeborne.selenide.Selenide;


public class Task3 {
    public static void main(String[] args) {
        ImageGalleryPage gallery = new ImageGalleryPage().open();
        String src = gallery.getImageProperty(2, "src");
        System.out.println("Атрибут картинки: " + src);

        Selenide.closeWebDriver();
    }
}
