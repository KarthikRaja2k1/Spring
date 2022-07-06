package tech.getarrays.mandatemanager.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tech.getarrays.mandatemanager.model.Account;


@Repository
public interface AccountRepository extends JpaRepository<Account,String> {
	@Query(value="SELECT * FROM accounts",nativeQuery = true)
	List<Account> findAll();	
}
