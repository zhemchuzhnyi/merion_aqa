package ru.merion.aqa.practiceTasks.OkhttpAPIPractics;

import ru.merion.aqa.practiceTasks.OkhttpAPIPractics.EmployeeService;
import ru.merion.aqa.practiceTasks.OkhttpAPIPractics.model.CreateEmployee;
import ru.merion.aqa.practiceTasks.OkhttpAPIPractics.model.Employee;

import java.io.IOException;

public class DemoClass {
    public static void main(String[] args) throws IOException {
        String url = "http://51.250.26.13:8083";
        String username = "leonardo";
        String password = "leads";

        EmployeeService service = new EmployeeService(url, username, password);

        // Вариант 1: Используем фабричный метод (без email)
        int id = service.create(CreateEmployee.of("A", "O", 1653, "+7985678"));

        // Вариант 2: Используем конструктор (email будет проигнорирован)
        // int id = service.create(new CreateEmployee("A", "O", 1653, null, "+7985678"));

        Employee newEmp = service.getById(id);
        System.out.println(newEmp);

        // Просто знаем, что email будет null и не используем его
        System.out.printf("Сотрудник: %s %s, ID: %d, Телефон: %s%n",
                newEmp.firstName(), newEmp.lastName(),
                newEmp.id(), newEmp.phone());
    }

}