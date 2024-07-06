package com.example.CrudExample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CrudExample.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>
{
	Product findByname(String name);
}
