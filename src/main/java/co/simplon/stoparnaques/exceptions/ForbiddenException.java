package co.simplon.stoparnaques.exceptions;

@SuppressWarnings("serial")
public final class ForbiddenException
	extends RuntimeException {

    public ForbiddenException(String message) {
	super("accès interdit poto : " + message);
    }
}

// il manque le deuxieme argument 
