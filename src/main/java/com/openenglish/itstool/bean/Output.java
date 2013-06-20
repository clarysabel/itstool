package com.openenglish.itstool.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.openenglish.itstool.common.bean.Bean;

@Entity
@Table(name = "outputs", catalog = "orion")
public class Output implements Bean {

	private static final long serialVersionUID = -1634137841697960077L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer outputId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "operation_id")
	private Operation operation;
	
	private String name;
	private String type;
	
	@Column(name="display_order")
	private Short displayOrder;

	@Column(name="display_name")
	private String displayName;

	public Output(Integer outputId, Operation operation, String name,
			String type, Short displayOrder, String displayName) {
		super();
		this.outputId = outputId;
		this.operation = operation;
		this.name = name;
		this.type = type;
		this.displayOrder = displayOrder;
		this.displayName = displayName;
	}
	
	public Output() {
		super();
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

}
