package co.simplon.stoparnaques.services;

import java.util.List;

import co.simplon.stoparnaques.dtos.FormCreate;
import co.simplon.stoparnaques.entities.Form;

public interface FormService {

    List<Form> getAllForm();

    void createForm(FormCreate form);

    Form findProjectedById(Long id);

}
