package com.openenglish.itstool.bean;

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
@Table(name = "operations_execution_values", catalog = "orion")
public class OperationExecutionValue implements Serializable {

	private static final long serialVersionUID = -7918704955235758909L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "operation_execution_value_id")
	private Integer operationExecutionValueId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "input_id")
	private Input input;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "operation_execution_history_id")
	private OperationExecutionHistory operationExecutionHistory;
	
	@Column(name="value")
	private String value;

	public OperationExecutionValue(Integer operationExecutionValueId,
			Input input, OperationExecutionHistory operationExecutionHistory,
			String value) {
		super();
		this.operationExecutionValueId = operationExecutionValueId;
		this.input = input;
		this.operationExecutionHistory = operationExecutionHistory;
		this.value = value;
	}

	public OperationExecutionValue() {
	}

	public Integer getOperationExecutionValueId() {
		return operationExecutionValueId;
	}

	public void setOperationExecutionValueId(Integer operationExecutionValueId) {
		this.operationExecutionValueId = operationExecutionValueId;
	}

	public Input getInput() {
		return input;
	}

	public void setInput(Input input) {
		this.input = input;
	}

	public OperationExecutionHistory getOperationExecutionHistory() {
		return operationExecutionHistory;
	}

	public void setOperationExecutionHistory(
			OperationExecutionHistory operationExecutionHistory) {
		this.operationExecutionHistory = operationExecutionHistory;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
