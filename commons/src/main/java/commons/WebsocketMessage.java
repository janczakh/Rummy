package commons;

import lombok.Data;

import java.io.Serializable;

//GAME MODE MOVEMENTS:
//P->S Join lobby
//P->S, S->P Start game, finish game
//IN-GAME
//P->S Make Move
//S->P Move made (next_player, board_state)
//ERROR



@Data
public class WebsocketMessage implements Serializable {

    private final Player fromPlayer;

}
