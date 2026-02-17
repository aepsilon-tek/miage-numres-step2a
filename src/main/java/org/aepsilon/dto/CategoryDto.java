package org.aepsilon.dto;

import java.util.ArrayList;

public class CategoryDto {
    public List<TranslationDto> translations;


    public CategoryDto(){}

    public CategoryDto(String label,String lg){
        translations =  new ArrayList<>();
        translations.add(new TranslationDto(label,lg));
    }
}
