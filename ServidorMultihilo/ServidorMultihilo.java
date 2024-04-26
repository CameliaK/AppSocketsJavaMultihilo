package ServidorMultihilo;

import java.io.IOException;
import java.net.ServerSocket;

public class ServidorMultihilo{

    public static void main(String[] args) {
        
        int puerto = 8080;
        int cont = 0;

        try (ServerSocket ss = new ServerSocket(puerto)) {

            System.out.println("Servidor escuchando en el puerto: " + puerto + "...");
            while (true) {
                cont++;
                HiloHandler cliente = new HiloHandler(ss.accept(), cont);
                Thread h1 = new Thread(cliente);
                h1.start();
            }
        } catch(IOException ex) {
            System.out.println(ex);
        }
    }
}


