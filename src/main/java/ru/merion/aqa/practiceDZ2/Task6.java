/*
Напишите скрипт для работы с интернет-магазином. Шаги
1 - Открыть сайт магазина https://www.saucedemo.com/
2 - Авторизоваться под пользователем
standard_user

3 - Добавить в корзину товары:
- Sauce Labs Backpack
- Sauce Labs Bolt T-Shirt
- Sauce Labs Onesie

4 - Перейти в корзину
5 - Нажать Checkout

6 - Заполнить форму данными:
- Имя
- Фамиля
- Почтовый индекс
7 - Нажать continue

8- Прочитать со стрницы итоговую стоимость (
Total
 )
9 - Закрыть браузер
10 - Вывести в консоль итоговую стоимость ```

 */
package ru.merion.aqa.practiceDZ2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.merion.aqa.WebDriverFactory;

public class Task6 {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.create("chrome");
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();

        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-onesie")).click();




    }
}
