package hackathon.nttdata.coderpath.preguntas.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import hackathon.nttdata.coderpath.preguntas.documents.Preguntas;

@Repository
public interface PreguntaRepository extends ReactiveMongoRepository<Preguntas, String> {

}
