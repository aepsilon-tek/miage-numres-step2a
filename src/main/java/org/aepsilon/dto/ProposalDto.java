package org.aepsilon.dto;

import org.aepsilon.orm.Proposal;

import java.util.ArrayList;
import java.util.List;

public class ProposalDto {
    public Long id;
    public String label; // Texte de la proposition
    public boolean correct;

    public ProposalDto() {}

    public ProposalDto(Proposal p, String lg) {
        this.id = p.id;
        this.label = p.label; // Récupération directe du texte
        this.correct = p.correct; // Inclure l'information correcte
    }

    // Getter pour id
    public Long getId() {
        return id;
    }

    // Getter pour correct
    public boolean isCorrect() {
        return correct;
    }
}
