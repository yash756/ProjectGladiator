package com.lti.dto;

import java.time.LocalDate;

public class PlaceBidDto {
	
	
	private double bidAmount;
	private int bidderId;
	private int itemNo;
	//private LocalDate dateOfBid;
	
	public double getBidAmount() {
		return bidAmount;
	}
	
	
	public void setBidAmount(double bidAmount) {
		this.bidAmount = bidAmount;
	}
	public int getBidderId() {
		return bidderId;
	}
	public void setBidderId(int bidderId) {
		this.bidderId = bidderId;
	}
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	/*public LocalDate getDateOfBid() {
		return dateOfBid;
	}
	public void setDateOfBid(LocalDate dateOfBid) {
		this.dateOfBid = dateOfBid;
	}*/

	
	
	


	

}
