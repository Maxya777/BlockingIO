import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {

    @Override
    public void run() {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(23444);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                assert serverSocket != null;
                try (Socket socket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {

                    int number;

                    while ((number = in.read()) != 0); {
                        out.println("Число ряда Фибоначчи: " + fib(number));
                    }
                }
            } catch (IOException i) {
                i.printStackTrace(System.out);
            }
        }
    }

    public int fib(int n) {
        if(n == 1 || n == 0) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}

