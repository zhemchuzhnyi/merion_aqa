package ru.merion.aqa.practiceTasks.OkhttpAPIPractics;

import java.io.IOException;

/**
 * Класс для демонстрации работы EmployeeService
 */
public class EmployeeServiceDemo {
    public static void main(String[] args) throws IOException {
        System.out.println("=== Создание сервиса и авторизация ===");
        EmployeeService service = new EmployeeService("leonardo", "leads");
        System.out.println("✓ Авторизация успешна! Токен получен.");
        System.out.println();

        // 1. Получить список всех сотрудников
        System.out.println("=== 1. Получение списка сотрудников компании ID=1 ===");
        String employeeList = service.getEmployeeList(1);
        System.out.println(employeeList);
        System.out.println();

        // 2. Создать нового сотрудника
        System.out.println("=== 2. Создание нового сотрудника ===");
        int newEmployeeId = service.createEmployee(
                1,              // ID компании
                "Иван",         // Имя
                "Иванов",       // Фамилия
                "+79991234567", // Телефон
                true            // Активен
        );
        System.out.println("✓ Сотрудник создан с ID: " + newEmployeeId);
        System.out.println();

        // 3. Получить информацию о созданном сотруднике
        System.out.println("=== 3. Получение информации о сотруднике #" + newEmployeeId + " ===");
        String employee = service.getEmployeeById(newEmployeeId);
        System.out.println(employee);
        System.out.println();

        // 4. Обновить данные сотрудника
        System.out.println("=== 4. Обновление данных сотрудника ===");
        String updated = service.updateEmployee(
                newEmployeeId,
                "Петров",              // Новая фамилия
                "ivanov@test.com",     // Email
                "+79997654321",        // Новый телефон
                true                   // Активен
        );
        System.out.println("✓ Данные обновлены:");
        System.out.println(updated);
        System.out.println();

        // 5. Получить обновленную информацию
        System.out.println("=== 5. Проверка обновленных данных ===");
        String updatedEmployee = service.getEmployeeById(newEmployeeId);
        System.out.println(updatedEmployee);
        System.out.println();

        System.out.println("=== Все операции выполнены успешно! ===");
    }
}