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
import com.mandatemanager.displayformat.MandateTable;

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
				mandateService.getForAutoComplete("branch_code", Params.get("branchCode"), Params.get("mandateType")));
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
				mandateService.getForAutoComplete("mandate_type", Params.get("branchCode"), Params.get("mandateType")));
	}

	@GetMapping("/mandates/{id}")
	public ResponseEntity<Mandate> getMandateById(@PathVariable Long id) {
		return ResponseEntity.ok().body(mandateService.getMandateById(id));
	}

	@PutMapping("/mandates/{id}")
	public ResponseEntity<Mandate> updateMandate(@PathVariable Long id, @RequestBody Mandate mandate) {
		return ResponseEntity.ok().body(mandateService.getMandateById(id));
	}

}