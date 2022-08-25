package com.heaven.spring5recipeapp.repository;

import com.heaven.spring5recipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {
    Optional<Category> findByDescription(String desc);
}
