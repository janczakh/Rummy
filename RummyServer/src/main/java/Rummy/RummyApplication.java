package Rummy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class RummyApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(RummyApplication.class, args);
		MyServer.runSocket();
	}

}
