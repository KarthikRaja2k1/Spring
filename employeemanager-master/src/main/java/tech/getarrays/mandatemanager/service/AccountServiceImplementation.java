package tech.getarrays.mandatemanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import tech.getarrays.mandatemanager.exception.ResourceNotFoundException;
import tech.getarrays.mandatemanager.model.Account;
import tech.getarrays.mandatemanager.repo.AccountRepository;

public class AccountServiceImplementation implements AccountService {
	@Autowired
	private AccountRepository accountRepository;
	@Override
	public List<Account> getAllAccount() {
		return this.accountRepository.findAll();
	}
	@Override
	public Account getAccountById(String accountId) {
		Optional<Account> accountObject = this.accountRepository.findById(accountId);

		if (accountObject.isPresent()) {
			return accountObject.get();
		} else {
			throw new ResourceNotFoundException("Mandate Not found" + accountId);
		}
	}
	

}
