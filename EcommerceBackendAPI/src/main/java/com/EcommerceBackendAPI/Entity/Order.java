package com.EcommerceBackendAPI.Entity;

import org.springframework.data.annotation.ReadOnlyProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "ORDERS")
@PrimaryKeyJoinColumn(name = "orderid")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ReadOnlyProperty
	private int orderid;

	@ManyToOne
	@JoinColumn(name = "userid")
	private Users users;

	@ManyToOne
	@JoinColumn(name = "productid")
	private Product product;

	@Column(name = "amount", nullable = false)
	private int amount;

	@Column(name = "orderdate", nullable = false)
	@Schema(example = "12/10/2024")
	private String date;

	@Column(name = "status", nullable = false, length = 100)
	@Schema(example = "Order Confirmed")
	private String status;

	// Getter Setter Methods
	public int getOrderid() {
		return orderid;
	}

	public Users getUsers() {
		return users;
	}

	public Product getProduct() {
		return product;
	}

	public int getAmount() {
		return amount;
	}

	public String getDate() {
		return date;
	}

	public String getStatus() {
		return status;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
