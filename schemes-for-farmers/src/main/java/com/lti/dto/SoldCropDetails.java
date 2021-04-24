package com.lti.dto;

public class SoldCropDetails {
	
	private int itemNo;
	private String cropName;
	private float quantity;
	private double basePrice;
	private double bidAmount;
	private int requestId;
	
	public SoldCropDetails() {
		// TODO Auto-generated constructor stub
	}

	public SoldCropDetails(int itemNo, String cropName, float quantity, double basePrice, double bidAmount,
			int requestId) {
		super();
		this.itemNo = itemNo;
		this.cropName = cropName;
		this.quantity = quantity;
		this.basePrice = basePrice;
		this.bidAmount = bidAmount;
		this.requestId = requestId;
	}

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

	public double getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(double bidAmount) {
		this.bidAmount = bidAmount;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	
	

}
