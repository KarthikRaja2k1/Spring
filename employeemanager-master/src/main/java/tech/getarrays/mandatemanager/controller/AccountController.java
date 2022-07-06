package tech.getarrays.mandatemanager.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonProperty;

import tech.getarrays.mandatemanager.model.Account;
import tech.getarrays.mandatemanager.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@GetMapping("/accounts")
	public ResponseEntity<List<Account>> getAllMandate() {
//		System.out.println(Params.entrySet());
//		for (String key : Params.keySet()) {
//			if (Params.get(key) == null)
//				Params.replace(key, "%");
//		}
		return ResponseEntity.ok()
				.body(accountService.getAllAccount());

	}
	@GetMapping("/accounts/{id}")
	public ResponseEntity<Account> getMandateById(@PathVariable String id) {
		return ResponseEntity.ok().body(accountService.getAccountById(id));
	}
	
	@PostMapping("/accounts/autocomplete")
	@JsonProperty("Params")
	public ResponseEntity<List<String>> getAutocomplete(@RequestBody HashMap<String, String> Params) {
		HashMap<String, String> map = new HashMap<>();
		  
        // Adding elements to the Map
        // using standard put() method
        map.put("accountId", "account_id");
        map.put("accountType", "account_type");
        map.put("linkedAccount", "linked_account");
        
		for (String Key : Params.keySet()) {
			if (Params.get(Key) == null) {
				Params.replace(Key, "%");
			}
		}
		return ResponseEntity.ok().body(
				accountService.getForAutoComplete(map.get(Params.get("field")),Params.get("accountId"), Params.get("accountType"),Params.get("linkedAccount")));
	
	}
}
