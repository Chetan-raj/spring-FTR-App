package com.infy.FTR.UserEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ftr_user")
@SequenceGenerator(name="seq", initialValue=101, allocationSize=1)
public class UserEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
	Integer userId;
	@Column(name="First_Name")
	String firstName;
	@Column(name="Last_Name")
	String lastName;
	@Column(name="Email_Id")
	String emailId;
	@Column(name="Mobile_Number")
	Long mobileNumber;
	@Column(name="Password")
	String password;
	@Column(name="Passport_Number")
	String passportNumber;
	@Column(name="Nationality")
	String nationality;
	@Column(name="Permanent_Address")
	String permanentAddress;
	@Column(name="Office_Address")
	String officeAddress;
	@Column(name="Person_Identification_Number")
	Long personalIdentificationNumber;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public String getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}
	public Long getPersonalIdentificationNumber() {
		return personalIdentificationNumber;
	}
	public void setPersonalIdentificationNumber(Long personalIdentificationNumber) {
		this.personalIdentificationNumber = personalIdentificationNumber;
	}
	@Override
	public String toString() {
		return "UserEntity [userId=" + getUserId() + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", mobileNumber=" + mobileNumber + ", password=" + password + ", passportNumber="
				+ passportNumber + ", nationality=" + nationality + ", permanentAddress=" + permanentAddress
				+ ", officeAddress=" + officeAddress + ", personalIdentificationNumber=" + personalIdentificationNumber
				+ "]";
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
