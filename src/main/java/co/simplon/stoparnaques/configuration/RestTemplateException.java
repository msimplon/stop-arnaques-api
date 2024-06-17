package co.simplon.stoparnaques.configuration;

import java.util.Map;

//
//encapsuler les erreurs qui peuvent survenir lors de l'utilisation de RestTemplate dans une application Spring. 
//Elle est conçue pour contenir des informations sur l'erreur
//, telles que le code de statut HTTP de la réponse et le corps de la réponse associée.
//Par exemple, lorsqu'une requête HTTP échoue dans votre application Spring,
//vous pouvez lancer une instance de RestTemplateException en spécifiant le code de statut HTTP de la réponse
//et le corps de la réponse.

import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class RestTemplateException
	extends RuntimeException {

    private HttpStatus status;

    private Map<String, Object> body;

    public RestTemplateException(HttpStatus status,
	    Map<String, Object> body) {
	this.status = status;
	this.body = body;
    }

    public HttpStatus getStatus() {
	return status;
    }

    public Map<String, Object> getBody() {
	return body;
    }
}