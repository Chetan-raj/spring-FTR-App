package com.infy.FTR.UserDTO;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.context.annotation.PropertySource;

import com.infy.FTR.UserEntity.UserEntity;
@PropertySource("classpath:ValidationMessages.properties")
public class UserDTO {
	Integer userId;
	@NotEmpty(message= "{user.firstName.must}")
	@Size(max=20,message="{user.firstName.invalid}")
	private String firstName;
	@NotEmpty(message= "{user.lastName.must}")
	@Size(max=20,message="{user.lastName.invalid}")
	private String lastName;
	@Email(message="{user.email.invalid}")
	@NotEmpty(message="{user.email.must}")
	private String emailId;
	@NotNull(message="{user.phone.must}")
	//(integer = 10, fraction = 2,message="{user.phone.invalid}")
	@Min(value=1000000000L,message="{user.phone.invalid}")
	@Max(value=9999999999L,message="{user.phone.invalid}")
	private Long mobileNumber;
	@Pattern(regexp="[a-zA-Z]{4,12}"+"[@!#$%&]{1}"+"[0-9]{2}",message="{user.password.invalid}")
	@NotEmpty(message= "{user.password.must}")
	@Size(min=7,max=15,message="{user.password.invalidsize}")
	private String password;
	@NotEmpty(message="{user.passportNumber.must}")
	@Size(min=7,max=12,message="{user.passportNumber.invalid}")
	private String passportNumber;
	@NotEmpty(message="{user.nationality.must}")
	private String nationality;
	
	@NotEmpty(message="{user.permanentAddress.must}")
	@Size(max=200,message="{user.permanentAddress.invalid}")
	private String permanentAddress;
	@NotEmpty(message="{user.officeAddress.must}")
	@Size(max=200,message="{user.officeAddress.invalid}")
	private String officeAddress;
	@NotNull(message="{user.personalIdentificationNumber.must}")
	@Min(value=100000000000L,message="{user.personalIdentificationNumber.invalid}")
	@Max(value=999999999999L,message="{user.personalIdentificationNumber.invalid}")
	private Long personalIdentificationNumber;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
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
		return "UserDTO [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", mobileNumber=" + mobileNumber + ", password=" + password + ", passportNumber="
				+ passportNumber + ", nationality=" + nationality + ", permanentAddress=" + permanentAddress
				+ ", officeAddress=" + officeAddress + ", personalIdentificationNumber=" + personalIdentificationNumber
				+ "]";
	}
	public static UserEntity changes(UserDTO dt) {
		UserEntity ent=new UserEntity();
		ent.setEmailId(dt.getEmailId());
		ent.setFirstName(dt.getFirstName());
		ent.setLastName(dt.getLastName());
		ent.setMobileNumber(dt.getMobileNumber());
		ent.setNationality(dt.getNationality());
		ent.setOfficeAddress(dt.getOfficeAddress());
		ent.setPermanentAddress(dt.getPermanentAddress());
		ent.setPersonalIdentificationNumber(dt.getPersonalIdentificationNumber());
		ent.setPassword(dt.getPassword());
		ent.setUserId(dt.getUserId());
		ent.setPassportNumber(dt.getPassportNumber());
		return ent;
	}
	public static UserDTO changesTo(UserEntity ent) {
		UserDTO dt=new UserDTO();
		dt.setEmailId(ent.getEmailId());
		dt.setFirstName(ent.getFirstName());
		dt.setLastName(ent.getLastName());
		dt.setMobileNumber(ent.getMobileNumber());
		dt.setNationality(ent.getNationality());
		dt.setOfficeAddress(ent.getOfficeAddress());
		dt.setPermanentAddress(ent.getPermanentAddress());
		dt.setPersonalIdentificationNumber(ent.getPersonalIdentificationNumber());
		dt.setPassword(ent.getPassword());
		dt.setUserId(ent.getUserId());
		dt.setPassportNumber(ent.getPassportNumber());
		return dt;
	}
	
}
