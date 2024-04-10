package com.infyFTR.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WorkitemTerminal {
	@Id
	private String workItemId;
	
	private String terminalId;
	
	public WorkitemTerminal() {}

	public String getWorkItemId() {
		return workItemId;
	}

	public void setWorkItemId(String workItemId) {
		this.workItemId = workItemId;
	}

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}


	

}
