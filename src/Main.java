public class Main {

    public static void main(String[] args) {

        Thread server = new Server();
        Thread client = new Client();

        server.start();
        client.start();
    }
}
