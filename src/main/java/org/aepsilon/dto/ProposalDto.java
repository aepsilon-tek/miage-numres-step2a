package org.aepsilon.dto;

import org.aepsilon.orm.Proposal;


public class ProposalDto {
    public Long id;

    public QuestionDto question;

    public ProposalDto(){}

    public ProposalDto(Proposal p, String lg){
        id = p.id;

    }
}
