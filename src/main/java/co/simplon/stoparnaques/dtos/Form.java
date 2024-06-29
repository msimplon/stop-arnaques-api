package co.simplon.stoparnaques.dtos;

import org.springframework.web.multipart.MultipartFile;

public interface Form {
    String subject();

    String email();

    String incidentReference();

    MultipartFile attachement();

    String detail();
}
