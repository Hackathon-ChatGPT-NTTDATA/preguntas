package hackathon.nttdata.coderpath.preguntas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PreguntasApplication {

	public static void main(String[] args) {
		SpringApplication.run(PreguntasApplication.class, args);
	}

}
