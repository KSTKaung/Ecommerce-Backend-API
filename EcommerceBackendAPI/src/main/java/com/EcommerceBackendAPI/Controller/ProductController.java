package com.EcommerceBackendAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.EcommerceBackendAPI.Entity.Product;
import com.EcommerceBackendAPI.Service.ProductService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Product")
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping("/addProduct")
	@Description("Add Product")
	@ApiResponse(responseCode = "200", description = "Add Product Successfully")
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}

	@PostMapping("/addProducts")
	@Description("Create List of Products")
	@ApiResponse(responseCode = "200", description = "Add Products Successfully")
	public List<Product> addProducts(@RequestBody List<Product> products) {
		return service.saveProducts(products);
	}

	@GetMapping("/getAllProduct")
	@Description("Get All Products")
	public List<Product> findAllProduct() {
		return service.getProducts();
	}

	@GetMapping("/getProductbyID/{id}")
	@Description("Get Product By ID")
	public Product findProductbyName(@PathVariable int id) {
		return service.getProductById(id);
	}

	@GetMapping("/getProductbyName/{name}")
	@Description("Get Product By Name")
	public List<Product> findProductbyName(@PathVariable String name) {
		return service.getProductByName(name);
	}

	@PutMapping("/updateProduct")
	@Description("Update Product")
	@ApiResponse(responseCode = "200", description = "Update Product Successfully")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}

	@DeleteMapping("/deleteProduct/{Id}")
	@Description("Delete Product")
	@ApiResponse(responseCode = "200", description = "Delete Product Successfully")
	public String deleteProduct(@PathVariable int Id) {
		return service.deleteProduct(Id);
	}
}
