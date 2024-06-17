package co.simplon.stoparnaques.validators;

import co.simplon.stoparnaques.repositories.AuthRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueUserValidator implements
	ConstraintValidator<UniqueUserConstraint, String> {

    private final AuthRepository AuthRepo;

    public UniqueUserValidator(AuthRepository AuthRepo) {
	this.AuthRepo = AuthRepo;
    }

    @Override
    public boolean isValid(String username,
	    ConstraintValidatorContext context) {
	return (username != null) && !AuthRepo
		.findByUsernameIgnoreCase(username)
		.isPresent();

    }
}
