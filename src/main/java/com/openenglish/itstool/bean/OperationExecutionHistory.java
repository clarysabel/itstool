package com.openenglish.itstool.bean;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "operations_execution_history", catalog = "orion")
public class OperationExecutionHistory implements Serializable {

	private static final long serialVersionUID = 8182742045594675976L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "operation_execution_history_id")
	private Integer operationExecutionHistoryId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "operation_id")
	private Operation operation;
	
	@Column(name="execution_time")
	private Timestamp executionTime;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "operationExecutionHistory")
	private List<OperationExecutionValue> operationExecutionValues;

	public OperationExecutionHistory(Integer operationExecutionHistoryId,
			User user, Operation operation, Timestamp executionTime,
			List<OperationExecutionValue> operationExecutionValues) {
		super();
		this.operationExecutionHistoryId = operationExecutionHistoryId;
		this.user = user;
		this.operation = operation;
		this.executionTime = executionTime;
		this.operationExecutionValues = operationExecutionValues;
	}

	public OperationExecutionHistory() {
	}

	public Integer getOperationExecutionHistoryId() {
		return operationExecutionHistoryId;
	}

	public void setOperationExecutionHistoryId(Integer operationExecutionHistoryId) {
		this.operationExecutionHistoryId = operationExecutionHistoryId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public Timestamp getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(Timestamp executionTime) {
		this.executionTime = executionTime;
	}

	public List<OperationExecutionValue> getOperationExecutionValues() {
		return operationExecutionValues;
	}

	public void setOperationExecutionValues(
			List<OperationExecutionValue> operationExecutionValues) {
		this.operationExecutionValues = operationExecutionValues;
	}
	
	
}
