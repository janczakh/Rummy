package Rummy;

import Rummy.Websockets.Server;
import commons.WebsocketMessage;

import java.util.concurrent.LinkedBlockingQueue;

public class GameEngine {

    private Server websocketServer;
    private LinkedBlockingQueue<WebsocketMessage> messages;


    public GameEngine() {
        messages = new LinkedBlockingQueue<WebsocketMessage>();
        websocketServer = new Server(8090, messages);
        startMessageHandlingLoop();
    }

    public void startMessageHandlingLoop() {
        Thread messageHandling = new Thread() {
            public void run(){
                while(true){
                    try{
                        WebsocketMessage message = messages.take();
                        System.out.println("Message Received on the loopyloop: " + message);
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

}
