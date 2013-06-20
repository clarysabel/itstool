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
@Table(name = "inputs", catalog = "orion")
public class Input implements Bean {

	private static final long serialVersionUID = -2559719551056552128L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "input_id")
	private Integer inputId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "operation_id")
	private Operation operation;
	
	private String name;
	private String type;
	
	@Column(name="display_name")
	private String displayName;
	
	public Input(Integer inputId, Operation operation, String name,
			String type, String displayName) {
		super();
		this.inputId = inputId;
		this.operation = operation;
		this.name = name;
		this.type = type;
		this.displayName = displayName;
	}
	
	public Input() {
		super();
	}

	public Integer getInputId() {
		return inputId;
	}

	public void setInputId(Integer inputId) {
		this.inputId = inputId;
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

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
}
