package com.lti.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_claim")
public class ClaimInsurance {
	
	@Id
	@GeneratedValue
	@Column(name = "claim_id")
	private int id;
	
	@Column(name = "claim_company")
	private String insuranceCompany;
	
	@Column(name = "claim_insureeName")
	private String insureeName;
	
	@Column(name = "claim_sumInsured")
	private double sumInsured;
	
	@Column(name = "claim_cause")
	private String cause;
	
	@Column(name = "claim_lossDate")
	private LocalDate lossDate;
	
	@OneToOne
	@JoinColumn(name = "insurance_policyNo")
	private Insurance insurance;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInsuranceCompany() {
		return insuranceCompany;
	}

	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}

	public String getInsureeName() {
		return insureeName;
	}

	public void setInsureeName(String insureeName) {
		this.insureeName = insureeName;
	}

	public double getSumInsured() {
		return sumInsured;
	}

	public void setSumInsured(double sumInsured) {
		this.sumInsured = sumInsured;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public LocalDate getLossDate() {
		return lossDate;
	}

	public void setLossDate(LocalDate lossDate) {
		this.lossDate = lossDate;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
	

}

