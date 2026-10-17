package com.example.carrito_compra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.carrito_compra.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
