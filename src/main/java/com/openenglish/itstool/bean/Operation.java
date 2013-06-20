package com.openenglish.itstool.bean;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.openenglish.itstool.common.bean.Bean;

@Entity
@Table(name = "operations", catalog = "orion")
@SQLDelete(sql="UPDATE operations SET deleted = 'Y' WHERE id = ?")
@Where(clause="deleted <> 'Y'")
public class Operation implements Bean {

	private static final long serialVersionUID = 4196284535407534221L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "operation_id")
	private Integer operationId;
	
	private String name;
	private String type;
	private String detail;
	private Character deleted;
	
	@Column(name="sql_code")
	private String sqlCode;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "operations_roles", schema="orion", joinColumns = { @JoinColumn(name = "operation_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
	private List<Role> roles;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "operation")
	private List<Input> inputs;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "operation")
	private List<Output> outputs;

	public Operation(Integer operationId, String name, String type,
			String detail, Character deleted, String sqlCode, List<Role> roles,
			List<Input> inputs, List<Output> outputs) {
		super();
		this.operationId = operationId;
		this.name = name;
		this.type = type;
		this.detail = detail;
		this.deleted = deleted;
		this.sqlCode = sqlCode;
		this.roles = roles;
		this.inputs = inputs;
		this.outputs = outputs;
	}
	
	public Operation() {
		super();
	}

	public Integer getOperationId() {
		return operationId;
	}

	public void setOperationId(Integer operationId) {
		this.operationId = operationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Character getDeleted() {
		return deleted;
	}

	public void setDeleted(Character deleted) {
		this.deleted = deleted;
	}

	public String getSqlCode() {
		return sqlCode;
	}

	public void setSqlCode(String sqlCode) {
		this.sqlCode = sqlCode;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Input> getInputs() {
		return inputs;
	}

	public void setInputs(List<Input> inputs) {
		this.inputs = inputs;
	}

	public List<Output> getOutputs() {
		return outputs;
	}

	public void setOutputs(List<Output> outputs) {
		this.outputs = outputs;
	}
	
}