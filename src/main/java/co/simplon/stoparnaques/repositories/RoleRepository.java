package co.simplon.stoparnaques.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.stoparnaques.entities.Role;

@Repository
public interface RoleRepository
	extends JpaRepository<Role, Long> {

    Role getReferenceByCode(String string);
}