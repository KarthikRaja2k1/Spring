package tech.getarrays.mandatemanager.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tech.getarrays.mandatemanager.displayformat.MandateTable;
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
			//mandateUpdate.setId(mandate.getId());
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
	public List<MandateTable> getAllMandate( String branchCode,String mandateType, String mandateId,String accountNumber) {
		// System.out.println("DDDDDDDDD"+Id);
		// if(Id!=null)
		// return this.mandateRepository.findByIdLike(Id);
		if (branchCode == "" || branchCode == null) {
			branchCode = "%";
		}
		if (mandateType == "" || mandateType == null) {
			mandateType = "%";
		}
		return this.mandateRepository.findByQuery(branchCode, mandateType,mandateId,accountNumber);
		// return this.mandateRepository.findAll();
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
	public List<Object> getForAutoComplete(String field, String branchCode,String mandateId, String mandateType, String accountNumber) {
		String queryString = "select distinct ";
		queryString += field;
		if (branchCode == "" || branchCode == null) {
			branchCode = "%";
		}
		if (mandateType == "" || mandateType == null) {
			mandateType = "%";
		}
		if (mandateId == "" || mandateId == null) {
			mandateId = "%";
		}
		if(accountNumber=="" || accountNumber==null) {
			accountNumber="%";}
		queryString += " from mandates where branch_code like '" + branchCode + "%' " + "and mandate_type like '"
				+ mandateType + "%' " + " and Cast(mandates.ID  as varchar(11) )  like '" + mandateId + "%' " ;
		Query q = entityManager.createNativeQuery(queryString);
		return q.getResultList();
	}

	}
