package ru.merion.aqa.lesson15;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import ru.merion.aqa.lesson15.model.*;

import java.io.IOException;
import java.util.List;


public class XClientsWebClient {

    private static final MediaType JSON = MediaType.get("application/json");

    private static final String LOGIN = "/auth/login";

    private static final String COMPANY = "/company";

    private final String URL;

    private final OkHttpClient client;

    private final ObjectMapper mapper;

    public XClientsWebClient(String URL) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
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

        HttpUrl url = HttpUrl.parse(URL).newBuilder().addPathSegment(COMPANY).build();

        Request request = new Request.Builder()
                .post(requestBody)
                .header("x-client-token", token)
                .url(URL + COMPANY)
                .build();

        Response response = client.newCall(request).execute();
        String jsonResponce = response.body().string();
        CreateNewCompanyResponse r = mapper.readValue(jsonResponce, CreateNewCompanyResponse.class);

        return r.id();
    }

    public List<Company> getAll(Boolean isActive) throws IOException {

        HttpUrl.Builder url = HttpUrl.parse(URL + COMPANY).newBuilder();

        if (isActive != null) {
            url.addQueryParameter("active", isActive.toString());
        }

        HttpUrl build = url.build();
        Request getAllCompanies = new Request.Builder()
                .url(build)
                .build();
        Response response = client.newCall(getAllCompanies).execute();
        CollectionType listOfCompanies = mapper.getTypeFactory().constructCollectionType(List.class, Company.class);
        return mapper.readValue(response.body().string(), listOfCompanies);
    }
/*
TODO // TODO // TODO //
 */

    public Company getById(int id) throws JacksonException {
        return mapper.readValue("", Company.class);
    }

    public Company deleteById(int id, String token) throws JacksonException {
        return mapper.readValue("", Company.class);
    }

    public Company setActive(int id, boolean active, String token) throws JacksonException {
        return mapper.readValue("", Company.class);
    }

    public Company updateCompany(int id, String name, String description, String token) throws JacksonException {
        return mapper.readValue("", Company.class);
    }
}