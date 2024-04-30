import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    public void ConvertirMoneda (String monedaInicial,String monedaDestino , int cantidad) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String direccion = "https://v6.exchangerate-api.com/v6/50fc8dee0dcfeb2ee0f9b43c/latest/USD";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        String jsonResponse = response.body();
        JsonObject json = gson.fromJson(jsonResponse, JsonObject.class);
        JsonObject rates = json.getAsJsonObject("conversion_rates");

        double tasaDeConversionDestino = rates.get(monedaDestino).getAsDouble();
        double cantidadConvertida = cantidad * tasaDeConversionDestino;


        System.out.println(cantidad + " " + monedaInicial + " equivale a " + cantidadConvertida + " " + monedaDestino);
    }
}

