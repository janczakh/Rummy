package Rummy.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * LEGACY
 * Probably unnecessary, a basic HTTP setup
 * In case we decide to switch some comms to HTTP (higher reliability, but no server->client)
 * This is a basic setup to do that
 */
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
        return -1;
    }
}