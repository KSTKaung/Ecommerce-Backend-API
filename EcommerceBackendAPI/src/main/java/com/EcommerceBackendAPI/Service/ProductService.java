package com.EcommerceBackendAPI.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EcommerceBackendAPI.Entity.Product;
import com.EcommerceBackendAPI.Repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	/*
	 * Save Product
	 */
	public Product saveProduct(Product product) {
		return repository.save(product);
	}

	/*
	 * Save All Products
	 */
	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
	}

	/*
	 * Get Products
	 */
	public List<Product> getProducts() {
		return repository.findAll();
	}

	/*
	 * Get Product By ID
	 */
	public Product getProductById(int id) {
		return repository.findById(id).orElse(null);
	}

	/*
	 * Get Products By Name
	 */
	public List<Product> getProductByName(String name) {
		return repository.findByName(name);
	}

	/*
	 * Delete Product
	 */
	public String deleteProduct(int id) {
		repository.deleteById(id);
		return "Product removed !! " + id;
	}

	/*
	 * Update Product
	 */
	public Product updateProduct(Product product) {
		Product existingProduct = repository.findById(product.getProductid()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setType(product.getType());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setStockquantity(product.getStockquantity());
		return repository.save(existingProduct);
	}
}
