package co.simplon.stoparnaques.exceptions;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ControllerAdvice
	extends ResponseEntityExceptionHandler {

    protected ResponseEntity<Object> handleMethodArgumentNotValid(
	    MethodArgumentNotValidException ex,
	    HttpHeaders headers, HttpStatus status,
	    WebRequest request) {
	ValidationErrors errors = toValidationErrors(
		ex.getGlobalErrors(), ex.getFieldErrors());
	return handleExceptionInternal(ex, errors, headers,
		status, request);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    protected ResponseEntity<Object> handleDataIntegrityViolationException(
	    DataIntegrityViolationException ex,
	    WebRequest request) {
	Map<String, Object> body = new LinkedHashMap<>();
	body.put("timestamp", new Date());
	body.put("message",
		"OUPSS il s'est passé quelque chose....");
	body.put("status", HttpStatus.CONFLICT.value());
	return handleExceptionInternal(ex, body,
		new HttpHeaders(), HttpStatus.CONFLICT,
		request);
    }

    @ExceptionHandler(BadCredentialsException.class)
    protected ResponseEntity<Object> handleBadCredentialsException(
	    BadCredentialsException ex,
	    WebRequest request) {
	Map<String, Object> body = new LinkedHashMap<>();
	body.put("timestamp", new Date());
	body.put("message",
		"Erreur d'authentification : Accès non autorisé");
	body.put("status", HttpStatus.UNAUTHORIZED.value());
	return handleExceptionInternal(ex, body,
		new HttpHeaders(), HttpStatus.UNAUTHORIZED,
		request);
    }

    @ExceptionHandler(ForbiddenException.class)
    protected ResponseEntity<Object> handleForbiddenException(
	    BadCredentialsException ex,
	    WebRequest request) {
	Map<String, Object> body = new LinkedHashMap<>();
	body.put("timestamp", new Date());
	body.put("message", "Accès non autorisé");
	body.put("status", HttpStatus.FORBIDDEN.value());
	return handleExceptionInternal(ex, body,
		new HttpHeaders(), HttpStatus.FORBIDDEN,
		request);
    }

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<Object> handleResourceNotFoundException(
	    NotFoundException ex, WebRequest request) {

	Map<String, Object> body = new LinkedHashMap<>();
	body.put("timestamp", new Date());
	body.put("message",
		"Ressource non trouvée : La page demandée n'existe pas");
	body.put("status", HttpStatus.NOT_FOUND.value());

	return handleExceptionInternal(ex, body,
		new HttpHeaders(), HttpStatus.NOT_FOUND,
		request);
    }

    private static ValidationErrors toValidationErrors(
	    List<ObjectError> objectErrors,
	    List<FieldError> fieldErrors) {
	ValidationErrors errors = new ValidationErrors();
	objectErrors.forEach((e) -> errors
		.addGlobalError(e.getDefaultMessage()));
	fieldErrors.forEach((e) -> errors.addFieldError(
		e.getField(), e.getDefaultMessage()));
	return errors;
    }

}