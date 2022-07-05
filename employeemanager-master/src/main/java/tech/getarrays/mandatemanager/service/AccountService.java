package tech.getarrays.mandatemanager.service;

import java.util.List;

import tech.getarrays.mandatemanager.model.Account;
import tech.getarrays.mandatemanager.model.Mandate;

public interface AccountService {
	List<Account> getAllAccount();
	Account getAccountById(String mandateId);
}
