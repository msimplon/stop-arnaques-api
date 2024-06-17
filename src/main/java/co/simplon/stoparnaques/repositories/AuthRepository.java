package co.simplon.stoparnaques.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.stoparnaques.entities.User;

@Repository
public interface AuthRepository
	extends JpaRepository<User, Long> {

    Optional<User> findByUsernameIgnoreCase(
	    String username);

//    User getByUsername(String identifier);

}
//
//token auth = authRepo.findByUsernameIgnoreCase(username)
//.orElseThrow(
//	() -> new BadCredentialsException(
//		String.format(
//			"Échec de l'authentification. Veuillez vérifier vos informations d'identification (nom d'utilisateur et mot de passe) et réessayer.")));
