package co.simplon.stoparnaques.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.stoparnaques.entities.VerificationToken;

@Repository
public interface VerificationTokenRepository
	extends JpaRepository<VerificationToken, Long> {

    VerificationToken findByToken(String confirmationToken);

}