package service;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.HashMap;

public class ApiService {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/5eeb0a36e9f5fafccf84847f/latest/USD";

    public Map<String, Double> obtenerTasas() {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            InputStreamReader reader = new InputStreamReader(con.getInputStream());
            JsonObject json = JsonParser.parseReader(reader).getAsJsonObject();
            JsonObject tasasJson = json.getAsJsonObject("conversion_rates");

            Map<String, Double> tasas = new HashMap<>();
            tasasJson.entrySet().forEach(entry ->
                    tasas.put(entry.getKey(), entry.getValue().getAsDouble())
            );
            return tasas;
        } catch (Exception e) {
            System.out.println("Error al obtener tasas: " + e.getMessage());
            return new HashMap<>();
        }
    }
}
