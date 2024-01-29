package Rummy.DataStructures;

import lombok.Data;

//GAME MODE MOVEMENTS:
//P->S Join lobby
//P->S, S->P Start game, finish game
//IN-GAME
//P->S Make Move
//S->P Move made (next_player, board_state)
//ERROR



@Data
public class WebsocketMessage {

    private final Player fromPlayer;

}
