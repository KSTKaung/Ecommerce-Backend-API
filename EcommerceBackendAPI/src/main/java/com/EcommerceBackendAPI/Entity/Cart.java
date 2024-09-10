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
@Table(name = "CART")
@PrimaryKeyJoinColumn(name = "userid")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ReadOnlyProperty
	private int cartid;

	@ManyToOne
	@JoinColumn(name = "userid")
	private Users users;

	@ManyToOne
	@JoinColumn(name = "productid")
	private Product product;

	@Column(name = "quantity", nullable = false)
	private int quantity;

	@Column(name = "totalprice", nullable = false)
	private int totalprice;

	@Column(name = "status", nullable = false, length = 200)
	@Schema(example = "Add to Cart")
	private String status;

	// Getter Setter Methods
	public int getCartid() {
		return cartid;
	}

	public Users getUsers() {
		return users;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public String getStatus() {
		return status;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
