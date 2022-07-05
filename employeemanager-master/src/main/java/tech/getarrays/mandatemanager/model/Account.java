package tech.getarrays.mandatemanager.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accounts")
public class Account {
	@Id
	String id;
	String accounType;
	String accountAliasType;
	String accountBIC;
	String ultimateAccountHolder;
	String linkedAccount;
	String accountIdType;
	String linkedPayId;
	String branchCode;
	String accountNumber;
	String name ;

}
