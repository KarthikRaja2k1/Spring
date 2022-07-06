package tech.getarrays.mandatemanager.controller;



import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonProperty;

import tech.getarrays.mandatemanager.displayformat.MandateTable;
import tech.getarrays.mandatemanager.model.Mandate;
import tech.getarrays.mandatemanager.service.MandateService;

@RestController
public class MandateController {

	@Autowired
	MandateService mandateService;

	@PostMapping("/mandates")
	@JsonProperty("Params")
	public ResponseEntity<List<MandateTable>> getAllMandate(@RequestBody HashMap<String, String> Params) {
		System.out.println(Params.entrySet());
		for (String key : Params.keySet()) {
			if (Params.get(key) == null)
				Params.replace(key, "%");
		}
		return ResponseEntity.ok()
				.body(mandateService.getAllMandate(Params.get("branchCode"), Params.get("mandateType")));

	}

	@GetMapping("/branchCode")
	@JsonProperty("Params")
	public ResponseEntity<List<String>> getBranchCodes(@RequestBody HashMap<String, String> Params) {
		for (String Key : Params.keySet()) {
			if (Params.get(Key) == null) {
				Params.replace(Key, "%");
			}
		}
		return ResponseEntity.ok().body(
				mandateService.getForAutoComplete("branch_code",Params.get("branchCode"), Params.get("mandateId"),Params.get("mandateType"),Params.get("accountNumber")));
	}

	@PostMapping("/mandateType")
	@JsonProperty("Params")
	public ResponseEntity<List<String>> getMandateType(@RequestBody HashMap<String, String> Params) {
		for (String Key : Params.keySet()) {
			if (Params.get(Key) == null) {
				Params.replace(Key, "%");
			}
		}
		return ResponseEntity.ok().body(
				mandateService.getForAutoComplete("mandate_type",Params.get("branchCode"), Params.get("mandateId"),Params.get("mandateType"),Params.get("accountNumber")));
	}
	@PostMapping("/mandates/autocomplete")
	@JsonProperty("Params")
	public ResponseEntity<List<String>> getAutocomplete(@RequestBody HashMap<String, String> Params) {
		HashMap<String, String> map = new HashMap<>();
		System.out.println("came to auto"+Params);
        // Adding elements to the Map
        // using standard put() method
        map.put("branchCode", "branch_code");
        map.put("mandateId", "mandates.id");
        map.put("mandateType", "mandate_type");
        map.put("accountNumber", "account_number");
        
		for (String Key : Params.keySet()) {
			if (Params.get(Key) == null) {
				Params.replace(Key, "%");
			}
		}
		System.out.println("From conteoller"+mandateService.getForAutoComplete(map.get(Params.get("field")),Params.get("branchCode"), Params.get("mandateId"),Params.get("mandateType"),Params.get("accountNumber")));
		return ResponseEntity.ok().body(
				mandateService.getForAutoComplete(map.get(Params.get("field")),Params.get("branchCode"), Params.get("mandateId"),Params.get("mandateType"),Params.get("accountNumber")));
	
	}

	@GetMapping("/mandates/{id}")
	public ResponseEntity<Mandate> getMandateById(@PathVariable Long id) {
		return ResponseEntity.ok().body(mandateService.getMandateById(id));
	}

	@PutMapping("/mandates")
	public ResponseEntity<Mandate> updateMandate( @RequestBody Mandate mandate) {
		return ResponseEntity.ok().body(mandateService.updateMandate(mandate));
	}

}