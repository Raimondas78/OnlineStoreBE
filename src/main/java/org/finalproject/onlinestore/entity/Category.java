package org.finalproject.onlinestore.entity;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String name;

    @OneToMany(mappedBy = "parentCategory", orphanRemoval = true)
    private final Set<Category> subCategories = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="parent_id")
    private Category parentCategory;

    public Category() { }

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Category> getSubCategories() {
        return subCategories;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name+"}";
    }
}
