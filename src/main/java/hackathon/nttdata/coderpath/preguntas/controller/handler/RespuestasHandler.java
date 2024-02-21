package hackathon.nttdata.coderpath.preguntas.controller.handler;

import static org.springframework.http.MediaType.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;


import hackathon.nttdata.coderpath.preguntas.controller.validation.ObjectValidator;
import hackathon.nttdata.coderpath.preguntas.documents.dtowebclient.Respuesta;
import hackathon.nttdata.coderpath.preguntas.services.PreguntasServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;


@Component
@Slf4j
@RequiredArgsConstructor

public class RespuestasHandler {
	
	
	private final ObjectValidator objectValidator;
	
	@Autowired
	private PreguntasServices service;
	
	
	public Mono<ServerResponse> listar(ServerRequest request){
		
		return ServerResponse
				.ok()
				.contentType(APPLICATION_JSON)
				.body(service.findRespuesta(), Respuesta.class);	
	}
		
	public Mono<ServerResponse> getOne(ServerRequest request) {

		String id = request.pathVariable("id");

		return service.findRespuestaById(id).flatMap(c -> ServerResponse
				.ok()
				.contentType(APPLICATION_JSON)
				.syncBody(c)
				.switchIfEmpty(ServerResponse.notFound()
				.build()));
	}
	
		  public Mono<ServerResponse> save(ServerRequest request) {
	        Mono<Respuesta> dtoMono = request.bodyToMono(Respuesta.class)
	        		.doOnNext(objectValidator::validate);
	        return dtoMono.flatMap(productDto -> ServerResponse
	        		.ok()
	        		.contentType(MediaType.APPLICATION_JSON)
	        		.body(service.saveRespuesta(productDto), Respuesta.class));
	    }
	  
	  
	  
	    public Mono<ServerResponse> update(ServerRequest request) {
	        String id = request.pathVariable("id");
	        Mono<Respuesta> dtoMono = request.bodyToMono(Respuesta.class)
	        		.doOnNext(objectValidator::validate);
	        return dtoMono.flatMap(c -> ServerResponse
	        		.ok()
	        		.contentType(MediaType.APPLICATION_JSON)
	        		.body(service.updateRespuesta(c, id), Respuesta.class));
	    }  
	    
	    public Mono<ServerResponse> delete(ServerRequest request) {
	    	String id = request.pathVariable("id");
	        return ServerResponse
	        		.ok()
	        		.contentType(MediaType.APPLICATION_JSON)
	        		.body(service.deleteRespuesta(id), Respuesta.class);
	    }	
	  
	  
	  

}
