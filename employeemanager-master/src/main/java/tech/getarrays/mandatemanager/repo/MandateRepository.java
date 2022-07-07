package tech.getarrays.mandatemanager.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tech.getarrays.mandatemanager.displayformat.MandateTable;
import tech.getarrays.mandatemanager.model.Mandate;

@Repository
public interface MandateRepository extends JpaRepository<Mandate,Long> {
	@Query(value="SELECT mandates.id as MandateId ,status as Status,FORMATDATETIME(valid_From ,'yyyy-MM-dd') as ValidFrom,FORMATDATETIME(valid_To,'yyyy-MM-dd') as ValidTo,payee.Name as PayeeName,payer.Name as PayerName FROM mandates,Accounts as payee, Accounts as payer WHERE payee_Id = payee.id and payer_Id=payer.id and mandates.branch_Code LIKE :branchCode% and mandate_type like :mandateType% and Cast(mandates.ID  as varchar(11))  like :mandateId% and payer.account_Number like :accountNumber% ",nativeQuery = true)
	List<MandateTable> findByQuery(@Param("branchCode") String branchCode,@Param("mandateType") String mandateType,@Param("mandateId") String mandateId,@Param("accountNumber") String accountNumber);

}
