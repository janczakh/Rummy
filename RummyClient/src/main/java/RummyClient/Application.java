package RummyClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	private static transient LobbyController testController;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		new LobbyController().joinLobby("192.168.0.104", "nautik");
	}

}
