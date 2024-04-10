package com.infyFTR.dto;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.infyFTR.entity.Workitem;

public class WorkitemDTO {
	
	@NotNull(message = "{workitem.userId.must}")
	@Digits(fraction=0, integer=5, message = "{workitem.userId.invalid}")
	private long userId;
	@NotEmpty(message="{workitem.workitemId.must}")
	@Size(max = 5, message="{workitem.workitemId.invalid}")
	private String workitemId;
	@NotEmpty(message="{workitem.itemName.must}")
	@Size(min = 3,max = 25, message="{workitem.itemName.invalid}")
	private String itemName;
	@NotEmpty(message="{workitem.itemType.must}")
	@Size(min = 4,max = 25, message="{workitem.itemType.invalid}")
	private String itemType;
	@NotEmpty(message="{workitem.itemDescription.must}")
	@Size(min = 10,max = 45, message="{workitem.itemDescription.invalid}")
	private String itemDescription;
	@NotEmpty(message="{workitem.messageToRecipient.must}")
	@Size(min = 10,max = 50, message="{workitem.messageToRecipient.invalid}")
	private String messageToRecipient;
	@NotEmpty(message="{workitem.quantity.must}")
	@Pattern(regexp="[0-9]+([A-Za-z]{2,3})?",message="{workitem.quantity.invalid}")
	private String quantity;
	@NotEmpty(message="{workitem.sourceCountry.must}")
	@Size(min = 5,max = 25, message="{workitem.sourceCountry.invalid}")
	private String sourceCountry;
	@NotEmpty(message="{workitem.destinationCountry.must}")
	@Size(min = 5,max = 25, message="{workitem.destinationCountry.invalid}")
	private String destinationCountry;
	@NotEmpty(message="{workitem.originHarborLocation.must}")
	@Size(min = 5,max = 25, message="{workitem.originHarborLocation.invalid}")
	private String originHarborLocation;
	@NotEmpty(message="{workitem.selectedHarborLocations.must}")
	@Size(min = 5,max = 25, message="{workitem.selectedHarborLocations.invalid}")
	private String selectedHarborLocations;
	@JsonFormat(pattern = "dd-MMM-yyyy")
	private Date shippingDate;
	private int amount;
	
	public WorkitemDTO() {
	}
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getWorkitemId() {
		return workitemId;
	}

	public void setWorkitemId(String workitemId) {
		this.workitemId = workitemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getMessageToRecipient() {
		return messageToRecipient;
	}

	public void setMessageToRecipient(String messageToRecipient) {
		this.messageToRecipient = messageToRecipient;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getSourceCountry() {
		return sourceCountry;
	}

	public void setSourceCountry(String sourceCountry) {
		this.sourceCountry = sourceCountry;
	}

	public String getDestinationCountry() {
		return destinationCountry;
	}

	public void setDestinationCountry(String destinationCountry) {
		this.destinationCountry = destinationCountry;
	}

	public String getOriginHarborLocation() {
		return originHarborLocation;
	}

	public void setOriginHarborLocation(String originHarborLocation) {
		this.originHarborLocation = originHarborLocation;
	}

	public String getSelectedHarborLocations() {
		return selectedHarborLocations;
	}

	public void setSelectedHarborLocations(String selectedHarborLocations) {
		this.selectedHarborLocations = selectedHarborLocations;
	}

	public Date getShippingDate() {
		return shippingDate;
	}

	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	// Converts DTO into Entity
	public Workitem createEntity() 
	{
		Workitem wi = new Workitem();
		wi.setUserId(this.getUserId());
		wi.setWorkitemId(this.getWorkitemId());
		wi.setItemName(this.getItemName());
		wi.setItemType(this.getItemType());
		wi.setItemDescription(this.getItemDescription());
		wi.setMessageToRecipient(this.getMessageToRecipient());
		wi.setQuantity(this.getQuantity());
		wi.setSourceCountry(this.getSourceCountry());
		wi.setDestinationCountry(this.getDestinationCountry());
		wi.setOriginHarborLocation(this.getOriginHarborLocation());
		wi.setSelectedHarborLocations(this.getSelectedHarborLocations());
		wi.setShippingDate(this.getShippingDate());
		wi.setAmount(this.getAmount());
					
		return wi;
	}
	
	// Converts Entity into DTO
	public static WorkitemDTO valueOf(Workitem work) 
	{
		WorkitemDTO workitemDTO= new WorkitemDTO();
		workitemDTO.setUserId(work.getUserId());
		workitemDTO.setWorkitemId(work.getWorkitemId());
		workitemDTO.setItemName(work.getItemName());
		workitemDTO.setItemType(work.getItemType());
		workitemDTO.setItemDescription(work.getItemDescription());
		workitemDTO.setMessageToRecipient(work.getMessageToRecipient());
		workitemDTO.setQuantity(work.getQuantity());
		workitemDTO.setSourceCountry(work.getSourceCountry());
		workitemDTO.setDestinationCountry(work.getDestinationCountry());
		workitemDTO.setOriginHarborLocation(work.getOriginHarborLocation());
		workitemDTO.setSelectedHarborLocations(work.getSelectedHarborLocations());
		workitemDTO.setShippingDate(work.getShippingDate());
		workitemDTO.setAmount(work.getAmount());
		
		return workitemDTO;
	} 
	
}
