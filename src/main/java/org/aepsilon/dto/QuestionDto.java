package org.aepsilon.dto;

import org.aepsilon.orm.Question;

public class QuestionDto {
    public Long id;
    public String label;
    public CategoryDto category;

    public QuestionDto(Question q) {
        this.id = q.id;
        this.label = q.label; // Utilise directement le libellé en français
        this.category = new CategoryDto(q.category);
    }
}