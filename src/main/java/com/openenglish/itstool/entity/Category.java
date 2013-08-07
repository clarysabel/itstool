package com.openenglish.itstool.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "categories", catalog = "orion")
@SQLDelete(sql="UPDATE customer SET deleted = 'true' WHERE id = ?")
@Where(clause="deleted = 'false'")
public class Category implements Serializable{
	
	/**
	 * Generated Serial Version UID
	 */
	private static final long serialVersionUID = -2272594247337247994L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private Integer categoryId;
	
	@Column(name="name")
	private String name;
	
	@Column (name="description")
	private String description;
	
	@Column (name="deleted")
	private Boolean deleted;
	
	public Category() {
	}
	
	public Category(Integer categoryId, String name, String description,
			Boolean deleted) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.description = description;
		this.deleted = deleted;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
	
}
