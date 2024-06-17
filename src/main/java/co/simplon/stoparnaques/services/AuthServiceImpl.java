package co.simplon.stoparnaques.services;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.stoparnaques.dtos.TokenInfo;
import co.simplon.stoparnaques.dtos.UserCreate;
import co.simplon.stoparnaques.entities.Role;
import co.simplon.stoparnaques.entities.User;
import co.simplon.stoparnaques.entities.VerificationToken;
import co.simplon.stoparnaques.repositories.AuthRepository;
import co.simplon.stoparnaques.repositories.RoleRepository;
import co.simplon.stoparnaques.repositories.UserRepository;
import co.simplon.stoparnaques.repositories.VerificationTokenRepository;
import co.simplon.stoparnaques.security.AuthHelper;

@Transactional(readOnly = true)
@Service
public class AuthServiceImpl implements AuthService {

    private final AuthHelper authHelper;
    private final AuthRepository authRepo;
    private final RoleRepository roleRepo;
    private final UserRepository users;
    private final VerificationTokenRepository tokenRepo;

    public AuthServiceImpl(
	    VerificationTokenRepository tokenRepo,
	    AuthHelper authHelper, AuthRepository authRepo,
	    RoleRepository roleRepo, UserRepository users) {
	this.authHelper = authHelper;
	this.authRepo = authRepo;
	this.roleRepo = roleRepo;
	this.users = users;
	this.tokenRepo = tokenRepo;
    }

    @Transactional
    @Override
    public void signUp(UserCreate inputs)
	    throws BadCredentialsException {

	String token = UUID.randomUUID().toString();

	VerificationToken verificationToken = new VerificationToken();
	verificationToken.setToken(token);

	User user = new User();
	user.setIsEnabled(false);
	user.setFirstName(inputs.getFirstName());
	user.setLastName(inputs.getLastName());
	String username = inputs.getUsername();
	user.setUsername(username);
	boolean userExists = authRepo
		.findByUsernameIgnoreCase(username)
		.isPresent();
	if (userExists) {
	    throw new IllegalArgumentException(
		    "Un utilisateur avec ce nom d'utilisateur existe déjà.");
	}

	String hashPassword = authHelper
		.encode(inputs.getPassword());
	user.setPassword(hashPassword);

	Role role = roleRepo
		.getReferenceByCode("ROLE_USER");
	user.setRole(role);

	authRepo.save(user);

	verificationToken.setUser(user);
	tokenRepo.save(verificationToken);

    }

    @Transactional
    @Override
    public TokenInfo signIn(UserCreate inputs)
	    throws BadCredentialsException {
	String identifier = inputs.getUsername();
	String candidate = inputs.getPassword();
	User user = authRepo
		.findByUsernameIgnoreCase(identifier)
		.orElseThrow(
			() -> new BadCredentialsException(
				String.format(
					"Échec de l'authentification. Veuillez vérifier vos informations d'identification (nom d'utilisateur et mot de passe) et réessayer.")));
	if (user != null) {
	    boolean match = authHelper.matches(candidate,
		    user.getPassword());
	    if (match) {
		String userId = Long.toString(user.getId());
		String email = user.getUsername();
		String role = user.getRole().getName();
		String token = authHelper.createJWT(role,
			userId, email);

		TokenInfo tokenInfo = new TokenInfo();
		tokenInfo.setToken(token);
		tokenInfo.setRole(role);
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		tokenInfo.setFirstName(firstName);
		tokenInfo.setLastName(lastName);

		return tokenInfo;
	    } else {
		throw new BadCredentialsException(
			"Wrong credentials");
	    }
	} else {
	    throw new BadCredentialsException(
		    "Wrong credentials");
	}

    }

    @Transactional
    @Override
    public void verifyUserRegistration(
	    String confirmationToken) {
	VerificationToken verifyToken = tokenRepo
		.findByToken(confirmationToken);
	if (verifyToken != null) {
	    LocalDateTime currentTime = LocalDateTime.now();
	    LocalDateTime expiresAt = verifyToken
		    .getExpiresAt();
	    if (currentTime.isBefore(expiresAt)) {
		User user = users.findByUsername(verifyToken
			.getUser().getUsername());
		user.setIsEnabled(true);
		users.save(user);
		tokenRepo.delete(verifyToken);
	    }

	}
    }

}
