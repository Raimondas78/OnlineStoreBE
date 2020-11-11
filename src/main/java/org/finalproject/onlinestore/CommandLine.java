package org.finalproject.onlinestore;

import org.finalproject.onlinestore.entity.Category;
import org.finalproject.onlinestore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLine implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CommandLine(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("hello :)");

//        Category category1 = new Category("Dailė");
//        Category category2 = new Category("Medžio drožiniai");
//        Category category3 = new Category("Keramika");
//        Category category4 = new Category("Papuošalai");
//        Category category5 = new Category("Skulptūra");
//        Category category6 = new Category("Tekstilė");
//
//
//        categoryRepository.save(category1);
//        categoryRepository.save(category2);
//        categoryRepository.save(category3);
//        categoryRepository.save(category4);
//        categoryRepository.save(category5);
//        categoryRepository.save(category6);

    }

}

