package org.aepsilon.dto;

import org.aepsilon.orm.Question;


public class QuestionDto {
    public Long id;

    public CategoryDto catgory;

    public QuestionDto(){}

    public QuestionDto(Question q,String lg){
        id = q.id;
    }
}
