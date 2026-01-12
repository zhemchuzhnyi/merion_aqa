package ru.merion.aqa.lesson15;

import ru.merion.aqa.lesson15.model.Company;

import java.io.IOException;
import java.util.List;

public class XClientsDemo {

    public static final String URL = "http://51.250.26.13:8083";
    public static final String COMPANY = "/company";

    public static void main(String[] args) throws IOException {

        // авторизация
        XClientsWebClient service = new XClientsWebClient(URL);
        String token = service.getToken("leonardo", "leads");

        // создание организации
        int newCompanyID = service.create("ABC", "Letters", token);

        List<Company> companyList = service.getAll();
    }
}