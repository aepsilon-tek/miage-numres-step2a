package org.aepsilon.dto;

import org.aepsilon.orm.Proposal;

public class ProposalDto {
    public Long id;
    public String label;
    public QuestionDto question;

    public ProposalDto(Proposal p) {
        this.id = p.id;
        this.label = p.label; // Utilise directement le label en français
        this.question = null; // Supprimez ou adaptez si nécessaire
    }
}