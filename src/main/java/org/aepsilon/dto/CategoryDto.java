package org.aepsilon.dto;

import org.aepsilon.orm.Category;

public class CategoryDto {
    public Long id;
    public String label;

    public CategoryDto() {}

    public CategoryDto(Category c) {
        this.id = c.id;
        this.label = c.label;
    }
}