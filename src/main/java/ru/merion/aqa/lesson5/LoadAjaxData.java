package ru.merion.aqa.lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.merion.aqa.WebDriverFactory;

import java.time.Duration;

/*

Thread sleep - неплох, но это не бестпрактикс., используется в целом если известно сколько ждать, конкретно в этом примере 16 сек

Ожидание используется для какого-то события.

В селениуме есть 2 типа ожиданий - явное (thread sleep)
и неявное - (implicity wait) - настройка каждый раз ходит в браузер, например 10 сек и каждые 10 (100 милисек) сек проверяет - есть ли элемент искомый
появился ли он или нет
Неявное работает таким образом - как найдешь код, который требуется - тогда и возвращайся

Например могут быть проблемы с сетью - слабый интернет или высокая нагрузка на сервер - контент грузиться не сразу на странице

 */

public class LoadAjaxData {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.create("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));

        driver.get("http://uitestingplayground.com/ajax");
        driver.findElement(By.cssSelector("#ajaxButton")).click(); // - нажмет, но контент не получит потому что долгая загрузка после клика

        //Thread.sleep(16 * 1000); - пример с трэд слип 

        driver.findElement(By.cssSelector("#content p")).getText();
        String content = driver.findElement(By.cssSelector("#content p")).getText();

        System.out.println(content);


        driver.quit();

    }
}
