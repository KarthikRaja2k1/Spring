package tech.getarrays.mandatemanager.service;

import java.util.List;
import java.util.Optional;

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
	public List<Mandate> getAllMandate(String Id) {
		if(Id!=null)
		return this.mandateRepository.findByIdLike(Id);
		
		return this.mandateRepository.findAll();
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

}
