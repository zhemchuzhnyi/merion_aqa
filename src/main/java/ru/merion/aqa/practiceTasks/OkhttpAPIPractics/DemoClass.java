package ru.merion.aqa.practiceTasks.OkhttpAPIPractics;

import ru.merion.aqa.practiceTasks.OkhttpAPIPractics.model.CreateEmployee;
import ru.merion.aqa.practiceTasks.OkhttpAPIPractics.model.Employee;

import java.io.IOException;
import java.util.List;

public class DemoClass {
    public static void main(String[] args) throws IOException {
        String url = "http://51.250.26.13:8083";
        String username = "leonardo";
        String password = "leads";

        EmployeeService service = new EmployeeService(url, username, password);

        List<Employee> empsForCompany = service.getByCompanyId(1339);
        System.out.println(empsForCompany.size());

        int id = service.create(new CreateEmployee("D", "E", 1339, "e@mail.ru", "+7985678"));

        Employee newEmp = service.getById(id);
        System.out.println(newEmp);
    }
}