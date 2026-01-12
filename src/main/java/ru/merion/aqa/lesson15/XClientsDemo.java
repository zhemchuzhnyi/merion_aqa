package ru.merion.aqa.lesson15;

import okhttp3.*;

import java.awt.*;
import java.io.IOException;

public class XClientsDemo {

    public static final String URL = "http://51.250.26.13:8083";

    public static void main(String[] args) throws IOException {

        // авторизация
        XClientsWebClient service = new XClientsWebClient(URL);
        String token = service.getToken("leonardo", "leads");

        // создание организации
        int newCompanyID = service.create("ABC", "Letters", token);


        OkHttpClient client = new OkHttpClient();

        List<Company> companyList = service.getAll();
    }
}