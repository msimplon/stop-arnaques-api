package co.simplon.stoparnaques.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "forms")
public class Form extends AbstractEntity {

    @Column(name = "subject")
    private String subject;

    @Column(name = "email")
    private String email;

    @Column(name = "incident_reference")
    private String incidentReference;

    @Column(name = "attachement")
    private String attachement;

    @Column(name = "details")
    private String details;

    @ManyToOne
    @JoinColumn(name = "dispute_id")
    private Dispute dispute;

    public Form() {

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

    public String getAttachement() {
	return attachement;
    }

    public void setAttachement(String attachement) {
	this.attachement = attachement;
    }

    public Dispute getDispute() {
	return dispute;
    }

    public void setDispute(Dispute dispute) {
	this.dispute = dispute;
    }

    public String getDetails() {
	return details;
    }

    public void setDetails(String details) {
	this.details = details;
    }

    @Override
    public String toString() {
	return "{subject=" + subject + ", email=" + email
		+ ", incidentReference=" + incidentReference
		+ ", attachement=" + attachement
		+ ", details=" + details + ", dispute="
		+ dispute + "}";
    }

}
