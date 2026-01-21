package ru.merion.aqa.practiceTasks.OkhttpAPIPractics;

import java.io.IOException;

public class EmployeeService {
    public static final String URl = "http://51.250.26.13:8083/docs";
    public static final String Employee = "/employee";

    public static void main(String[] args) throws IOException {
        EmployeeWebClient service = new EmployeeWebClient(URl);
    }

    String token = service.getToken("leonardo", "leads");

}
