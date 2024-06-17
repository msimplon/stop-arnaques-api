package co.simplon.stoparnaques.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.stoparnaques.dtos.DisputeView;
import co.simplon.stoparnaques.entities.Dispute;

@Repository
public interface DisputeRepository
	extends JpaRepository<Dispute, Long> {

    List<DisputeView> findAllProjectedBy();

}
