package com.example.billgeneratorproject.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "category")
	private String categoryName;

	@Column(name = "levy")
	private int levy;

	public Category() {
		super();
	}

	public Category(String categoryName, int levy, Product product) {
		super();
		this.categoryName = categoryName;
		this.levy = levy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getLevy() {
		return levy;
	}

	public void setLevy(int levy) {
		this.levy = levy;
	}

}
