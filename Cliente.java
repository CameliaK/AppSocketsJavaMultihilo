import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        
        int puerto = 8080;

        try {
            Socket cs = new Socket("localhost", puerto);
            PrintWriter out = new PrintWriter(cs.getOutputStream(), true);

            BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));

            String linearecibida;

            while (!(linearecibida = in.readLine()).equalsIgnoreCase("EOF")) {
                System.out.println("Servidor: " + linearecibida);
            }

            out.println("Recepción de datos correcta...");

            out.close();
            in.close();
            cs.close();

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
