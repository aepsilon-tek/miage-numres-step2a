package org.aepsilon.dto;

import org.aepsilon.orm.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionDto {
    public Long id;
    public List<TranslationDto> translations;

    public CategoryDto catgory;

    public QuestionDto(){}

    public QuestionDto(Question q,String lg){
        id = q.id;
        translations =  new ArrayList<>();
        translations.add(new TranslationDto(q,lg));
    }
    // Getter et setter pour translations
    public List<TranslationDto> getTranslations() {
        return translations;
    }

    public void setTranslations(List<TranslationDto> translations) {
        this.translations = translations;
    }
    
}
