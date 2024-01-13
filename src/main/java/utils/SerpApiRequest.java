package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class SerpApiRequest {

    private static final String SERP_API_BASE_URL = "https://serpapi.com/search";
    private static final String API_KEY = Config.API_KEY;

    public JsonNode realizarSolicitud(String query, String apiType, Map<String, String> parametrosAdicionales) {
        try {
            String url = construirUrl(apiType, query, parametrosAdicionales);

            // Declaración de registro
            System.out.println("Realizando solicitud a: " + url);

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            // Parsear la respuesta JSON con Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readTree(response.body());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String construirUrl(String apiType, String query, Map<String, String> parametrosAdicionales) {
        // Construir la URL base según el tipo de API
        String baseUrl;
        switch (apiType) {
            case "profile":
                baseUrl = SERP_API_BASE_URL + "?engine=google_scholar_profiles";
                break;
            case "author":
                baseUrl = SERP_API_BASE_URL + "?engine=google_scholar_author";
                break;
            default:
                throw new IllegalArgumentException("Tipo de API no válido: " + apiType);
        }

        // Agregar parámetros adicionales a la URL
        StringBuilder urlBuilder = new StringBuilder(baseUrl);

        // Construir la URL específica para Google Scholar
        urlBuilder.append("&api_key=").append(API_KEY);
        try {
            urlBuilder.append("&q=").append(URLEncoder.encode(query, "UTF-8"));
            // Agregar otros parámetros aquí
            if (parametrosAdicionales != null) {
                for (Map.Entry<String, String> entry : parametrosAdicionales.entrySet()) {
                    urlBuilder.append("&").append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // Devolver la URL construida
        return urlBuilder.toString();
    }
}
