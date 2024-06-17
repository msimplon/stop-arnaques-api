package co.simplon.stoparnaques.validators;

import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotNull;

@Constraint(validatedBy = UniqueUserValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(FIELD)
@Documented
@NotNull
public @interface UniqueUserConstraint {
    String message() default "Cette email existe déjà pour cette utilisateur poto";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
