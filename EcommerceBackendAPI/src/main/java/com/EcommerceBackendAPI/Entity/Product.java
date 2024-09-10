package com.EcommerceBackendAPI.Entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCT")
@PrimaryKeyJoinColumn(name = "productid")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productid;

	@Column(name = "name", nullable = false, length = 100)
	@Schema(example = "Wireless Mouse")
	private String name;

	@Column(name = "type", nullable = false, length = 100)
	@Schema(example = "Electronics")
	private String type;

	@Column(name = "price", nullable = false)
	private int price;

	@Column(name = "description", nullable = false, length = 200)
	@Schema(example = "Description of product")
	private String description;

	@Column(name = "stockquantity", nullable = false)
	private int stockquantity;

	// Getter Setter Methods
	public int getProductid() {
		return productid;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public int getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	public int getStockquantity() {
		return stockquantity;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setStockquantity(int stockquantity) {
		this.stockquantity = stockquantity;
	}

}
