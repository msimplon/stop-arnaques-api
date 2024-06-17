
package co.simplon.stoparnaques.services;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.stoparnaques.dtos.DisputeView;
import co.simplon.stoparnaques.repositories.DisputeRepository;

@Service
public class DisputeServiceImpl implements DisputeService {

    private final DisputeRepository disputes;

    public DisputeServiceImpl(DisputeRepository disputes) {
	this.disputes = disputes;
    }

    @Override
    public List<DisputeView> findAll() {
	return disputes.findAllProjectedBy();
    }
}
