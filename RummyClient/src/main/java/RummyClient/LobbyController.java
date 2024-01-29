package RummyClient;

import RummyClient.Communication.Constants;
import RummyClient.Communication.HTTPService;
import RummyClient.Communication.Models.LobbyModel;
import RummyClient.Communication.WebsocketClient;
import RummyClient.Communication.WebsocketService;
import commons.Player;
import commons.WebsocketMessage;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LobbyController {

    WebsocketClient client;

    @Autowired
    public LobbyController() {
        client = null;
    }

    /**
     * Joins a lobby and initializes a websocket connection with the server
     */
    public LobbyModel joinLobby(String ip, String username) {
        client = WebsocketService.initializeConnection(ip, Constants.WEBSOCKET_PORT);
        Constants.SERVER_IP = ip;
        WebsocketMessage mess  = new WebsocketMessage(new Player(username));
        WebsocketService.sendMessage(client, mess);
//        Response res = HTTPService.getRequest("/lobby/test/" + username);
//        int ress = res.readEntity(Integer.class);
//        System.out.println(ress);
        return null;
//        return lobby;
    }

}
