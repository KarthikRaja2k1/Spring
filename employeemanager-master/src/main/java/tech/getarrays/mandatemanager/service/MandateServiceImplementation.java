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
import tech.getarrays.mandatemanager.model.Mandate;
import tech.getarrays.mandatemanager.repo.MandateRepository;

@Service
@Transactional
public class MandateServiceImplementation implements MandateService {

	@Autowired
	private MandateRepository mandateRepository;

	@PersistenceContext
    private EntityManager entityManager;
	@Override
	public Mandate createMandate(Mandate mandate) {
		return mandateRepository.save(mandate);

	}

	@Override
	public Mandate updateMandate(Mandate mandate) {
		Optional<Mandate> mandateObject = this.mandateRepository.findById(mandate.getId());

		if (mandateObject.isPresent()) {
			Mandate mandateUpdate = mandateObject.get();
			mandateUpdate.setId(mandate.getId());
			mandateUpdate.setPayerId(mandate.getPayerId());
			// mandateUpdate.setId(mandate.getId());
			// mandateUpdate.setId(mandate.getId());
			mandateRepository.save(mandateUpdate);
			return mandateUpdate;

		} else {
			throw new ResourceNotFoundException("Mandate Not found" + mandate.getId());
		}
	}

	@Override
	public List<Mandate> getAllMandate(String branchCode,String mandateType) {
//		System.out.println("DDDDDDDDD"+Id);
//		if(Id!=null)
//		return this.mandateRepository.findByIdLike(Id);
		if(branchCode=="" || branchCode==null) {
			branchCode="%";
		}
		if(mandateType=="" || mandateType==null) {
			mandateType="%";
		}
		return this.mandateRepository.findByQuery(branchCode, mandateType);
//		return this.mandateRepository.findAll();
	}

	@Override
	public Mandate getMandateById(Long mandateId) {
		Optional<Mandate> mandateObject = this.mandateRepository.findById(mandateId);

		if (mandateObject.isPresent()) {
			return mandateObject.get();
		} else {
			throw new ResourceNotFoundException("Mandate Not found" + mandateId);
		}
	}

	@Override
	public void deleteMandate(Long mandateId) {
		Optional<Mandate> mandateObject = this.mandateRepository.findById(mandateId);

		if (mandateObject.isPresent()) {
			this.mandateRepository.delete(mandateObject.get());
		} else {
			throw new ResourceNotFoundException("Mandate Not found" + mandateId);
		}

	}
	
	@Override
	public List<String> getForAutoComplete(String field, String branchCode, String mandateType){
		String queryString="select distinct ";
		queryString+=field;
		if(branchCode=="" || branchCode==null) {
			branchCode="%";
		}
		if(mandateType=="" || mandateType==null) {
			mandateType="%";
		}
		queryString+= " from mandates where branch_code like '"+branchCode+"%' "+"and mandate_type like '"+mandateType+"%'";
		Query q= entityManager.createNativeQuery(queryString);
		System.out.println(q.getResultList());
    	return q.getResultList();
	}

}
