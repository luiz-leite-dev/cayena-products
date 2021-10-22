package com.cayena.products.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supplier")
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name")
	private String name;

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
