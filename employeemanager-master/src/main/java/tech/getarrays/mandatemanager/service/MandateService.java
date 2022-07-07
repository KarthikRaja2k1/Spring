package tech.getarrays.mandatemanager.service;

import java.util.List;

import tech.getarrays.mandatemanager.displayformat.MandateTable;
import tech.getarrays.mandatemanager.model.Mandate;


public interface MandateService {
	Mandate createMandate(Mandate mandate);
	Mandate updateMandate(Mandate mandate);
	Mandate getMandateById(Long mandateId);
	void deleteMandate(Long mandateId);
	public List<Object> getForAutoComplete(String field, String branchCode,String mandateId, String mandateType, String accountNumber);
	List<MandateTable> getAllMandate(String branchCode, String mandateType, String mandateId, String accountNumber);
}

