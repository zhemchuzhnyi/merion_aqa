package ru.merion.aqa.selenideDZ_2_Page.Task4;

/*
Скрипт заполнения формы

Напишите скрипт. Шаги:

Открыть страницу https://bonigarcia.dev/selenium-webdriver-java/data-types.html

Заполнить форму значениями

Поле	Значение
First name	Иван
Last name	Петров
Address	Ленина, 55-3
Zip code	*оставить пустым
City	Москва
Country	Россия
E-mail	*оставить пустым
Phone number	*оставить пустым
Job position	QA
Company	Merion
Нажать кнопку Submit

Вывести в консоль цвет полей
Zip code
,
E-mail
 и
Phone
 (background-color)
 */

import com.codeborne.selenide.Selenide;

public class Task4 {
    public static void main(String[] args) {

        RegisterPage page = new RegisterPage().open();

        page.set("first-name", "Иван");
        page.set("last-name", "Петров");
        page.set("job-position", "QA");
        page.set("address", "Ленина 55-3");
        page.set("city", "Москва");
        page.set("country", "Россия");
        page.set("company", "Merion");

        page.submitForm();

        String phone_bg = page.getCssProperty("#phone", "background-color");
        String email_bg = page.getCssProperty("#e-mail", "background-color");
        String zip_code_bg = page.getBgColor("#zip-code");

        System.out.println(zip_code_bg);
        System.out.println(email_bg);
        System.out.println(phone_bg);

        Selenide.closeWebDriver();
    }
}
