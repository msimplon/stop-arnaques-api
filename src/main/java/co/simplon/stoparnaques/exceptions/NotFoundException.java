package co.simplon.stoparnaques.exceptions;

@SuppressWarnings("serial")
public final class NotFoundException
	extends RuntimeException {

    public NotFoundException(String message) {
	super("page non trouvée : " + message);
    }
}