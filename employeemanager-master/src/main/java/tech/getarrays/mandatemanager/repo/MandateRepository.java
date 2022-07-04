package tech.getarrays.mandatemanager.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tech.getarrays.mandatemanager.model.Mandate;

@Repository
public interface MandateRepository extends JpaRepository<Mandate,Long> {
	@Query(value="SELECT * FROM mandates WHERE branch_code LIKE :branchCode% and mandate_type like :mandateType%",nativeQuery = true)
	List<Mandate> findByQuery(@Param("branchCode") String branchCode,@Param("mandateType") String mandateType);

}
