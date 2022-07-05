package tech.getarrays.mandatemanager.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.annotation.JsonProperty;

import tech.getarrays.mandatemanager.model.Account;
import tech.getarrays.mandatemanager.model.Mandate;
import tech.getarrays.mandatemanager.service.AccountService;

public class AccountController {

	@Autowired
	AccountService accountService;
	
	@PostMapping("/accounts")
	@JsonProperty("Params")
	public ResponseEntity<List<Account>> getAllMandate(@RequestBody HashMap<String, String> Params) {
		System.out.println(Params.entrySet());
		for (String key : Params.keySet()) {
			if (Params.get(key) == null)
				Params.replace(key, "%");
		}
		return ResponseEntity.ok()
				.body(accountService.getAllAccount());

	}
	@GetMapping("/accounts/{id}")
	public ResponseEntity<Mandate> getMandateById(@PathVariable Long id) {
		return ResponseEntity.ok().body(accountService.getAccountById(id));
	}
}
