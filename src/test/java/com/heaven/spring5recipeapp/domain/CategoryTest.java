package com.heaven.spring5recipeapp.domain;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {
    private Category category;

    @BeforeEach
    public void setUp(){
        category = new Category();
    }
    @Test
    void getId() {
        category.setId(3L);
        assertEquals(3L,category.getId());
    }

}