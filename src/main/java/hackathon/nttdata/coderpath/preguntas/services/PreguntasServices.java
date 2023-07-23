package hackathon.nttdata.coderpath.preguntas.services;

import java.util.Map;

import hackathon.nttdata.coderpath.preguntas.documents.Preguntas;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PreguntasServices {
	
	Mono<Preguntas> findById(String id);

	Flux<Preguntas> findAlls();

	Mono<Preguntas> saves(Preguntas document);

	Mono<Void> delete(Preguntas document);

	Map<String, Object> balanceadorTest();

}
