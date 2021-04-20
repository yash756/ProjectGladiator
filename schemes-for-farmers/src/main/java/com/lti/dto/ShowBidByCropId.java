package com.lti.dto;

import java.util.List;

import com.lti.dto.Status;

public class ShowBidByCropId {

	private List<BidsDto> bids;
	private Status status;
	
	public List<BidsDto> getBids() {
		return bids;
	}
	public void setBids(List<BidsDto> bids) {
		this.bids = bids;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

}
