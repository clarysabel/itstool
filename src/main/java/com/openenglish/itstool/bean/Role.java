package com.openenglish.itstool.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.openenglish.itstool.common.bean.Bean;

@Entity
@Table(name = "roles", catalog = "orion")
@SQLDelete(sql="UPDATE roles SET deleted = 'Y' WHERE id = ?")
@Where(clause="deleted <> 'Y'")
public class Role implements Bean {

	private static final long serialVersionUID = -704479125752534429L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="role_id")
	private Integer roleId;
	private String name;
	private Character deleted;
	
	public Role(Integer roleId, String name, Character deleted) {
		super();
		this.roleId = roleId;
		this.name = name;
		this.deleted = deleted;
	}

	public Role() {
		super();
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Character getDeleted() {
		return deleted;
	}

	public void setDeleted(Character deleted) {
		this.deleted = deleted;
	}
	
}
