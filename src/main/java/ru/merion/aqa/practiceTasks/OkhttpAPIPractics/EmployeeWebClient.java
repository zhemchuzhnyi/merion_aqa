package ru.merion.aqa.practiceTasks.OkhttpAPIPractics;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import ru.merion.aqa.lesson15.MyCustomLogger;
import ru.merion.aqa.lesson15.model.AuthRequest;
import ru.merion.aqa.lesson15.model.AuthResponse;
import ru.merion.aqa.lesson15.model.CreateNewCompanyRequest;
import ru.merion.aqa.lesson15.model.CreateNewCompanyResponse;

import java.io.IOException;

public class EmployeeWebClient {
    private static final MediaType JSON = MediaType.get("application/json");

    private static final String LOGIN = "/auth/login";

    private static final String Employee = "/employee";

    private final String URL;

    private final OkHttpClient client;

    private final ObjectMapper mapper;

    public EmployeeWebClient(String URL) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new MyCustomLogger());
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        mapper = new ObjectMapper();
        client = new OkHttpClient.Builder().addNetworkInterceptor(interceptor).build();

        this.URL = URL;
    }

    public String getToken(String login, String pass) throws IOException {
        return auth(login, pass).userToken();
    }

    public AuthResponse auth(String login, String pass) throws IOException {
        AuthRequest authRequest = new AuthRequest(login, pass);
        String jsonRequest = mapper.writeValueAsString(authRequest);
        RequestBody requestBody = RequestBody.create(jsonRequest, JSON);
        Request authReq = new Request.Builder().post(requestBody).url(URL + LOGIN).build();
        Response authResp = client.newCall(authReq).execute();
        String jsonResp = authResp.body().string();
        return mapper.readValue(jsonResp, AuthResponse.class);
    }

    public int create(String name, String description, String token) throws IOException {
        CreateNewCompanyRequest createNewCompanyRequest = new CreateNewCompanyRequest(name, description);
        String jsonRequest = mapper.writeValueAsString(createNewCompanyRequest);
        RequestBody requestBody = RequestBody.create(jsonRequest, JSON);

        HttpUrl url = HttpUrl.parse(URL).newBuilder().addPathSegment(Employee).build();

        Request request = new Request.Builder()
                .post(requestBody)
                .header("x-client-token", token)
                .url(URL + Employee)
                .build();

        Response response = client.newCall(request).execute();
        String jsonResponce = response.body().string();
        CreateNewCompanyResponse r = mapper.readValue(jsonResponce, CreateNewCompanyResponse.class);

        return r.id();
    }
}
