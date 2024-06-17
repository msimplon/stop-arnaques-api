package co.simplon.stoparnaques.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.stoparnaques.entities.Form;

@Repository
public interface FormRepository
	extends JpaRepository<Form, Long> {

    Optional<Form> findProjectedById(Long id);

    List<Form> findAllProjectedBy();
}
