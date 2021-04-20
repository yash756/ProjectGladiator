package com.lti.dto;

import java.util.List;

import com.lti.dto.Status;

public class CropsDto {

	private List<ShowAllCropsDto> crops;
	private Status status;

	public List<ShowAllCropsDto> getCrops() {
		return crops;
	}

	public void setCrops(List<ShowAllCropsDto> crops) {
		this.crops = crops;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
