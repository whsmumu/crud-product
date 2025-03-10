package com.example.crudone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.crudone.domain.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
}
