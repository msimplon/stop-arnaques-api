package co.simplon.stoparnaques.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.stoparnaques.dtos.UserProfile;
import co.simplon.stoparnaques.entities.User;

@Repository
public interface UserRepository
	extends JpaRepository<User, Long> {
    UserProfile getUserById(Long id);

    User findByUsername(String username);
}
