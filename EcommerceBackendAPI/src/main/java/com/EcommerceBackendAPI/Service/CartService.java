package com.EcommerceBackendAPI.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EcommerceBackendAPI.Entity.Cart;
import com.EcommerceBackendAPI.Repository.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository repository;

	/*
	 * Save Items to Cart
	 */
	public Cart saveCart(Cart cart) {
		return repository.save(cart);
	}

	/*
	 * Get All Items to Cart
	 */
	public List<Cart> getCarts() {
		return repository.findAll();
	}

	/*
	 * Delete Items from Cart
	 */
	public String deleteCart(int id) {
		repository.deleteById(id);
		return "Cart removed !! " + id;
	}

	/*
	 * Update Items to Cart
	 */
	public Cart updateCart(Cart cart) {
		Cart existingCart = repository.findById(cart.getCartid()).orElse(null);
		existingCart.setQuantity(cart.getQuantity());
		existingCart.setTotalprice(cart.getTotalprice());
		existingCart.setStatus(cart.getStatus());
		return repository.save(existingCart);
	}
}
