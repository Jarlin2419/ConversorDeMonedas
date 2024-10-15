import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class ExchangeRateAPI {

    private static final String API_KEY = "1c0e7e3fdeedba876138e8b9"; // Tu clave API
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    // Método para obtener la tasa de cambio entre dos monedas
    public static double obtenerTasaDeCambio(String monedaBase, String monedaObjetivo) throws IOException, InterruptedException {
        String url = BASE_URL + monedaBase;

        // Crear cliente HTTP
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        // Enviar la solicitud y obtener la respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Procesar la respuesta JSON
        if (response.statusCode() == 200) {
            JSONObject json = new JSONObject(response.body());
            return json.getJSONObject("conversion_rates").getDouble(monedaObjetivo);
        } else {
            throw new IOException("Error al obtener la tasa de cambio. Código de estado: " + response.statusCode());
        }
    }
}


