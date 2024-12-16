package org.aepsilon.orm;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase; // Import nécessaire
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Proposal extends PanacheEntityBase {
    @Id
    @GeneratedValue
    public Long id;

    public String label;
    public boolean correct;

    // Getter pour id
    public Long getId() {
        return id;
    }

    // Getter pour correct
    public boolean isCorrect() {
        return correct;
    }

    // Getter pour label (optionnel)
    public String getLabel() {
        return label;
    }
}
