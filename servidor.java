import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

public class servidor {

    public static final int TAMANHO_BACKLOG = 100;

    public static void main(String[] args) throws IOException {

        InetSocketAddress bindAddr = new InetSocketAddress(3000);
        HttpServer server = HttpServer.create(bindAddr, TAMANHO_BACKLOG);
        server.setExecutor(Executors.newSingleThreadExecutor());

        server.createContext(multiplicacao.PATH, new multiplicacao());
        // server.createContext(.PATH, new );
        // server.createContext(.PATH, new );

        server.start();
        System.out.printf("Servidor ouvindo requisições na porta %s\n\n", server.getAddress().getPort());
    }
}