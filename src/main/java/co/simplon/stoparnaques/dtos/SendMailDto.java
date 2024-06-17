package co.simplon.stoparnaques.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class SendMailDto {

    @NotBlank
    @Email
    private String primaryRecipient;

    @Email
    private String sender;

    @NotBlank
    @Pattern(regexp = "[a-zA-Z0-9\\s]+")
    @Size(min = 1, max = 100)
    private String subject;

    @NotBlank
    @Size(min = 1, max = 1000000)
    private String body;

    public String getPrimaryRecipient() {
	return primaryRecipient;
    }

    public void setPrimaryRecipient(
	    String primaryRecipient) {
	this.primaryRecipient = primaryRecipient;
    }

    public String getSender() {
	return sender;
    }

    public void setSender(String sender) {
	this.sender = sender;
    }

    public String getSubject() {
	return subject;
    }

    public void setSubject(String subject) {
	this.subject = subject;
    }

    public String getBody() {
	return body;
    }

    public void setBody(String body) {
	this.body = body;
    }

    @Override
    public String toString() {
	return "{primaryRecipient=" + primaryRecipient
		+ ", sender=" + sender + ", subject="
		+ subject + ", body=" + body + "}";
    }

}
