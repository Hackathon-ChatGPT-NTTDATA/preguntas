package hackathon.nttdata.coderpath.preguntas.services.respuetasconfig;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import hackathon.nttdata.coderpath.preguntas.controller.handler.RespuestasHandler;

public class RouterConfig {
	
	public RouterFunction<ServerResponse> rutas(RespuestasHandler handler){
	
		return route(GET("/webclient"), handler::listar)
        		.andRoute(GET("/webclient/{id}"), handler::getOne)
        		.andRoute(POST("/webclient/create-respuesta"), handler::save)
        		.andRoute(PUT("/webclient/update-respuestas/{id}"), handler::update) 
        		.andRoute(DELETE("/webclient/delete-respuestas/{id}"), handler::delete);
	
	}

	
	

}
