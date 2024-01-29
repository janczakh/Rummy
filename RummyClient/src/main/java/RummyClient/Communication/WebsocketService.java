package RummyClient.Communication;

import RummyClient.Communication.Models.LobbyModel;
import commons.WebsocketMessage;

import java.io.IOException;

public class WebsocketService {

    public static WebsocketClient initializeConnection(String ip, int port) {
        try {
            return new WebsocketClient(ip, port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sendMessage(WebsocketClient client, WebsocketMessage message) {
        client.send(message);}

    /**
     * Handles a message from the server and invokes correct responses
     */
    public static void handleMessage(WebsocketClient client, Object received) {
        if (received instanceof LobbyModel lm) {
            System.out.println("Successfully joined the lobby");
            System.out.println(lm);
        }
    }
}
