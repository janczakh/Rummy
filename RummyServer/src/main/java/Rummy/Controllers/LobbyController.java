package Rummy.Controllers;

import Rummy.DataStructures.LobbyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/lobby")
public class LobbyController {

    /**
     * Instantiates a new LobbyController.
     */
    @Autowired
    public LobbyController() {
    }

    /**
     * Test method to check connection with server
     */
    @GetMapping("/test/{username}")
    public int getMembership(@PathVariable String username) {
//        LobbyModel lobby = new LobbyModel();
//        lobby.setPlayerList(List.of(username));
//        return lobby;
        return 21;
    }
}