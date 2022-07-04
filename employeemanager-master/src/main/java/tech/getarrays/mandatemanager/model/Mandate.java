package tech.getarrays.mandatemanager.model;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mandates")
public class Mandate {
	@Id
	private Long mandateId;
	private String payerId; //(FK)
	private String payeeId; //FK
	private String mandateValidFrom;
	private String mandateValidTo;
	private String status;
	private String mandateRefNo;
	private Long branchCode;
	
	
	public Long getMandateId() {
		return mandateId;
	}
	public void setMandateId(Long mandateId) {
		this.mandateId = mandateId;
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
	}
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
	
	
	
}
