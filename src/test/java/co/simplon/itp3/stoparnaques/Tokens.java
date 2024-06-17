package co.simplon.itp3.stoparnaques;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
class Tokens {

    @Value("${stoparnaques.tests.fake-token}")
    private String fake;

    @Value("${stoparnaques.tests.bad-secret-token}")
    private String badSecret;

    @Value("${stoparnaques.tests.bad-issuer-token}")
    private String badIssuer;

    @Value("${stoparnaques.tests.security.jwt.expiration}")
    private String expired;

    @Value("${stoparnaques.tests.valid-admin-token}")
    private String admin;

    String get(final String name) {
	switch (name) {
	case "fake":
	    return fake;
	case "badSecret":
	    return badSecret;
	case "badIssuer":
	    return badIssuer;
	case "expired":
	    return expired;
	case "admin":
	    return admin;
	default:
	    throw new IllegalArgumentException(
		    "Unexpected value: " + name);
	}
    }

}