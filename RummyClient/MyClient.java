import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        String data = scanner.next();

        String data = "Hello";
        Socket client = connect("192.168.1.28",34556);

        message(client, data);
        message(client, data);
        message(client, data);


    }

    public static Socket connect(String ip, int port){

        Socket client;

        try {

            client = new Socket(ip,port);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return client;
    }

    public static void message(Socket client, String message){

        try {

            OutputStream stream = client.getOutputStream();
            byte[] data = message.getBytes();
            stream.write(data);

//            stream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        read(client);

    }

    public static void read(Socket client){

        try {

            InputStream stream = client.getInputStream();

            byte[] data = stream.readAllBytes();

            String result = new String(data);

            System.out.println("Server response : " + result);

//            stream.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}