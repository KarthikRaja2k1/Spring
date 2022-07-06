package tech.getarrays.mandatemanager.service;

import java.util.List;

import tech.getarrays.mandatemanager.model.Account;


public interface AccountService {
	List<Account> getAllAccount();
	Account getAccountById(String mandateId);
	List<String> getForAutoComplete(String field, String accountId, String accountType, String linkedAccount);
}
