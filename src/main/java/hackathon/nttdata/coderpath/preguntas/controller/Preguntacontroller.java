package hackathon.nttdata.coderpath.preguntas.controller;

import java.util.Date;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hackathon.nttdata.coderpath.preguntas.documents.Preguntas;
import hackathon.nttdata.coderpath.preguntas.services.PreguntasServices;
import hackathon.nttdata.coderpath.preguntas.services.impl.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@RestController
@Slf4j
@RequiredArgsConstructor
//*@CrossOrigin({"*"})
//*@CrossOrigin({"http://localhost:4200"})
public class Preguntacontroller {
		private final PreguntasServices service;

	private final KafkaProducer producer;

	@PostMapping("/producer/{topic}")
	public ResponseEntity<Mono<?>> publishMessage(@PathVariable String topic, @Valid @RequestBody String message) {
		Mono.just(producer).doOnNext(t -> {

			t.publishMessage(topic, message);

		}).onErrorReturn(producer).onErrorResume(e -> Mono.just(producer))
				.onErrorMap(f -> new InterruptedException(f.getMessage())).subscribe(x -> log.info(x.toString()));

		Mono<String> pAsset = Mono.just(message);

		if (pAsset != null) {
			return new ResponseEntity<>(pAsset, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(Mono.just(new Preguntas()), HttpStatus.I_AM_A_TEAPOT);
	}

	@GetMapping("/balanceador-test")
	public ResponseEntity<?> balanceadorTest() {
		return ResponseEntity.ok(service.balanceadorTest());
	}

	@GetMapping("/all")
	public Flux<Preguntas> searchAll() {
		Flux<Preguntas> per = service.findAlls();
		log.info("PREGUNTA ASSET registered: " + per);
		return per;
	}

	@GetMapping("/id/{id}")
	public Mono<Preguntas> searchById(@PathVariable String id) {
		log.info("Preguntas Asset id: " + service.findById(id) + " con codigo: " + id);
		return service.findById(id);
	}

	@PostMapping("/create-preguntas")
	public Mono<Preguntas> createCursos(@Valid @RequestBody Preguntas preguntaAsset) {
		log.info("Preguntas hackathon NTTTDATA create: " + service.saves(preguntaAsset));
		Mono.just(preguntaAsset).doOnNext(t -> {

			t.setCreateAt(new Date());

		}).onErrorReturn(preguntaAsset).onErrorResume(e -> Mono.just(preguntaAsset))
				.onErrorMap(f -> new InterruptedException(f.getMessage())).subscribe(x -> log.info(x.toString()));

		Mono<Preguntas> newPersonalAsset = service.saves(preguntaAsset);

		return newPersonalAsset;
	}

	@PutMapping("/update-preguntas/{id}")
	public ResponseEntity<Mono<?>> updatePreguntasAsset(@PathVariable String id, 
			@Valid @RequestBody Preguntas preguntaAsset) {
		Mono.just(preguntaAsset).doOnNext(t -> {
			preguntaAsset.setId(id);
			t.setCreateAt(new Date());

		}).onErrorReturn(preguntaAsset).onErrorResume(e -> Mono.just(preguntaAsset))
				.onErrorMap(f -> new InterruptedException(f.getMessage())).subscribe(x -> log.info(x.toString()));

		Mono<Preguntas> pAsset = service.saves(preguntaAsset);

		if (pAsset != null) {
			return new ResponseEntity<>(pAsset, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(Mono.just(new Preguntas()), HttpStatus.I_AM_A_TEAPOT);
	}

	@DeleteMapping("/delete-preguntas/{id}")
	public ResponseEntity<Mono<Void>> deletePreguntasAsset(@PathVariable String id) {
		Preguntas PreguntasAsset = new Preguntas();
		PreguntasAsset.setId(id);
		Mono<Preguntas> newPersonalAsset = service.findById(id);
		newPersonalAsset.subscribe();
		Mono<Void> test = service.delete(PreguntasAsset);
		test.subscribe();
		return ResponseEntity.noContent().build();
	}

	
	
}
