package ru.merion.aqa.lesson15;

import okhttp3.*;

import java.io.IOException;


public class OkHttpDemo {
    public static final String URL = "https://sky-todo-list.herokuapp.com/";

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
        MediaType mediaType = response.body().contentType();
        String body = response.body().string();



        System.out.println("Status: " + response.code());
        System.out.println(mediaType);
        System.out.println(body);

        String json = "{\"title\":\"94649646\",\"completed\":false}";
        RequestBody requestBody = RequestBody.create(json, mediaType);
        Request createNewTaskRequest = new Request.Builder()
                .url(URL)
                .post(null)
                .header("Content-Type","application/json")
                .build();

        response = client.newCall(createNewTaskRequest).execute();

    }
}
