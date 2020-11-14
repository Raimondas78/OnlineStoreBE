package org.finalproject.onlinestore.repository;


import org.finalproject.onlinestore.entity.Category;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Override
    List<Category> findAll();
    List<Category> findAllById(long id);

    @Modifying
    @Query("FROM Category WHERE parent_Id = 0")
    List<Category> getParentCategories();


}
