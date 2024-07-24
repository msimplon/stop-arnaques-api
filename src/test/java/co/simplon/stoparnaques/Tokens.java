package co.simplon.stoparnaques;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
class Tokens {

    @Value("${stoparnaques.tests.bad-secret-token}")
    private String badSecret;

    @Value("${stoparnaques.tests.bad-issuer-token}")
    private String badIssuer;

    @Value("${stoparnaques.tests.valid-admin-token}")
    private String admin;

    @Value("${stoparnaques.tests.valid-user-token}")
    private String user;

    String get(final String name) {
	switch (name) {
	case "badSecret":
	    return badSecret;
	case "badIssuer":
	    return badIssuer;
	case "admin":
	    return admin;
	case "user":
	    return user;
	default:
	    throw new IllegalArgumentException(
		    "Unexpected value: " + name);
	}
    }

}