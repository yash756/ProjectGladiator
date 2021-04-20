package com.lti.dto;

import com.lti.dto.Status;

public class MaxBid {

	private double amount;
	private Status status;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
