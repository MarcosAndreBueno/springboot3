package com.marcosweb.mywebproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcosweb.mywebproject.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
