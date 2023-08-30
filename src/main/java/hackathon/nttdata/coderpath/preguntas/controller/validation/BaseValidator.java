package hackathon.nttdata.coderpath.preguntas.controller.validation;

import reactor.core.publisher.Mono;

public interface BaseValidator <T> {
	
	Mono<T> validate(T t);

}
