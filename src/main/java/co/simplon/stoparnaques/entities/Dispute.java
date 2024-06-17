package co.simplon.stoparnaques.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "disputes")
public class Dispute extends AbstractEntity {

    private String label;

    public Dispute() {
    }

    public String getLabel() {
	return label;
    }

    public void setLabel(String label) {
	this.label = label;
    }

}
