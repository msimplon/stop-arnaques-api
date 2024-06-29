package co.simplon.stoparnaques.dtos;

import org.springframework.web.multipart.MultipartFile;

import co.simplon.stoparnaques.validators.ImageSize;
import co.simplon.stoparnaques.validators.ImageType;
import jakarta.validation.constraints.NotNull;

public class FormCreate {

    @NotNull
    private String subject;
    @NotNull
    private String email;
    @NotNull
    private String incidentReference;

    @ImageType
    @ImageSize(maxValue = 2097122252L)
    @NotNull
    private MultipartFile attachement;

    @NotNull
    private String details;

    @NotNull
    private Long disputeId;

    public FormCreate() {

    }

    public String getSubject() {
	return subject;
    }

    public void setSubject(String subject) {
	this.subject = subject;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getIncidentReference() {
	return incidentReference;
    }

    public void setIncidentReference(
	    String incidentReference) {
	this.incidentReference = incidentReference;
    }

    public MultipartFile getAttachement() {
	return attachement;
    }

    public void setAttachement(MultipartFile attachement) {
	this.attachement = attachement;
    }

    public Long getDisputeId() {
	return disputeId;
    }

    public void setDisputeId(Long disputeId) {
	this.disputeId = disputeId;
    }

    public String getDetails() {
	return details;
    }

    public void setDetails(String details) {
	this.details = details;
    }

}
