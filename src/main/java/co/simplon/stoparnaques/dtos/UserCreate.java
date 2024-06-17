package co.simplon.stoparnaques.dtos;

import co.simplon.stoparnaques.validators.UniqueUserConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserCreate {

    @NotBlank
    @Size(min = 2, max = 30)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 100)
    private String lastName;

    @NotBlank(message = "email_required")
    @UniqueUserConstraint
    private String username;

    @NotBlank(message = "password_required")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", message = "password_format")
    private String password;

    public UserCreate() {
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    @Override
    public String toString() {
	return String.format(
		"{firstName=%s, lastName=%s, email=%s, password=%s}",
		firstName, lastName, username,
		"{protected}");
    }
}