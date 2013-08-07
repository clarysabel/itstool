package com.openenglish.itstool.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "users", catalog = "orion")
@SQLDelete(sql="UPDATE customer SET deleted = 'true' WHERE id = ?")
@Where(clause="deleted = 'false'")
public class User implements Serializable {

	private static final long serialVersionUID = -6057185166011652037L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;
	
	
	@Column(name="username")
	private String username;
	
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="status")
	private Character status;
	
	@Generated(GenerationTime.ALWAYS)
	@Column(name = "creation_date")
	private Timestamp creationDate;

	@Generated(GenerationTime.ALWAYS)
	@Column(name = "last_modified")
	private Timestamp lastModified;
	
	@Column(name="deleted")
	private Boolean deleted;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "users_roles", schema="orion", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
	private List<Role> roles;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "users_categories", schema="orion", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "category_id") })
	private List<Category> categories;
	
	public User() {
		super();
	}

	public User(Integer userId, String email, String password,
			Character status, Timestamp creationDate, Timestamp lastModified,
			Boolean deleted, List<Role> roles, List<Category> categories) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.status = status;
		this.creationDate = creationDate;
		this.lastModified = lastModified;
		this.deleted = deleted;
		this.roles = roles;
		this.categories = categories;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public Timestamp getLastModified() {
		return lastModified;
	}

	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}

	@Fetch(value = FetchMode.SUBSELECT)
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	@Fetch(value = FetchMode.SUBSELECT)
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
