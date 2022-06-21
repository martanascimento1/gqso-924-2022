import static java.net.HttpURLConnection.HTTP_OK;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class Subtracao implements HttpHandler {
    public static final String PATH = "/sub";

    @Override
    public void handle(HttpExchange conn) throws IOException {
        String[] partes = conn.getRequestURI().getPath().split("/");

        String parametro = partes[3];
        String parametro1 = partes[4];
        byte[] result = calculateResponse(parametro, parametro1);

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

    byte[] calculateResponse(String parametro, String parametro1) {
        double pDouble = Double.parseDouble(parametro);
        double pDouble2 = Double.parseDouble(parametro1);

        double subtracao = (pDouble - pDouble2);

        return Double.toString(subtracao).getBytes();
    }
}    