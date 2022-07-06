package tech.getarrays.mandatemanager.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accounts")
public class Account {
	@Id
	String id;
	String accountType;
	String accountAliasType;
	String accountBIC;
	String ultimateAccountHolder;
	String linkedAccount;
	String accountIdType;
	String linkedPayId;
	String branchCode;
	String accountNumber;
	String name ;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountAliasType() {
		return accountAliasType;
	}
	public void setAccountAliasType(String accountAliasType) {
		this.accountAliasType = accountAliasType;
	}
	public String getAccountBIC() {
		return accountBIC;
	}
	public void setAccountBIC(String accountBIC) {
		this.accountBIC = accountBIC;
	}
	public String getUltimateAccountHolder() {
		return ultimateAccountHolder;
	}
	public void setUltimateAccountHolder(String ultimateAccountHolder) {
		this.ultimateAccountHolder = ultimateAccountHolder;
	}
	public String getLinkedAccount() {
		return linkedAccount;
	}
	public void setLinkedAccount(String linkedAccount) {
		this.linkedAccount = linkedAccount;
	}
	public String getAccountIdType() {
		return accountIdType;
	}
	public void setAccountIdType(String accountIdType) {
		this.accountIdType = accountIdType;
	}
	public String getLinkedPayId() {
		return linkedPayId;
	}
	public void setLinkedPayId(String linkedPayId) {
		this.linkedPayId = linkedPayId;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", accountType=" + accountType + ", accountAliasType=" + accountAliasType
				+ ", accountBIC=" + accountBIC + ", ultimateAccountHolder=" + ultimateAccountHolder + ", linkedAccount="
				+ linkedAccount + ", accountIdType=" + accountIdType + ", linkedPayId=" + linkedPayId + ", branchCode="
				+ branchCode + ", accountNumber=" + accountNumber + ", name=" + name + "]";
	}

}
