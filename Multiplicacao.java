import static java.net.HttpURLConnection.HTTP_OK;
import java.io.IOException;
import java.io.OutputStream;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class Multiplicacao implements HttpHandler {
    public static final String PATH = "/mult";

    @Override
    public void handle(HttpExchange conn) throws IOException {
        String[] partes = conn.getRequestURI().getPath().split("/");
        String operador1 = partes[2]; // partes[2] = primeiro número digitado para multiplicar
        String operador2 = partes[3]; // parte [3] = segundo número digitado para multiplicar
        byte[] result = calculateResponse(operador1, operador2);

        try {
            conn.sendResponseHeaders(HTTP_OK, result.length);
            Headers headers = conn.getResponseHeaders();
            headers.add("Content-Type", "text/html; charset=UTF-8");
            try (OutputStream out = conn.getResponseBody()) {
                out.write(result);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }
    byte[] calculateResponse(String operador1, String operador2) {
        double numero1 = Double.parseDouble(operador1);
        double numero2 = Double.parseDouble(operador2);
        double mult = (numero1 * numero2);
        return Double.toString(mult).getBytes();
    }
}
