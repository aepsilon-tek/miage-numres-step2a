package org.aepsilon.dto;

import org.aepsilon.orm.Category;

public class CategoryDto {
    public String label;

    public CategoryDto(Category c) {
        this.label = c.label; // Utilise directement le label en français
    }
}