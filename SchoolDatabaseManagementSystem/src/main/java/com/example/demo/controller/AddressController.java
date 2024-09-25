package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Address;
import com.example.demo.service.AddressService;
import com.example.demo.utility.ResponseStructure;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService service;

	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestBody Address a,
			@PathVariable("id") int id) {
		ResponseStructure<Address> structure = service.updateAddress(a, id);
		return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.OK);
	}

//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<ResponseStructure<Address>> deleteAdress(@PathVariable("id") int id) {
//		service.de
//	}

	@GetMapping("/fetch/{id}")
	public ResponseEntity<ResponseStructure<Address>> fetchAddress(@PathVariable("id") int id) {
		ResponseStructure<Address> structure = service.fetchAddress(id);
		return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.OK);
	}
}
