package ru.merion.aqa.lesson15;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;


public class OkHttpDemo {
    public static final String URL = "https://ya.ru/";

    public static void main(String[] args) throws IOException {
        // client
        OkHttpClient client = new OkHttpClient();

        // request
        Request getAllTask = new Request.Builder()
                .url(URL)
                .get()
                .build();

        // execute
        Response response = client.newCall(getAllTask).execute();


        System.out.println("Status: " + response.code());

    }
}

//     public static final String URL = "https://sky-todo-list.herokuapp.com/";