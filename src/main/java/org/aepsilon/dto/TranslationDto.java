package org.aepsilon.dto;

import org.aepsilon.web.client.TranslateResponse;

public class TranslationDto {



    public String language;
    public String value;


    public TranslationDto(){}

    public TranslationDto(String value,String lg){
        language=lg;
        this.value = value;
    }

    public TranslationDto(TranslateResponse r, String lg){
        language=lg;
        value = r.getTranslatedText();
    }
}
