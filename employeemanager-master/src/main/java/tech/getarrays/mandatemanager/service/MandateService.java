package tech.getarrays.mandatemanager.service;

import java.util.List;

import tech.getarrays.mandatemanager.model.Mandate;


public interface MandateService {
	Mandate createMandate(Mandate mandate);
	Mandate updateMandate(Mandate mandate);
	List<Mandate> getAllMandate(String Id);
	Mandate getMandateById(Long mandateId);
	void deleteMandate(Long mandateId);
	
}

