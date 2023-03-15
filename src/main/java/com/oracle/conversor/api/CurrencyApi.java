package com.oracle.conversor.api;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;
//import com.fasterxml.jackson.databind.ObjectMapper;

public class CurrencyApi {

    private static final String API_BASE_URL = "https://api.apilayer.com/currency_data";
    private String apiKey;

    public CurrencyApi () throws IOException {
        Properties properties = new Properties();
        InputStream entry = new FileInputStream(".properties");
        properties.load(entry);
        apiKey = properties.getProperty("currency_key");
    }

    public void getListCurrency() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(API_BASE_URL+"/list"))
                .GET()
                .header("apiKey", apiKey)
                .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        //ObjectMapper
        String responseBody = httpResponse.body();
        System.out.println(responseBody);
    }
}
