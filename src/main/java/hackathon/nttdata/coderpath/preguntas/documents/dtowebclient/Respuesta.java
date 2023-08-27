package hackathon.nttdata.coderpath.preguntas.documents.dtowebclient;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Respuesta {

	@Id
	private String id;

	private String texto;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createAt;

	List<Respuesta> respuesta;

}
