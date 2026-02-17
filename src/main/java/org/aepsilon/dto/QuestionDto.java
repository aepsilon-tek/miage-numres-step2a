package org.aepsilon.dto;

import java.util.ArrayList;
import java.util.List;

public class QuestionDto {
    public Long id;
    public List<TranslationDto> translations;

    public CategoryDto catgory;

    public QuestionDto(){}

    public QuestionDto(Long id, String label, String lg){
        this.id = id;
        translations =  new ArrayList<>();
        translations.add(new TranslationDto(label,lg));
    }
}
