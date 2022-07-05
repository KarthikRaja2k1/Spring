package tech.getarrays.mandatemanager.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mandatemanager.displayformat.MandateTable;

import tech.getarrays.mandatemanager.model.Mandate;

@Repository
public interface MandateRepository extends JpaRepository<Mandate,Long> {
	@Query(value="SELECT mandates.id as MandateId ,status as Status,FORMATDATETIME(valid_From ,'yyyy-MM-dd') as ValidFrom,FORMATDATETIME(valid_To,'yyyy-MM-dd') as ValidTo,A.Name as PayeeName,B.Name as PayerName FROM mandates,Accounts as A, Accounts as B WHERE payee_Id = A.id and payer_Id=B.id and mandates.branch_Code LIKE :branchCode% and mandate_type like :mandateType%",nativeQuery = true)
	List<MandateTable> findByQuery(@Param("branchCode") String branchCode,@Param("mandateType") String mandateType);

}
