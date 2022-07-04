package tech.getarrays.mandatemanager.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accounts")
public class Account {
	@Id
	Long Account_ID;
	String Account_type;
	String Account_Alias_type;
	String Account_BIC;
	String Ultimate_account_holder;
	String Linked_account;
	String Account_ID_type;
	String Linked_PayID;
	String Branch_code;
	String Account_number;
	String Name ;

}
