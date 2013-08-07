package com.openenglish.itstool.entity;

import java.io.Serializable;
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


@Entity
@Table(name = "operations", catalog = "orion")
@SQLDelete(sql="UPDATE customer SET deleted = 'true' WHERE id = ?")
@Where(clause="deleted = 'false'")
public class Operation implements Serializable {

	private static final long serialVersionUID = 4196284535407534221L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "operation_id")
	private Integer operationId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="type")
	private String type;
	
	@Column(name="sql_code")
	private String sqlCode;
	
	@Column(name="detail")
	private String detail;
	
	@Column(name="deleted")
	private Boolean deleted;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "operations_categories", schema="orion", joinColumns = { @JoinColumn(name = "operation_id") }, inverseJoinColumns = { @JoinColumn(name = "category_id") })
	private List<Category> categories;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "operation")
	private List<Input> inputs;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "operation")
	private List<Output> outputs;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "operation")
	private List<OperationExecutionHistory> operationExecutionHistories;

	public Operation() {
	}
	
	public Operation(Integer operationId, String name, String type,
			String sqlCode, String detail, Boolean deleted,
			List<Category> categories, List<Input> inputs,
			List<Output> outputs,
			List<OperationExecutionHistory> operationExecutionHistories) {
		super();
		this.operationId = operationId;
		this.name = name;
		this.type = type;
		this.sqlCode = sqlCode;
		this.detail = detail;
		this.deleted = deleted;
		this.categories = categories;
		this.inputs = inputs;
		this.outputs = outputs;
		this.operationExecutionHistories = operationExecutionHistories;
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

	public String getSqlCode() {
		return sqlCode;
	}

	public void setSqlCode(String sqlCode) {
		this.sqlCode = sqlCode;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public List<OperationExecutionHistory> getOperationExecutionHistories() {
		return operationExecutionHistories;
	}

	public void setOperationExecutionHistories(
			List<OperationExecutionHistory> operationExecutionHistories) {
		this.operationExecutionHistories = operationExecutionHistories;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
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

	public List<OperationExecutionHistory> getOperationExecutionHistory() {
		return operationExecutionHistories;
	}

	public void setOperationExecutionHistory(
			List<OperationExecutionHistory> operationExecutionHistories) {
		this.operationExecutionHistories = operationExecutionHistories;
	}


}