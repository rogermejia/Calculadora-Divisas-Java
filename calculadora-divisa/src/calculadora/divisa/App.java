/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora.divisa;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author ASUS
 */
class ExchangeRateResponse {
    String result;
    String base_code;
    String target_code;
    double conversion_rate;
    
}

public class App{

    private static double getExchangeRate(String fromCurrency, String toCurrency) {
    String apiKey = "51a8c14e1d19c519b6d109ae"; // Reemplaza con tu clave API
    String apiUrl = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + fromCurrency + "/" + toCurrency;

    try {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder content = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            connection.disconnect();

            // Convertir el JSON a un objeto Java usando Gson
            Gson gson = new Gson();
            ExchangeRateResponse exchangeRateResponse = gson.fromJson(content.toString(), ExchangeRateResponse.class);

            // Verificar si el resultado fue exitoso
            if ("success".equals(exchangeRateResponse.result)) {
                return exchangeRateResponse.conversion_rate;
            } else {
                System.out.println("Error: " + exchangeRateResponse.result);
            }
        } else {
            System.out.println("Error: no se pudo obtener una respuesta válida de la API. Código de respuesta: " + responseCode);
        }
    } catch (Exception e) {
        System.out.println("Error al obtener el tipo de cambio: " + e.getMessage());
    }
    return 0.0;
}
    
    public static double convertCurrency(String fromCurrency, String toCurrency, double amount) {
    double exchangeRate = getExchangeRate(fromCurrency, toCurrency);
    return amount * exchangeRate;
}
    
}