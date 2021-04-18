package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bid_details")
public class Bid {
	
	@Id
	@GeneratedValue
	@Column(name="bid_id")
	private int bidId;
	
	@Column(name="base_price")
	private double basePrice;
	@Column(name="bid_amount")
	private double bidAmount;
	@Column(name="date_of_bid")
	private LocalDate dateOfBid;
	
	@ManyToOne
	@JoinColumn(name="bidder_id")
	private Bidder bidder;

	@ManyToOne
	@JoinColumn(name="item_no")
	private MarketPlace marketPlace;

	public int getBidId() {
		return bidId;
	}

	public void setBidId(int bidId) {
		this.bidId = bidId;
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

	public LocalDate getDateOfBid() {
		return dateOfBid;
	}

	public void setDateOfBid(LocalDate dateOfBid) {
		this.dateOfBid = dateOfBid;
	}

	public Bidder getBidder() {
		return bidder;
	}

	public void setBidder(Bidder bidder) {
		this.bidder = bidder;
	}

	public MarketPlace getMarketplace() {
		return marketPlace;
	}

	public void setMarketplace(MarketPlace marketPlace) {
		this.marketPlace = marketPlace;
	}
	
	
	
}
