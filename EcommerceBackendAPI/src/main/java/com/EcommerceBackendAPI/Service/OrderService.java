package com.EcommerceBackendAPI.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EcommerceBackendAPI.Entity.Order;
import com.EcommerceBackendAPI.Entity.Product;
import com.EcommerceBackendAPI.Repository.OrderRepository;
import com.EcommerceBackendAPI.Repository.ProductRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;

	@Autowired
	private ProductRepository productRepository;

	/*
	 * Save Order
	 */
	public Order saveOrder(Order order) {
		Product existingProduct = productRepository.findById(order.getProduct().getProductid()).orElse(null);
		// Check available stock quantity
		int remainStockquantity = existingProduct.getStockquantity() - order.getAmount();
		if (remainStockquantity > 0) {
			existingProduct.setStockquantity(remainStockquantity);
			// Update stock quantity of product
			productRepository.save(existingProduct);
			// Save order
			return repository.save(order);
		}
		return order;
	}

	/*
	 * Get All Orders
	 */
	public List<Order> getOrders() {
		return repository.findAll();
	}

	/*
	 * Get Order By User ID
	 */
	public List<Order> findByUserID(int userId) {
		return repository.findByUserID(userId);
	}

	/*
	 * Get Order By Product ID
	 */
	public List<Order> findByProductID(int productId) {
		return repository.findByProductID(productId);
	}

	/*
	 * Delete Order
	 */
	public String deleteOrder(int id) {
		Order existingOrder = repository.findById(id).orElse(null);
		Product existingProduct = productRepository.findById(existingOrder.getProduct().getProductid()).orElse(null);
		// Check available stock quantity
		int remainStockquantity = existingProduct.getStockquantity() + existingOrder.getAmount();
		existingProduct.setStockquantity(remainStockquantity);
		// Update stock quantity of product
		productRepository.save(existingProduct);
		// Delete Order
		repository.deleteById(id);
		return "Order removed !! " + id;
	}

	/*
	 * Update Order
	 */
	public Order updateOrder(Order order) {
		Order existingOrder = repository.findById(order.getOrderid()).orElse(null);
		Product existingProduct = productRepository.findById(existingOrder.getProduct().getProductid()).orElse(null);
		// Check available stock quantity
		int remainStockquantity = existingProduct.getStockquantity() - (order.getAmount() - existingOrder.getAmount());
		if (remainStockquantity > 0) {
			existingProduct.setStockquantity(remainStockquantity);
			// Update stock quantity of product
			productRepository.save(existingProduct);
			existingOrder.setAmount(order.getAmount());
			existingOrder.setDate(order.getDate());
			existingOrder.setStatus(order.getStatus());
			// Update Order
			return repository.save(existingOrder);
		}
		return order;
	}
}
