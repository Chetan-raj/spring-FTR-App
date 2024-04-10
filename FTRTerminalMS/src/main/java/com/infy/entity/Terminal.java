package com.infy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.infy.dto.TerminalDTO;

@Entity
public class Terminal {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int terminalId;
	private String terminalName;
	private String country;
	private String itemType;
	private String terminalDescription;
	private int capacity;
	private String status;
	private String harbourLocation;
	private int availableCapacity;
	
	
	public Terminal()
	{
		
	}
	
	
	public int getTerminalId() {
		return terminalId;
	}
	public void setTerminalId(int terminalId) {
		this.terminalId = terminalId;
	}
	public String getTerminalName() {
		return terminalName;
	}
	public void setTerminalName(String terminalName) {
		this.terminalName = terminalName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public String getTerminalDescription() {
		return terminalDescription;
	}
	public void setTerminalDescription(String terminalDescription) {
		this.terminalDescription = terminalDescription;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getHarbourLocation() {
		return harbourLocation;
	}
	public void setHarbourLocation(String harbourLocation) {
		this.harbourLocation = harbourLocation;
	}
	public int getAvailableCapacity() {
		return availableCapacity;
	}
	public void setAvailableCapacity(int avialableCapacity) {
		this.availableCapacity = avialableCapacity;
	}
	
	public static TerminalDTO prepareTerminalDTO(Terminal terminal)
	{
		TerminalDTO terminalDTO = new TerminalDTO();
		terminalDTO.setTerminalId(terminal.getTerminalId());
		terminalDTO.setTerminalName(terminal.getTerminalName());
		terminalDTO.setCountry(terminal.getCountry());
		terminalDTO.setItemType(terminal.getItemType());
		terminalDTO.setTerminalDescription(terminal.getTerminalDescription());
		terminalDTO.setCapacity(terminal.getCapacity());
		terminalDTO.setStatus(terminal.getStatus());
		terminalDTO.setHarbourLocation(terminal.getHarbourLocation());
		terminalDTO.setAvailableCapacity(terminal.getAvailableCapacity());
		return terminalDTO;
				
		}
	
	
	
	
	

}
