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

import com.EcommerceBackendAPI.Entity.Order;
import com.EcommerceBackendAPI.Service.OrderService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Order")
public class OrderController {

	@Autowired
	private OrderService service;

	@PostMapping("/addOrder")
	@Description("Add Order")
	public Order addOrder(@RequestBody Order order) {
		return service.saveOrder(order);
	}

	@GetMapping("/getAllOrder")
	@Description("Get All Orders")
	public List<Order> findAllOrder() {
		return service.getOrders();
	}

	@GetMapping("/getOrderByUserID/{userId}")
	@Description("Get All Orders By UserID")
	public List<Order> findByUserID(@PathVariable int userId) {
		return service.findByUserID(userId);
	}

	@GetMapping("/getOrderByProductID/{productId}")
	@Description("Get All Orders By ProductID")
	public List<Order> findByProductID(@PathVariable int productId) {
		return service.findByProductID(productId);
	}

	@PutMapping("/updateOrder")
	@Description("Update Order")
	@ApiResponse(responseCode = "200", description = "Update Successfully")
	public Order updateOrder(@RequestBody Order order) {
		return service.updateOrder(order);
	}

	@DeleteMapping("/deleteOrder/{Id}")
	@Description("Delete Order")
	public String deleteOrder(@PathVariable int Id) {
		return service.deleteOrder(Id);
	}
}
