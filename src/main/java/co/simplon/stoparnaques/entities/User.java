package co.simplon.stoparnaques.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User extends AbstractEntity {

    @Column(name = "username")
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password")
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "is_enabled")
    private boolean isEnabled;

    public User() {

    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
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

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public Role getRole() {
	return role;
    }

    public void setRole(Role role) {
	this.role = role;
    }

    public boolean getIsEnabled() {
	return isEnabled;
    }

    public void setIsEnabled(boolean isEnabled) {
	this.isEnabled = isEnabled;
    }

    @Override
    public String toString() {
	return "{username=" + username + ", firstName="
		+ firstName + ", lastName=" + lastName
		+ ", password=" + password + ", role="
		+ role + ", isEnabled=" + isEnabled + "}";
    }

    @Override
    public int hashCode() {
	return Objects.hash(username);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	return obj instanceof User other
		&& Objects.equals(username, other.username);
    }

}
