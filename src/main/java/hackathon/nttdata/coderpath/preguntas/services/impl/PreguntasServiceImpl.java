package hackathon.nttdata.coderpath.preguntas.services.impl;

import static org.springframework.http.MediaType.*;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.google.common.collect.Maps;

import hackathon.nttdata.coderpath.preguntas.config.ApplicationConfiguration;
import hackathon.nttdata.coderpath.preguntas.documents.Preguntas;
import hackathon.nttdata.coderpath.preguntas.documents.dtowebclient.Examen;
import hackathon.nttdata.coderpath.preguntas.documents.dtowebclient.Respuesta;
import hackathon.nttdata.coderpath.preguntas.repository.PreguntaRepository;
import hackathon.nttdata.coderpath.preguntas.services.PreguntasServices;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class PreguntasServiceImpl implements PreguntasServices{
	private final PreguntaRepository preguntaRepository;
	private final ApplicationConfiguration configuration;
	
	@Autowired
	private WebClient client;
	
	final String urlServerExamen = "http://localhost:8090/api/examenes";
	private WebClient webClientexamen = WebClient.create(urlServerExamen);
	
	private Mono<Respuesta> getRespuestaById(String id){
		Mono<Respuesta> respuesta = 
				
				client.get().uri("/id/{id}", id).retrieve().bodyToMono(Respuesta.class);
		return respuesta;
	}
	
	public Mono<ServerResponse> getOneRespuesta(ServerRequest request, String idx){
		
		String id = request.pathVariable(idx);
		
		return this.findRespuestaById(id).flatMap(c -> ServerResponse.ok().contentType(APPLICATION_JSON_UTF8).syncBody(c)
				.switchIfEmpty(ServerResponse.notFound().build()));
	}
	
	
	
	private Mono<Examen> getExamenById(String id){
		Mono<Examen> examen = 
				webClientexamen.get().uri("/id/{id}", id).retrieve().bodyToMono(Examen.class);
		return examen;			
		
	}
	
	
	@Override
	public Mono<Preguntas> findById(String id) {
		// TODO Auto-generated method stub
		return preguntaRepository.findById(id);
	}
	

	@Override
	public Flux<Preguntas> findAlls() {
		// TODO Auto-generated method stub
		return preguntaRepository.findAll();
	}

	@Override
	public Mono<Preguntas> saves(Preguntas document) {
		// TODO Auto-generated method stub
		return preguntaRepository.save(document);
	}

	@Override
	public Mono<Void> delete(Preguntas document) {
		// TODO Auto-generated method stub
		return preguntaRepository.delete(document);
	}

	@Override
	public Map<String, Object> balanceadorTest() {
		// TODO Auto-generated method stub
		Map<String, Object> response = Maps.newHashMap();
		response.put("balanceador", configuration.getBalanceadorTest());
		response.put("preguntas_asset", findAlls());
		return response;
	}
	


	

	@Override
	public Map<String, Object> rutaWebClientTest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<Respuesta> findRespuesta() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Mono<Respuesta> findRespuestaById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Respuesta> saveRespuesta(Respuesta document) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Respuesta> updateRespuesta(Respuesta document, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> deleteRespuesta(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Preguntas> savePreguntasRespuesta(Preguntas document, String respuestaid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<Examen> findAllExamen() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Examen> findExamenesById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Examen> saveExamenes(Examen document) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Examen> updateExamenes(Examen document, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> deleteExamenes(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Preguntas> saveCursoExamenes(Preguntas document, String examenId) {
		// TODO Auto-generated method stub
		return null;
	}

}
