package tech.getarrays.mandatemanager.service;

import java.util.List;

import tech.getarrays.mandatemanager.model.Mandate;


public interface MandateService {
	Mandate createMandate(Mandate mandate);
	Mandate updateMandate(Mandate mandate);
	List<Mandate> getAllMandate(String branchCode,String mandateType);
	Mandate getMandateById(Long mandateId);
	void deleteMandate(Long mandateId);
	public List<String> getForAutoComplete(String field, String branchCode, String mandateType);
}

