package com.nguyentran.springmvc.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.ValueGenerationType;

@Entity
public class Tag {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tagId;
	
	private String tagName;
	
	@ManyToMany(mappedBy = "tags",fetch=FetchType.EAGER)
	private List<Product> products;
	
	public Tag() {
		// TODO Auto-generated constructor stub
	}

	public Tag( String tagName) {
		super();
		this.tagName = tagName;
	}

	public Integer getTagId() {
		return tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	
}
