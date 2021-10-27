package com.cayena.products.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "quantity_in_stock")
	private Long quantityInStock;

	@Column(name = "unit_price")
	private BigDecimal unitPrice;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
	private Supplier supplier;

	@Column(name = "date_of_creation")
	private Date dateOfCreation;

	@Column(name = "date_of_the_last_update")
	private Date dateOfTheLastUpdate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(Long quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public Date getDateOfTheLastUpdate() {
		return dateOfTheLastUpdate;
	}

	public void setDateOfTheLastUpdate(Date dateOfTheLastUpdate) {
		this.dateOfTheLastUpdate = dateOfTheLastUpdate;
	}
}