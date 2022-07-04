package tech.getarrays.mandatemanager.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mandates")
public class Mandate {
	@Id
	private Long id;
	private String branchCode;
	private String payerId; // (FK)
	private String mandateType;
	private String payeeId; // (FK)
	private Boolean status;
	private Date validFrom;
	private Date validTo;

	public String getMandate_Type() {
		return mandateType;
	}

	public void setMandate_Type(String mandateType) {
		this.mandateType = mandateType;
	}

	// Branch code
	@Override
	public String toString() {
		return "Mandate [id=" + id + ", payerId=" + payerId + ", payeeId=" + payeeId + ", validFrom=" + validFrom
				+ ", validTo=" + validTo + ", status=" + status + ", refNo=" + refNo + ", branchCode=" + branchCode
				+ "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPayerId() {
		return payerId;
	}

	public void setPayerId(String payerId) {
		this.payerId = payerId;
	}

	public String getPayeeId() {
		return payeeId;
	}

	public void setPayeeId(String payeeId) {
		this.payeeId = payeeId;
	}

	public String getMandateValidFrom() {
		return mandateValidFrom;
	}

	public void setMandateValidFrom(String mandateValidFrom) {
		this.mandateValidFrom = mandateValidFrom;
	}

	public String getMandateValidTo() {
		return mandateValidTo;
	}

	public void setMandateValidTo(String mandateValidTo) {
		this.mandateValidTo = mandateValidTo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMandateRefNo() {
		return mandateRefNo;
	}

	public void setMandateRefNo(String mandateRefNo) {
		this.mandateRefNo = mandateRefNo;
	}<<<<<<<HEAD

	public Long getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(Long branchCode) {
		this.branchCode = branchCode;
	}

	@Override
	public String toString() {
		return "Mandate [mandateId=" + mandateId + ", payerId=" + payerId + ", payeeId=" + payeeId
				+ ", mandateValidFrom=" + mandateValidFrom + ", mandateValidTo=" + mandateValidTo + ", status=" + status
				+ ", mandateRefNo=" + mandateRefNo + ", branchCode=" + branchCode + "]";
	}

	=======

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	private String refNo;>>>>>>>7 bc2ad35bee12f9e6d1c8ddc5f25776272c368db

}
