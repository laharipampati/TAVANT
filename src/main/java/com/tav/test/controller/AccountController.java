package com.tav.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tav.test.exception.EmptyObjectException;
import com.tav.test.exception.ModelNotFoundException;
import com.tav.test.exception.NoDataFoundException;
import com.tav.test.model.Account;
import com.tav.test.repository.AccountRepository;

@RestController
@RequestMapping("/api/account")
public class AccountController {

	@Autowired
	AccountRepository accountRepository;
	
	@GetMapping
	public String getAccount() {
		return "Welcome";
	}
	
	@GetMapping("/all") 
	public List<Account> getAllAccounts() throws NoDataFoundException {
	
        return Optional.ofNullable(
        		accountRepository.findAll().isEmpty() ? null :accountRepository.findAll()
                ).orElseThrow(()->new NoDataFoundException("NO RECORDS FOUND"));
		
	}
	
	@GetMapping("/{accId}")
	public ResponseEntity<?> getEmployeeId(@PathVariable("accId") Integer id) throws ModelNotFoundException {
		
		Optional<Account> optional = accountRepository.findById(id);
		
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		else {
			
			throw new ModelNotFoundException("Record Not Found");
		}
	}
	
	@PostMapping
	public Account addEmployee(@RequestBody @Valid Account account) 
			throws EmptyObjectException {
		
		if(account.getAccId()==null)
			throw new EmptyObjectException("No data in POST");
		return accountRepository.save(account);
	}
	
	@PutMapping("/{accId}")
	public ResponseEntity<Account> updateAccount(@PathVariable("accId")
	Integer id , @Valid @RequestBody Account customerDetails)
			throws ModelNotFoundException {
		
		Account acc = accountRepository.findById(id).
				orElseThrow(()->new ModelNotFoundException("Record Not Found"));
				
		acc.setAccHolderName(customerDetails.getAccHolderName());
		acc.setPhone(customerDetails.getPhone());
		
		final Account newDetails= accountRepository.save(acc);
		return ResponseEntity.ok(newDetails);
	}
	
	@DeleteMapping("/{accId}")
	public Map<String,Boolean> deleteCustomer(@PathVariable("accId") Integer id)
			throws ModelNotFoundException {
		

		Account acc = accountRepository.findById(id).
				orElseThrow(()->new ModelNotFoundException("Record Not Found"));
		
		accountRepository.delete(acc);
		Map<String,Boolean> response = new HashMap<>();
		response.put("Deleted",Boolean.TRUE);
		return response;
		
		}

}
