package com.lti.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="market_place")
public class MarketPlace {

	@Id
	@GeneratedValue
	@Column(name="item_no")
	private int itemNo;
	
	@Column(name="crop_name")
	private String cropName;
	@Column(name="crop_type")
	private String cropType;
	@Column(name="base_price")
	private double basePrice;
	private String Status;
	private float quantity;
	
	@OneToMany(mappedBy="marketPlace")
	private List<Bid> bids;
	
	@OneToOne(mappedBy="marketPlace")
	private CropsSold cropsSold;
	
	@OneToOne
	@JoinColumn(name="request_id")
	private Request request;

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public String getCropName() {
		return cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}

	public String getCropType() {
		return cropType;
	}

	public void setCropType(String cropType) {
		this.cropType = cropType;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
	
	

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public List<Bid> getBids() {
		return bids;
	}

	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public CropsSold getCropsSold() {
		return cropsSold;
	}

	public void setCropsSold(CropsSold cropsSold) {
		this.cropsSold = cropsSold;
	}
	
	
	
}
