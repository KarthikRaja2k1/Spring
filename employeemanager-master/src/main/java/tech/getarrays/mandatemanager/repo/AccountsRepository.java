package tech.getarrays.mandatemanager.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.getarrays.mandatemanager.model.Account;


@Repository
public interface AccountsRepository extends JpaRepository<Account,Long> {
	
}
