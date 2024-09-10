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

import com.EcommerceBackendAPI.Entity.Cart;
import com.EcommerceBackendAPI.Service.CartService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Cart")
public class CartController {

	@Autowired
	private CartService service;

	@PostMapping("/addCart")
	@Description("Add Item to Cart")
	@ApiResponse(responseCode = "200", description = "Add Cart Successfully")
	public Cart addCart(@RequestBody Cart card) {
		return service.saveCart(card);
	}

	@GetMapping("/getAllCart")
	@Description("Get All Cart Items")
	public List<Cart> findAllCart() {
		return service.getCarts();
	}

	@PutMapping("/updateCart")
	@Description("Update Item to Cart")
	@ApiResponse(responseCode = "200", description = "Update Cart Successfully")
	public Cart updateCart(@RequestBody Cart cart) {
		return service.updateCart(cart);
	}

	@DeleteMapping("/deleteCart/{Id}")
	@Description("Remove Item from Cart")
	@ApiResponse(responseCode = "200", description = "Delete Cart Successfully")
	public String deleteCart(@PathVariable int Id) {
		return service.deleteCart(Id);
	}
}
