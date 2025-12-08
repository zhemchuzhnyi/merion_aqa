package ru.merion.aqa.lesson_12;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(BeforeAndAfterEachCallbacks.class)

/**
 * Класс для демонстрации различных типов assertions (утверждений) в JUnit 5
 */
public class AssertionsTest {
    /**
     * Тест проверяет базовое равенство чисел
     */
    @Test
    public void eqAssert() {
        // Фактическое значение - результат вычисления
        int actual = 2 + 2;
        // Ожидаемое значение
        int expected = 4;
        // Проверяем, что ожидаемое и фактическое значения равны
        // Третий параметр - сообщение, которое выведется при провале теста
        assertEquals(expected, actual, "Математика сломалась");
    }

    /**
     * Тест демонстрирует проверку равенства двух массивов
     */
    @Test
    public void arraysEqualityDemo() {
        // Первый массив
        int[] arrA = {1,2,3,4,5};
        // Второй массив с теми же элементами
        int[] arrB = {1,2,3,4,5,};
        // Проверяем, что массивы полностью идентичны (по длине и содержимому)
        assertArrayEquals(arrA, arrB);
    }

    /**
     * Тест демонстрирует проверку НЕравенства массивов
     */
    @Test
    public void arraysNonEqualityDemo() {
        // Первый массив
        int[] arrA = {1,2,3,4,5};
        // Второй массив с отличающимся последним элементом
        int[] arrB = {1,2,3,4,9};
        // Проверяем, что массивы НЕ равны (должно вернуть false)
        assertFalse(Arrays.equals(arrA, arrB));
    }

    /**
     * Тест проверяет равенство двух объектов пользователя
     */
    @Test
    public void checkTwoObjectEquality() {
        // Создаем объект пользователя, якобы полученного из XML
        User userFromXml = new User(1,"Tester name", "TEST");
        // Создаем объект пользователя, якобы полученного из базы данных
        User userFromDb = new User(1,"Tester name", "TEST");
        // Проверяем, что объекты равны (требуется переопределенный метод equals в классе User)
        assertEquals(userFromXml, userFromDb);
    }

    /**
     * Тест проверяет, что соединение НЕ защищено (URL использует http, а не https)
     */
    @Test
    public void checkConnectionIsNotSecure() {
        String url = "http://the-internet.herokuapp.com/";
        // Проверяем, что URL НЕ содержит "https" (только "http" без 's')
        // Тест пройдет, так как url содержит "http://", но не "https://"
        assertFalse(url.contains("https"));
    }

    /**
     * Тест проверяет, что соединение защищено (URL содержит https)
     */
    @Test
    public void checkConnectionIsSecure() {
        String url = "https://the-internet.herokuapp.com/";
        // Проверяем, что URL содержит "https" (безопасное соединение)
        // Тест пройдет успешно
        assertTrue(url.contains("https"));
    }

    // Объявляем переменную WebDriver (не инициализирована, будет null)
    WebDriver driver;

    /**
     * Тест проверяет, что драйвер НЕ является null
     * (тест провалится, так как driver не инициализирован)
     */
    @Test
    public void checkDriverIsNull() {
        // Проверяем, что driver не null (проверка провалится)
        assertNotNull(driver);
    }

    /**
     * Тест проверяет, что выбрасывается исключение NullPointerException
     */
    @Test
    public void checkThrows() {
        // Проверяем, что при выполнении лямбда-выражения выбросится NullPointerException
        // Это произойдет, потому что driver == null
        assertThrows(NullPointerException.class, () -> {
            driver.get("https://ya.ru");
        });
    }
}