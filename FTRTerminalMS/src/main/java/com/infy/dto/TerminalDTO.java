package com.infy.dto;

import com.infy.entity.Terminal;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class TerminalDTO {
	
	private int terminalId;
	@NotNull(message = "{terminal.terminalName.must}")
	@Pattern(regexp="[\\w\\-\\s]+",message= "{terminal.terminalName.invalid}")
	private String terminalName;
	@NotNull(message="{terminal.country.must}")
	@Pattern(regexp="[\\w\\-\\s]+",message= "{terminal.country.invalid}")
	private String country;
	@NotNull(message = "{terminal.itemType.must}")
	@Pattern(regexp="[\\w\\-\\s]+",message= "{terminal.itemType.invalid}")
	private String itemType;
	@NotNull(message="terminal.terminalDescription.must")
	@Pattern(regexp="[\\w\\-\\s]+",message= "{terminal.terminalDescription.invalid}")
	private String terminalDescription;
	@NotNull(message = "{terminal.capacity.must}")
	@Max(value=99999, message = "{terminal.capacity.invalid}")
	private int capacity;
	@NotNull(message = "{terminal.status.must}")
	private String status;
	private String harbourLocation;
	private int availableCapacity;
	
	public TerminalDTO() {}
	

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
	
	public static Terminal prepareTerminalEntity(TerminalDTO terminalDTO)
	{
		Terminal terminal = new Terminal();
		terminal.setTerminalId(terminalDTO.getTerminalId());
		terminal.setTerminalName(terminalDTO.getTerminalName());
		terminal.setCountry(terminalDTO.getCountry());
		terminal.setItemType(terminalDTO.getItemType());
		terminal.setTerminalDescription(terminalDTO.getTerminalDescription());
		terminal.setCapacity(terminalDTO.getCapacity());
		terminal.setStatus(terminalDTO.getStatus());
		terminal.setHarbourLocation(terminalDTO.getHarbourLocation());
		terminal.setAvailableCapacity(terminalDTO.getAvailableCapacity());
		return terminal;
	}
	@Override
	public String toString()
	{
		 return "TerminalDTO[ID:"+terminalId+"Terminal Name : "+terminalName +" Country: "+country + "item Type:"+itemType+"Terminal Description : "+terminalDescription +" Capacity: "+capacity + "status:"+status+"Harbour Location : "+harbourLocation+"Available Capacity : "+availableCapacity+"]";	
	}
	
	

}
