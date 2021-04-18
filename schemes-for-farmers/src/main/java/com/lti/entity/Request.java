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
@Table(name="request_tbl")
public class Request {

	@Id
	@GeneratedValue
	@Column(name="request_id")
	private int requestId;
	
	@Column(name="crop_type")
	private String cropType;
	@Column(name="crop_name")
	private String cropName;
	@Column(name="fertilizer_type")
	private String fertilizerType;
	private float quantity;
	
	@Column(name="base_price")
	private double basePrice;
	
	
	private float soilPh;
	
//	@Column(name="start_date")
//	private LocalDate startDate;
	@Column(name="bid_cutt_off_time")
	private double bidCutoffTime;
//	@Column(name="end_date")
//	private LocalDate endDate;
	
	@OneToOne(mappedBy="request")
	private MarketPlace marketplace;
	
	@ManyToOne
	@JoinColumn(name="farmer_id")
	private Farmer farmer;

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getCropType() {
		return cropType;
	}

	public void setCropType(String cropType) {
		this.cropType = cropType;
	}

	public String getCropName() {
		return cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}

	public String getFertilizerType() {
		return fertilizerType;
	}

	public void setFertilizerType(String fertilizerType) {
		this.fertilizerType = fertilizerType;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	
	

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public float getSoilPh() {
		return soilPh;
	}

	public void setSoilPh(float soilPh) {
		this.soilPh = soilPh;
	}
	
	

	public double getBidCutoffTime() {
		return bidCutoffTime;
	}

	public void setBidCutoffTime(double bidCutoffTime) {
		this.bidCutoffTime = bidCutoffTime;
	}

//	public LocalDate getStartDate() {
//		return startDate;
//	}
//
//	public void setStartDate(LocalDate startDate) {
//		this.startDate = startDate;
//	}
//
//	public LocalDate getEndDate() {
//		return endDate;
//	}
//
//	public void setEndDate(LocalDate endDate) {
//		this.endDate = endDate;
//	}

	public MarketPlace getMarketplace() {
		return marketplace;
	}

	public void setMarketplace(MarketPlace marketplace) {
		this.marketplace = marketplace;
	}

	public Farmer getFarmer() {
		return farmer;
	}

	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}
	
	
	
	
	
	
}
