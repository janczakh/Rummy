package Rummy.Services;

import Rummy.DataStructures.WebsocketMessage;
import Rummy.Websockets.Server;

public class WebsocketService {

    public static void sendMessageToAll(Server server, WebsocketMessage message) {
        server.sendToAll(message);
    }

    //TODO: OVERLOAD WITH PLAYER USERNAME
    public static void sendMessage(Server server, int index, WebsocketMessage message) {
        server.sendToOne(index, message);
    }

    /**
     * Handles a message from the server and invokes correct responses
     */
    public static void handleMessage(Server server, WebsocketMessage wm) {
        System.out.println("Player joined");
        System.out.println(wm.getFromPlayer().getId());
    }

}
