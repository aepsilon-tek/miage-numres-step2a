package org.aepsilon.dto;

import org.aepsilon.orm.Category;
import org.aepsilon.orm.Proposal;

import java.util.ArrayList;
import java.util.List;

public class ProposalDto {
    public Long id;
    public List<TranslationDto> translations;

    public Long questionId;

    public ProposalDto(){}

    public ProposalDto(Proposal p, String lg){
        id = p.id;
        questionId = (p.question != null) ? p.question.id : null;
        
        translations =  new ArrayList<>();
        translations.add(new TranslationDto(p,lg));
    }
}
