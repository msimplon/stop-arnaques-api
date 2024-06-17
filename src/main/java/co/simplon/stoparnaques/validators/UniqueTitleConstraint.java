package co.simplon.stoparnaques.validators;

import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.auth0.jwt.interfaces.Payload;

import jakarta.validation.Constraint;
import jakarta.validation.constraints.NotNull;

@Constraint(validatedBy = UniqueTitleValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(FIELD)
@Documented
@NotNull
public @interface UniqueTitleConstraint {
    String message() default "Ce titre existe déjà poto";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
