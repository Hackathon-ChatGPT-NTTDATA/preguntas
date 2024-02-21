package hackathon.nttdata.coderpath.preguntas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PreguntasApplication {

	public static void main(String[] args) {
		SpringApplication.run(PreguntasApplication.class, args);
	}

}
