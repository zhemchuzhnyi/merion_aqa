package ru.merion.aqa.practiceTasks.OkhttpAPIPractics;

import java.io.IOException;

public class EmployeeServiceDemo {

    public static void main(String[] args) {
        String url = "http://localhost:8080/api/employees";
        String username = "leonardo";
        String password = "leads";

        EmployeeService service = new EmployeeService(url, username, password);

        List<Employee> empsForCompany = service.getByCompanyId();
        System.out.println(empsForCompany.size());

        int id = service.create(new CreateEmployee("A", "O", "1234", "a@mail.ru", "+7905123456"));

        Employee newEmp = service.getById(id);
        System.out.println(newEmp);
    }
}