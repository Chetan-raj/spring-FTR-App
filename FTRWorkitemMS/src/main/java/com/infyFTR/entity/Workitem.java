package com.infyFTR.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Workitem {

	private long userId;
	@Id
	private String workitemId;
	private String itemName;
	private String itemType;
	private String itemDescription;
	private String messageToRecipient;
	private String quantity;
	private String sourceCountry;
	private String destinationCountry;
	private String originHarborLocation;
	private String selectedHarborLocations;
	private Date shippingDate;
	private int amount;
	
	public Workitem() {
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
	
	
}
