package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="crops_sold")
public class CropsSold {
	
	@Id
	@GeneratedValue
	@Column(name="order_id")
	private int orderId;
	
	@Column(name="crop_name")
	private String cropName;
	
	private float quantity;
	@Column(name="sold_price")
	private double soldPrice;
	@Column(name="base_price")
	private double basePrice;
	
	@Column(name="sold_date")
	private LocalDate date;
	
	//private int cropId;
	
	
	@OneToOne
	@JoinColumn(name="item_no")
	private MarketPlace marketPlace;
	
	
	@ManyToOne
	@JoinColumn(name="farmer_id")
	private Farmer farmer;
	
	@ManyToOne
	@JoinColumn(name="bidder_id")
	private Bidder bidder;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCropName() {
		return cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public double getSoldPrice() {
		return soldPrice;
	}

	public void setSoldPrice(double soldPrice) {
		this.soldPrice = soldPrice;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Farmer getFarmer() {
		return farmer;
	}

	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}

	public Bidder getBidder() {
		return bidder;
	}

	public void setBidder(Bidder bidder) {
		this.bidder = bidder;
	}

	public MarketPlace getMarketPlace() {
		return marketPlace;
	}

	public void setMarketPlace(MarketPlace marketPlace) {
		this.marketPlace = marketPlace;
	}
	
	
	

}
