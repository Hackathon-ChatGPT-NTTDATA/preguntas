package hackathon.nttdata.coderpath.preguntas.services.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;

import hackathon.nttdata.coderpath.preguntas.config.ApplicationConfiguration;
import hackathon.nttdata.coderpath.preguntas.documents.Preguntas;
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
		response.put("cursos_asset", findAlls());
		return response;
	}

}
