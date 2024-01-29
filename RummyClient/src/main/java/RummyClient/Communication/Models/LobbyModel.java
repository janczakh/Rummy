package RummyClient.Communication.Models;

import lombok.Data;

import java.util.List;

/**
 * Data structure with information sent by the server when a player successfully joins a lobby
 */
@Data
public class LobbyModel {

    // List of other players might be changed into a Player object
    // If we decide to add things like current score or avatars
    List<String> playerList; //List of other players

}
