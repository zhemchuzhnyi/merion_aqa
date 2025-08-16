/*
Переход на Merion Academy
Напишите скрипт, который выполняет следующие шаги:

Открыть браузер chrome
Перейти на страницу
google.com
В строке поиска написать
Merion Academy wiki
Нажать Enter (Keys.RETURN)
На странице с результатами выбрать первую ссылку и кликнуть на нее
После перехода, получить текущий URL:
Если URL начинается со строки
https://wiki.merionet.ru
, написать
Добро пожаловать в Merion Academy!
.
Иначе написать в консоль
Мы попали куда-то не туда...
 */

package ru.merion.aqa.practiceDZ;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task7 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");


    }


}
