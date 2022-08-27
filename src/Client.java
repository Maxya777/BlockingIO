import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread {

    @Override
    public void run() {

        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 23444);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            assert socket != null;
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(
                         new OutputStreamWriter(socket.getOutputStream()), true);
                 Scanner scanner = new Scanner(System.in)) {

                while (true) {
                    System.out.println("Введите число: ");
                    int number = scanner.nextInt();
                    out.println(number);
                    System.out.println("SERVER: " + in.readLine());
                }
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
