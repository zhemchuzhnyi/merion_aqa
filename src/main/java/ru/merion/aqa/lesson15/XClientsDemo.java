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

        // получение токена
        String token = service.getToken("leonardo", "leads");

        // создание организации
        int newCompanyID = service.create("Merion", "AQA Java", token);

        // получение списка всех организаций
        List<Company> companyList = service.getAll(false);

        // получение компании по id
        Company companyByID = service.getById(newCompanyID);
        System.out.println(companyByID);

        // обновление информации о компании
        Company updatedCompany = service.updateCompany(
                newCompanyID,
                "Merion Updated Test",
                "New Description",
                token
        );
        System.out.println(updatedCompany);

        // изменение статуса активности компании
        Company deactivatedCompany = service.setActive(newCompanyID, false, token);
        System.out.println("Деактивирована: " + deactivatedCompany);

        // снова активируем
        Company activatedCompany = service.setActive(newCompanyID, true, token);
        System.out.println("Активирована: " + activatedCompany);

        // удаление компании
        Company companyDeleteById = service.deleteById(newCompanyID, token);
        System.out.println(companyDeleteById);

    }
}