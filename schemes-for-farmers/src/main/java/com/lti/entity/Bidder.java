package com.lti.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bidder_tbl")
public class Bidder {

		@Id
		@GeneratedValue
		@Column(name="bidder_id")
		private int bidderId;
		
		@Column(name="full_name")
		private String fullName;
		@Column(name="contact_number")
		private int contactNumber;
		@Column(name="email_id")
		private String emailId;
		private String address;
		private String city;
		private int pincode;
		private String state;
		
		@Column(name="account_number")
		private int accountNumber;
		@Column(name="ifsc_code")
		private String ifscCode;

		@Column(name="trader_license")
		private String tradeLicenseNo;
		
		private String password;
		
		@OneToMany(mappedBy="bidder")
		private List<CropsSold> cropsSold;
		
		@OneToMany(mappedBy="bidder")
		private List<Bid> bids;

		public int getBidderId() {
			return bidderId;
		}

		public void setBidderId(int bidderId) {
			this.bidderId = bidderId;
		}

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public int getContactNumber() {
			return contactNumber;
		}

		public void setContactNumber(int contactNumber) {
			this.contactNumber = contactNumber;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
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

		public int getAccountNumber() {
			return accountNumber;
		}

		public void setAccountNumber(int accountNumber) {
			this.accountNumber = accountNumber;
		}

		public String getIfscCode() {
			return ifscCode;
		}

		public void setIfscCode(String ifscCode) {
			this.ifscCode = ifscCode;
		}

		public String getTradeLicenseNo() {
			return tradeLicenseNo;
		}

		public void setTradeLicenseNo(String tradeLicenseNo) {
			this.tradeLicenseNo = tradeLicenseNo;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public List<CropsSold> getCropssold() {
			return cropsSold;
		}

		public void setCropssold(List<CropsSold> cropsSold) {
			this.cropsSold = cropsSold;
		}

		public List<Bid> getBids() {
			return bids;
		}

		public void setBids(List<Bid> bids) {
			this.bids = bids;
		}
		
		
		
		
}


