package org.finalproject.onlinestore.entity;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String name;

    @OneToMany(mappedBy = "parentCategory", orphanRemoval = true)
    private final List<Category> subCategories = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="parent_id")
    private Category parentCategory;

    public Category() { }

    public Category(String name, Category parentCategory) {
        this.name = name;
        this.parentCategory = parentCategory;
    }
    public Category(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public Category(String name) {
        this.name = name;
    }

    public Category getParentCategory(Category parentCategory){
        return parentCategory;
    }

    public Category getParentCategory(){
        return parentCategory;
    }

    public String getName() {
        return name;
    }

    public List<Category> getSubCategories() {
        return subCategories;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name+"}";
    }
}
