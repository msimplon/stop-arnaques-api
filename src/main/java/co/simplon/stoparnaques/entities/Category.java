package co.simplon.stoparnaques.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Category extends AbstractEntity {

    @Column(name = "name")
    private String name;

    public Category() {

    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

}
