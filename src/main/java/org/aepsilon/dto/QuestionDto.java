package org.aepsilon.dto;

import org.aepsilon.orm.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionDto {
    public Long id;

    public CategoryDto catgory;

    public QuestionDto(){}

    public QuestionDto(Question q,String lg){
        id = q.id;
    }
}
