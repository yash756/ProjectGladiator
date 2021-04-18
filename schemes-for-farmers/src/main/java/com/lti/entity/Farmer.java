package com.lti.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_farmer")
public class Farmer {
	
	@Id
	@GeneratedValue
	@Column(name = "farmer_id")
	private int id;
	
	@Column(name = "farmer_name")
	private String name;
	
	@Column(name = "farmer_contact")
	private int contact;
	
	@Column(name = "farmer_email")
	private String email;
	
	@Column(name = "farmer_address")
	private String address;
	
	@Column(name = "farmer_pincode")
	private int pincode;
	
	@Column(name = "farmer_state")
	private String state;
	
	@Column(name = "farmer_area")
	private double area;
	
	@Column(name = "farmer_landAddress")
	private String landAddress;
	
	@Column(name = "farmer_bankAccountNo")
	private int bankAccountNo;
	
	@Column(name = "farmer_ifsc")
	private int ifscCode;
	
	@Column(name = "farmer_password")
	private String password;
	
	/*@OneToMany(mappedBy = "farmer")
	private List<CropSold> cropsSold;*/
	
	@OneToOne(mappedBy = "farmer")
	private Insurance insurance;
	
	/*@OneToOne(mappedBy = "farmer")
	private SellRequest request;*/
	
	//Getters and Setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public String getLandAddress() {
		return landAddress;
	}

	public void setLandAddress(String landAddress) {
		this.landAddress = landAddress;
	}

	public int getBankAccountNo() {
		return bankAccountNo;
	}

	public void setBankAccountNo(int bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}

	public int getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(int ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*public List<CropSold> getCropsSold() {
		return cropsSold;
	}

	public void setCropsSold(List<CropSold> cropsSold) {
		this.cropsSold = cropsSold;
	}*/

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	/*public SellRequest getRequest() {
		return request;
	}

	public void setRequest(SellRequest request) {
		this.request = request;
	}*/
	
	
	
	

}
