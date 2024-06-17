package co.simplon.stoparnaques.exceptions;

import java.util.Objects;

/**
 * 
 * @Depreciated
 *
 */

final class ValidationError {

    private final String code;

    /**
     * Creates a new {@code ValidationError} with given code.
     *
     * @param code a validation error code
     * @throws NullPointerException if {@code code} is {@code null}
     */
    ValidationError(String code) {
	Objects.requireNonNull(code, " cannot be null");
	this.code = code;
    }

    /**
     * Returns the code of this validation error.
     *
     * @return the code; never {@code null}
     */
    public String getCode() {
	return code;
    }

    @Override
    public String toString() {
	return String.format("{code=%s}", code);
    }
}