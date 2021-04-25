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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "farmer_tbl")
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
	
	@Column(name = "farmer_city")
	private String city;
	
	
	@Column(name = "farmer_area")
	private double area;
	
	@Column(name = "farmer_landAddress")
	private String landAddress;
	
	@Column(name = "farmer_landPincode")
	private String landPincode;
	
	@Column(name = "farmer_bankAccountNo")
	private int bankAccountNo;
	
	@Column(name = "farmer_ifsc")
	private String ifscCode;
	
	@Column(name = "farmer_password")
	private String password;
	
	@JsonIgnore
	@OneToMany(mappedBy = "farmer")
	private List<CropsSold> cropsSold;
	
	@JsonIgnore
	@OneToOne(mappedBy = "farmer", cascade = CascadeType.ALL)
	private Insurance insurance;
	
	@JsonIgnore
	@OneToOne(mappedBy = "farmer")
	private Request request;
	
	//test changes
	@JsonIgnore
	@OneToOne(mappedBy = "farmer")
	private ClaimInsurance claimInsurance;
	
	@JsonIgnore
	@OneToOne(mappedBy = "farmer")
	private Notification notification;
	
	//Getters and Setters
	
	//test changes
	public ClaimInsurance getClaimInsurance() {
		return claimInsurance;
	}

	public void setClaimInsurance(ClaimInsurance claimInsurance) {
		this.claimInsurance = claimInsurance;
	}
	
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

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<CropsSold> getCropsSold() {
		return cropsSold;
	}

	public void setCropsSold(List<CropsSold> cropsSold) {
		this.cropsSold = cropsSold;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLandPincode() {
		return landPincode;
	}

	public void setLandPincode(String landPincode) {
		this.landPincode = landPincode;
	}
	
	
	
	

}
