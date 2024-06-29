package co.simplon.itp3.stoparnaques;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

// annotation qui veux dire qu'on veut démarer avec un serveur encapsuler et donc il va cibler pour faire des requetes HTTP mais il va pas démarrer tom cat donc il va demarer spring sans serveur web
@SpringBootTest
// faire des appels d'api = il va moquer donc simulluer 
@AutoConfigureMockMvc
//c'est pr lui dire d'aller chercher le application-test.properties
@ActiveProfiles(value = "test")
// pour preciper un ou plusieurs script.
//beforetestclasse = il va executer une seul fois le script.
@Sql(scripts = {
	"classpath:db/schema-tests.ddl.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_CLASS)
@Import(ControllerMocks.class)

//J-unit va allet instancier avant chaque appelle de methide un object de cette classe pour isoler les tests entre eux. 
//
class BaseMvcTests {

    protected static final char DELIMITER = '§';

    @Autowired
    private MockMvc mvc;

    @Autowired
    private Tokens tokens;

    protected final ResultActions perform(String method,
	    String path, String tokenName)
	    throws Exception {
	return perform(method, path, tokenName, null);
    }

//methode qui attends uen parametre un request builder qui va construire une requete avec nos spécification vers l'url et on va le condofurer commecimporte quel client HTPP mais il; va pas le faire il va faire un appek à un object
    // puisqu'en a moquer le sender
    // MAIS LE comportelent est le meme, ecrire perform
    protected final ResultActions perform(String method,
	    String path, String tokenName, String content)
	    throws Exception {
	var builder = requestBuilder(method, path,
		tokenName, content);
	return mvc.perform(builder);
    }

    private MockHttpServletRequestBuilder requestBuilder(
	    String method, String path, String tokenName,
	    String content) {
	var builder = request(HttpMethod.valueOf(method),
		path);
	if (!"anonymous".equals(tokenName)) {
	    builder.header("Authorization",
		    tokens.get(tokenName));
	}
	if (null != content) {
	    builder.contentType(MediaType.APPLICATION_JSON)
		    .content(content);
	}
	return builder;
    }

}