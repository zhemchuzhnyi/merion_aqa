package ru.merion.aqa.lesson15;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import ru.merion.aqa.lesson15.model.*;

import java.io.IOException;
import java.util.List;

/**
 * Тонкий HTTP-клиент поверх OkHttp для работы с X-Clients API.
 * Каждый Response закрывается в try-with-resources, чтобы соединение возвращалось в пул.
 */
public class XClientsWebClient {
    private static final MediaType JSON = MediaType.get("application/json");
    private static final String LOGIN = "/auth/login";
    private static final String COMPANY = "company";
    private final String URL;
    private final OkHttpClient client;
    private final ObjectMapper mapper;

    public XClientsWebClient(String url) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new MyCustomLogger());
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        mapper = new ObjectMapper();
        client = new OkHttpClient.Builder().addNetworkInterceptor(interceptor).build();

        this.URL = url;
    }

    public String getToken(String login, String pass) throws IOException {
        return auth(login, pass).userToken();
    }

    public AuthResponse auth(String login, String pass) throws IOException {
        AuthRequest authRequest = new AuthRequest(login, pass);
        String jsonRequest = mapper.writeValueAsString(authRequest);
        RequestBody requestBody = RequestBody.create(jsonRequest, JSON);
        Request authReq = new Request.Builder().post(requestBody).url(URL + LOGIN).build();

        try (Response authResp = executeAndCheck(authReq)) {
            String jsonResp = authResp.body().string();
            return mapper.readValue(jsonResp, AuthResponse.class);
        }
    }

    public int create(String name, String description, String token) throws IOException {
        CreateNewCompanyRequest createNewCompanyRequest = new CreateNewCompanyRequest(name, description);
        String jsonRequest = mapper.writeValueAsString(createNewCompanyRequest);
        RequestBody requestBody = RequestBody.create(jsonRequest, JSON);

        HttpUrl url = HttpUrl.parse(URL).newBuilder().addPathSegment(COMPANY).build();

        Request request = new Request.Builder()
                .post(requestBody)
                .header("x-client-token", token)
                .url(url)
                .build();

        try (Response response = executeAndCheck(request)) {
            String jsonResponse = response.body().string();
            CreateNewCompanyResponse r = mapper.readValue(jsonResponse, CreateNewCompanyResponse.class);
            return r.id();
        }
    }

    public List<Company> getAll() throws IOException {
        return this.getAll(null);
    }

    public List<Company> getAll(Boolean isActive) throws IOException {
        HttpUrl.Builder url = HttpUrl.parse(URL).newBuilder();
        if (isActive != null) {
            url.addQueryParameter("active", isActive.toString());
        }
        url.addPathSegment(COMPANY);

        Request getAllCompanies = new Request.Builder()
                .url(url.build())
                .build();

        try (Response response = executeAndCheck(getAllCompanies)) {
            CollectionType listOfCompanies = mapper.getTypeFactory().constructCollectionType(List.class, Company.class);
            return mapper.readValue(response.body().string(), listOfCompanies);
        }
    }

    public Company getById(int id) throws IOException {
        HttpUrl.Builder b = HttpUrl.parse(URL).newBuilder();
        b.addPathSegment(COMPANY).addPathSegment(String.valueOf(id));
        Request getCompany = new Request.Builder()
                .url(b.build())
                .build();

        try (Response response = executeAndCheck(getCompany)) {
            return mapper.readValue(response.body().string(), Company.class);
        }
    }

    public Company deleteById(int id, String token) throws IOException {
        HttpUrl.Builder b = HttpUrl.parse(URL).newBuilder();
        b.addPathSegment(COMPANY).addPathSegment("delete").addPathSegment(String.valueOf(id));
        Request deleteCompany = new Request.Builder()
                .url(b.build())
                .header("x-client-token", token)
                .build();

        try (Response response = executeAndCheck(deleteCompany)) {
            return mapper.readValue(response.body().string(), Company.class);
        }
    }

    public Company setActive(int id, boolean isActive, String token) throws IOException {
        HttpUrl.Builder b = HttpUrl.parse(URL).newBuilder();
        b.addPathSegment(COMPANY).addPathSegment("status").addPathSegment(String.valueOf(id));
        Request setActive = new Request.Builder()
                .url(b.build())
                .patch(RequestBody.create("{\"isActive\": " + isActive + "}", JSON))
                .header("x-client-token", token)
                .build();

        try (Response response = executeAndCheck(setActive)) {
            return mapper.readValue(response.body().string(), Company.class);
        }
    }

    public Company updateCompany(int id, String name, String description, String token) throws IOException {
        HttpUrl.Builder b = HttpUrl.parse(URL).newBuilder();
        b.addPathSegment(COMPANY).addPathSegment(String.valueOf(id));

        CreateNewCompanyRequest createNewCompanyRequest = new CreateNewCompanyRequest(name, description);
        String jsonRequest = mapper.writeValueAsString(createNewCompanyRequest);

        Request request = new Request.Builder()
                .patch(RequestBody.create(jsonRequest, JSON))
                .header("x-client-token", token)
                .url(b.build())
                .build();

        try (Response response = executeAndCheck(request)) {
            return mapper.readValue(response.body().string(), Company.class);
        }
    }

    /**
     * Выполняет запрос и бросает понятное исключение при некорректном статусе.
     * Возвращает открытый Response — закрытие остаётся на вызывающем (try-with-resources).
     */
    private Response executeAndCheck(Request request) throws IOException {
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            String body = response.body() != null ? response.body().string() : "";
            response.close();
            throw new RuntimeException("Запрос " + request.url() + " вернул HTTP " + response.code()
                    + " " + response.message() + ": " + body);
        }
        return response;
    }
}