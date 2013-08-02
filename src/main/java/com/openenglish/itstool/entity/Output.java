package com.openenglish.itstool.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "outputs", catalog = "orion")
public class Output implements Serializable {

	private static final long serialVersionUID = -1634137841697960077L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="output_id")
	private Integer outputId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "operation_id")
	private Operation operation;
	
	@Column(name="name")
	private String name;
	
	@Column(name="type")
	private String type;
	
	@Column(name="display_order")
	private Short displayOrder;

	@Column(name="display_name")
	private String displayName;
	
	@Column(name="deleted")
	private Boolean deleted;

	public Output(Integer outputId, Operation operation, String name,
			String type, Short displayOrder, String displayName, Boolean deleted) {
		super();
		this.outputId = outputId;
		this.operation = operation;
		this.name = name;
		this.type = type;
		this.displayOrder = displayOrder;
		this.displayName = displayName;
		this.deleted = deleted;
	}

	public Output() {
	}

	public Integer getOutputId() {
		return outputId;
	}

	public void setOutputId(Integer outputId) {
		this.outputId = outputId;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
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

	public Short getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(Short displayOrder) {
		this.displayOrder = displayOrder;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}


	
}
