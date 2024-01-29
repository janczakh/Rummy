package Rummy.Websockets;

import Rummy.DataStructures.WebsocketMessage;
import Rummy.Services.WebsocketService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Server {
    private ArrayList<ConnectionToClient> clientList;
    private LinkedBlockingQueue<WebsocketMessage> messages;
    private ServerSocket serverSocket;

    public Server(int port) {
        clientList = new ArrayList<ConnectionToClient>();
        messages = new LinkedBlockingQueue<WebsocketMessage>();
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread accept = new Thread() {
            public void run(){
                while(true){
                    try{
                        Socket s = serverSocket.accept();
                        clientList.add(new ConnectionToClient(s));
                        System.out.println("Client connected");
                    }
                    catch(IOException e){ e.printStackTrace(); }
                }
            }
        };

        accept.setDaemon(true);
        accept.start();

        Thread messageHandling = new Thread() {
            public void run(){
                while(true){
                    try{
                        WebsocketMessage message = messages.take();
                        WebsocketService.handleMessage(this.getParent(), message);
                        System.out.println("Message Received: " + message);
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };

        messageHandling.setDaemon(true);
        messageHandling.start();
    }

    private class ConnectionToClient {
        ObjectInputStream in;
        ObjectOutputStream out;
        Socket socket;

        ConnectionToClient(Socket socket) throws IOException {
            this.socket = socket;
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            Thread read = new Thread(){
                public void run(){
                    while(true){
                        try{
                            Object obj = in.readObject();
                            if (obj instanceof WebsocketMessage wm) {
                                messages.put(wm);
                            } else {
                                System.out.println("Received incorrect message type");
                            }

                        }
                        catch (SocketException e) {
                            break;
                        }
                        catch(IOException | ClassNotFoundException | InterruptedException e){ e.printStackTrace(); }
                    }
                }
            };

            read.setDaemon(true); // terminate when main ends
            read.start();
        }

        public void write(WebsocketMessage obj) {
            try{
                out.writeObject(obj);
            }
            catch(IOException e){ e.printStackTrace(); }
        }
    }

    public void sendToOne(int index, WebsocketMessage message)throws IndexOutOfBoundsException {
        clientList.get(index).write(message);
    }

    public void sendToAll(WebsocketMessage message){
        for(ConnectionToClient client : clientList)
            client.write(message);
    }

}