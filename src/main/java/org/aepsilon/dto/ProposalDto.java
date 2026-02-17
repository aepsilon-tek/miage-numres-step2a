package org.aepsilon.dto;

import java.util.ArrayList;
import java.util.List;

public class ProposalDto {
    public Long id;
    public List<TranslationDto> translations;

    public QuestionDto question;

    public ProposalDto(){}

    public ProposalDto(Long id, String label, String lg){
        this.id = id;
        translations =  new ArrayList<>();
        translations.add(new TranslationDto(label,lg));
    }
}
