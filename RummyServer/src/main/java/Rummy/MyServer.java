package Rummy;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    public static void runSocket() {

        setUpServer(Integer.parseInt("34556"));
    }

    public static void setUpServer(int port){

        try {

            ServerSocket server = new ServerSocket(port);

            while(true){

                Socket client = server.accept();
                ClientHandler clientHandler = new ClientHandler(client);
                clientHandler.start();

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

class ClientHandler extends Thread{

    private Socket client;

    public ClientHandler(Socket client){
        this.client = client;
    }

    @Override
    public void run() {

        try {

            InputStream stream = client.getInputStream();
            byte[] data = new byte[20];
            stream.read(data);
            String result = new String(data);

            System.out.println(result);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}