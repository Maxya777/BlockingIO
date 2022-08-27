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

                int number;

                while (true) {
                    System.out.println("Введите число: ");
                    number = scanner.nextInt();
                    out.println(number);
                    if (number == 0) {
                        break;
                    }
                    System.out.println("SERVER: " + in.read());
                }
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
