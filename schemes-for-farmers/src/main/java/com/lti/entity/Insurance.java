package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_insurance")
public class Insurance {
	
	@Id
	@GeneratedValue
	@Column(name = "insurance_policyNo")
	private int policyNo;
	
	@Column(name = "insurance_company")
	private String InsuranceCompany;
	
	@Column(name = "insurance_sumInsured")
	private long sumInsured;

	@Column(name = "insurance_sharePremium")//to be paid by farmer
	private long sharePremium;

	@Column(name = "insurance_premium")//to be paid by govt
	private long premium;

	@Column(name = "insurance_cropName")
	private String cropName;
	
	@Column(name = "insurance_area")
	private long area;
	
	@Column(name = "insurance_season")
	private String season;

	@Column(name = "insurance_year")
	private LocalDate year;
	
	@OneToOne
	@JoinColumn(name = "farmer_id")
	private Farmer farmer;
	
	@OneToOne(mappedBy = "insurance")
	private ClaimInsurance claim;

	public int getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(int policyNo) {
		this.policyNo = policyNo;
	}

	public String getInsuranceCompany() {
		return InsuranceCompany;
	}

	public void setInsuranceCompany(String insuranceCompany) {
		InsuranceCompany = insuranceCompany;
	}

	public long getSumInsured() {
		return sumInsured;
	}

	public void setSumInsured(long sumInsured) {
		this.sumInsured = sumInsured;
	}

	public long getSharePremium() {
		return sharePremium;
	}

	public void setSharePremium(long sharePremium) {
		this.sharePremium = sharePremium;
	}

	public long getPremium() {
		return premium;
	}

	public void setPremium(long premium) {
		this.premium = premium;
	}

	public String getCropName() {
		return cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}

	public long getArea() {
		return area;
	}

	public void setArea(long area) {
		this.area = area;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public LocalDate getYear() {
		return year;
	}

	public void setYear(LocalDate year) {
		this.year = year;
	}

	public Farmer getFarmer() {
		return farmer;
	}

	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}

	public ClaimInsurance getClaim() {
		return claim;
	}

	public void setClaim(ClaimInsurance claim) {
		this.claim = claim;
	}
	
	


}
