package hackathon.nttdata.coderpath.preguntas.services;

import java.util.Map;


import hackathon.nttdata.coderpath.preguntas.documents.Preguntas;
import hackathon.nttdata.coderpath.preguntas.documents.dtowebclient.Examen;
import hackathon.nttdata.coderpath.preguntas.documents.dtowebclient.Respuesta;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PreguntasServices {
	
	Mono<Preguntas> findById(String id);

	Flux<Preguntas> findAlls();

	Mono<Preguntas> saves(Preguntas document);

	Mono<Void> delete(Preguntas document);

	Map<String, Object> balanceadorTest();


	
	/*
	 * seccion WEBCLIENT
	 */
	
	
	Flux<Respuesta> findRespuesta();
	
	Mono<Respuesta> findRespuestaById(String id);
	
	Mono<Respuesta> saveRespuesta(Respuesta document);
	
	Mono<Respuesta> updateRespuesta(Respuesta document, String id);
	
	Mono<Void> deleteRespuesta(String id);
	
	
	/*con pregunta con respuesta*/
	Mono<Preguntas> savePreguntasRespuesta(Preguntas document, String respuestaid);

	
	/*
	 * seccion WEBCLIENT EXAMENES
	 */

	Flux<Examen> findAllExamen();

	Mono<Examen> findExamenesById(String id);

	Mono<Examen> saveExamenes(Examen document);

	Mono<Examen> updateExamenes(Examen document, String id);

	Mono<Void> deleteExamenes(String id);
	
	Map<String, Object> rutaWebClientTest();
	
	//con Examen y pregunta
		Mono<Preguntas> saveCursoExamenes(Preguntas document, String examenId);
	
	
}
