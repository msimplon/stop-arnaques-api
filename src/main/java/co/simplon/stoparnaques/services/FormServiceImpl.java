package co.simplon.stoparnaques.services;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import co.simplon.stoparnaques.dtos.FormCreate;
import co.simplon.stoparnaques.entities.Dispute;
import co.simplon.stoparnaques.entities.Form;
import co.simplon.stoparnaques.repositories.DisputeRepository;
import co.simplon.stoparnaques.repositories.FormRepository;

@Service
@Transactional(readOnly = true)
public class FormServiceImpl implements FormService {

    private final FormRepository repo;

    private final DisputeRepository disputes;

    @Value("${stoparnaques-api.uploads.location}")
    private String uploadDir;

    public FormServiceImpl(FormRepository repo,
	    DisputeRepository disputes) {
	this.repo = repo;
	this.disputes = disputes;

    }

    @Override
    public List<Form> getAllForm() {
	return repo.findAllProjectedBy();
    }

    @Override
    @Transactional(readOnly = false)
    public void createForm(FormCreate inputs) {
	Form form = new Form();
	form.setSubject(inputs.getSubject());
	form.setEmail(inputs.getEmail());
	form.setIncidentReference(
		inputs.getIncidentReference());
	form.setDetails(inputs.getDetails());

	if ((inputs.getAttachement() != null)) {
	    MultipartFile file = inputs.getAttachement();
	    String baseName = UUID.randomUUID().toString();
	    String imageName = baseName + inputs
		    .getAttachement().getOriginalFilename();
	    form.setAttachement(imageName);
	    store(file, imageName);
	}

	Dispute dispute = disputes
		.getById(inputs.getDisputeId());
	form.setDispute(dispute);
	repo.save(form);
    }

    private void store(MultipartFile file,
	    String fileName) {
	Path uploadPath = Paths.get(uploadDir);
	Path target = uploadPath.resolve(fileName);
	try (InputStream in = file.getInputStream()) {
	    Files.copy(in, target,
		    StandardCopyOption.REPLACE_EXISTING);
	} catch (IOException ex) {
	    throw new RuntimeException(ex);
	}

    }

    @Override
    public Form findProjectedById(Long id) {
	return repo.findProjectedById(id).get();
    }
}
