package ru.merion.aqa.lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomEC {

    /**
     * Создает пользовательское условие ожидания для WebDriverWait
     * Метод проверяет, что элемент содержит определенный текст после обновления страницы
     *
     * @param locator - локатор элемента для поиска
     * @param textContain - текст, который должен содержаться в элементе
     * @return ExpectedCondition<WebElement> - условие ожидания, возвращающее элемент при успехе
     */
    public static ExpectedCondition<WebElement> textContainsAfterRefresh(By locator, String textContain ) {
        // Создаем анонимную реализацию интерфейса ExpectedCondition
        return new ExpectedCondition<WebElement>() {
            /**
             * Основной метод, который будет вызываться WebDriverWait периодически
             * до тех пор, пока условие не будет выполнено или не истечет таймаут
             *
             * @param driver - экземпляр WebDriver для выполнения операций
             * @return WebElement если условие выполнено, null если не выполнено
             */
            public WebElement apply(WebDriver driver) {
                // Обновляем страницу перед каждой проверкой
                // Это полезно для динамического контента, который может изменяться
                driver.navigate().refresh();

                // Находим элемент по заданному локатору
                WebElement element = driver.findElement(locator);

                // Получаем текстовое содержимое элемента
                String text = element.getText();

                /* delete  - этот код не нужен тк ниже 1 проверка все решает. оставил для наглядности
                // Блок кода для отладки - проверка на пустой текст и вывод в консоль
                if (text.isEmpty() || text.isBlank()) {
                    System.out.println("<ПУСТО>");
                } else {
                    System.out.println(text);
                }

                // Развернутая версия проверки условия
                if (text.contains(textContain)) {
                    return element;
                } else {
                    return null;
                } */

                // Компактная проверка: если текст содержит искомую подстроку - возвращаем элемент,
                // иначе возвращаем null (что означает, что условие еще не выполнено)
                return text.contains(textContain) ? element : null;
            }

            /**
             * Переопределение метода toString() для более информативного вывода в логах
             * Этот метод вызывается при логировании ошибок таймаута ожидания
             *
             * @return String - описание условия ожидания для отладки
             */
            public String toString() {
                return "Элемент с локатором " + locator + " содержит текст \"" + textContain + "\"";
            }
        };
    }
}