package tech.getarrays.mandatemanager.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tech.getarrays.mandatemanager.exception.ResourceNotFoundException;
import tech.getarrays.mandatemanager.model.Account;
import tech.getarrays.mandatemanager.repo.AccountRepository;

@Service
@Transactional
public class AccountServiceImplementation implements AccountService {
	@Autowired
	private AccountRepository accountRepository;
	@PersistenceContext
	private EntityManager entityManager;
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
	
	public List<String> getForAutoComplete(String field, String accountId, String accountType, String linkedAccount) {
		String queryString = "select distinct ";
		queryString += field;
		if (accountId == "" || accountId == null) {
			accountId = "%";
		}
		if (accountType == "" || accountType == null) {
			accountType = "%";
		}
		if (linkedAccount == "" || linkedAccount == null) {
			linkedAccount = "%";
		}
		queryString += " from accounts where id like '" + accountId + "%' " + "and account_type like '"
				+ accountType + "%'" + "and linked_account like '"+ linkedAccount +"%'";
		Query q = entityManager.createNativeQuery(queryString);
		return q.getResultList();
	}

}
