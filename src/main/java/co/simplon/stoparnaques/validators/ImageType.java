package co.simplon.stoparnaques.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.auth0.jwt.interfaces.Payload;

import jakarta.validation.Constraint;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Constraint(validatedBy = ImageTypeValidator.class)
public @interface ImageType {

    String message() default "Le format de l'image est invalide";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}