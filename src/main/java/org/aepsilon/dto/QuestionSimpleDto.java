package org.aepsilon.dto;

public class QuestionSimpleDto {
    public Long id;
    public String value; // traduction en français par exemple

    public QuestionSimpleDto() {}

    public QuestionSimpleDto(Long id, String value) {
        this.id = id;
        this.value = value;
    }
}
