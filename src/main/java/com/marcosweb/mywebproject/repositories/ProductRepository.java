package com.marcosweb.mywebproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcosweb.mywebproject.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
