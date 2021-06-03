package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	
	@Column(name="productname")
	private String productName;
	
	@Column(name="description")
	private String Description;
	
	@Column(name="urlimage")
	private String urlImage;
	
	@Column(name="price")
	private Double price;
	
	@Column(name="amount")
	private int amount;

	public Product() {
		super();
	}

	public Product(String productName, String description, String urlImage, Double price, int amount) {
		super();
		this.productName = productName;
		Description = description;
		this.urlImage = urlImage;
		this.price = price;
		this.amount = amount;
	}

	public Long getId() {
		return productId;
	}

	public void setId(Long id) {
		this.productId = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
