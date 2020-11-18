package org.finalproject.onlinestore.repository;

import org.finalproject.onlinestore.entity.Category;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Override
    List<Category> findAll();

    @Modifying
    @Query("FROM Category WHERE parent_id = ?1")
    List<Category> findAllById(long id);

    @Modifying
    @Query("FROM Category WHERE parent_id = null")
    List<Category> getParentCategories();

    @Modifying
    @Query("UPDATE Category SET parent_id = ?1 WHERE id = ?2")
    void updateSubcategoryByParentId(long parentId, long id);

    Category findCategoryByName(String name);

    @Modifying
    @Query("UPDATE Category SET name = ?1 WHERE id = ?2")
    void updateCategoryInfoById(String name, long id);


}
