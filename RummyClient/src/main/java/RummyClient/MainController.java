package RummyClient;

import RummyClient.Communication.Constants;
import RummyClient.Communication.Models.LobbyModel;
import RummyClient.Communication.WebsocketClient;
import RummyClient.Communication.WebsocketService;
import commons.ExampleWebsocketMessage;
import commons.Player;
import commons.WebsocketMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;

public class MainController {

    private WebsocketClient client;
    private LinkedBlockingQueue<WebsocketMessage> messages;

    public MainController() {
        client = null;
    }

    /**
     * Joins a lobby and initializes a websocket connection with the server
     */
    public LobbyModel joinLobby(String ip, String username) {
        messages = new LinkedBlockingQueue<WebsocketMessage>();
        client = WebsocketService.initializeConnection(ip, Constants.WEBSOCKET_PORT, messages);
        Constants.SERVER_IP = ip;
        beginMessageHandling();
        WebsocketMessage mess  = new ExampleWebsocketMessage(new Player(username));
        WebsocketService.sendMessage(client, mess);
        return null;
    }

    public void beginMessageHandling() {
        Thread messageHandling = new Thread() {
            public void run(){
                while(true){
                    try{
                        Object message = messages.take();
                        System.out.println("Message Received: " + message);
                        // TODO: Actual message handling
                    }
                    catch(InterruptedException e){

                    }
                }
            }
        };

        messageHandling.start();
    }

}
