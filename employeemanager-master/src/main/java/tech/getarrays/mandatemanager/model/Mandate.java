package tech.getarrays.mandatemanager.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mandates")
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
	public Date getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}
	public Date getValidTo() {
		return validTo;
	}
	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getRefNo() {
		return refNo;
	}
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	private String refNo;
	
}
