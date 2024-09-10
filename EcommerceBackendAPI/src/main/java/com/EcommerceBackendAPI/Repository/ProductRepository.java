package com.EcommerceBackendAPI.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EcommerceBackendAPI.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	// Retrieve data by Product Name
	List<Product> findByName(String name);
}
