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

8 - Прочитать со стрницы итоговую стоимость (
Total
 )
9 - Закрыть браузер
10 - Вывести в консоль итоговую стоимость ```

 */
package ru.merion.aqa.practiceDZ2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.merion.aqa.WebDriverFactory;

import java.time.Duration;

public class Task6 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.create("chrome");

        //Настраиваю не явные ожидания
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        //Переход в магазин и авторизация
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();

        //Добавление товаров в корзину
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-onesie")).click();

        //Переход в корзину
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
        driver.findElement(By.cssSelector("#checkout")).click();

        //Заполнение формы
        driver.findElement(By.cssSelector("#first-name")).sendKeys("Alex");
        driver.findElement(By.cssSelector("#last-name")).sendKeys("Smith");
        driver.findElement(By.cssSelector("#postal-code")).sendKeys("12345");

        //Продолжение
        driver.findElement(By.cssSelector("#continue")).click();

        //Подсчет стоимости и вывод в консоль
        WebElement total = driver.findElement(By.cssSelector(".summary_total_label"));
        String totalText = total.getText();
        driver.quit();
        System.out.println(totalText);

    }
}
