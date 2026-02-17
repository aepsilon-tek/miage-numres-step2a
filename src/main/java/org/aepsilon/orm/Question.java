package org.aepsilon.orm;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.panache.common.Page;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.List;

@Entity
public class Question extends PanacheEntity {
    public String label;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CATEGORY_ID",nullable = false)
    public Category category;

    public static List<Question> findAllPaginated(int page, int size) {
        return findAll()
            .page(Page.of(page, size))
            .list();
    }

}