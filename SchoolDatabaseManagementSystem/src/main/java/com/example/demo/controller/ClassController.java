package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Class;
import com.example.demo.service.AddressService;
import com.example.demo.service.ClassService;
import com.example.demo.utility.ResponseStructure;

@RestController
@RequestMapping("/class")
public class ClassController {

	@Autowired
	private ClassService service;

	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Class>> saveClass(@RequestBody Class c) {
		ResponseStructure<Class> structure = service.saveClass(c);
		return new ResponseEntity<ResponseStructure<Class>>(structure, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseStructure<Class>> updateClass(@RequestBody Class c, @PathVariable("id") int id) {
		ResponseStructure<Class> structure = service.updateClass(c, id);
		return new ResponseEntity<ResponseStructure<Class>>(structure, HttpStatus.OK);
	}

	@GetMapping("/fetch/{id}")
	public ResponseEntity<ResponseStructure<Class>> fetchClassByID(@PathVariable("id") int id) {
		ResponseStructure<Class> structure = service.fetchClassByID(id);
		return new ResponseEntity<ResponseStructure<Class>>(structure, HttpStatus.OK);
	}

	@GetMapping("/fetchByYear/{year}")
	public ResponseEntity<ResponseStructure<List<Class>>> fetchClassesByAcademiCYear(@PathVariable("year") int year) {
		ResponseStructure<List<Class>> structure = service.fetchClassesByAcademiCYear(year);
		return new ResponseEntity<ResponseStructure<List<Class>>>(structure, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseStructure<Class>> deleteClassBYId(@PathVariable("id") int id) {
		ResponseStructure<Class> structure = service.deleteClassBYId(id);
		return new ResponseEntity<ResponseStructure<Class>>(structure, HttpStatus.OK);
	}

	@DeleteMapping("/deleteByYear/{year}")
	public ResponseEntity<ResponseStructure<Class>> deleteClassBYYear(@PathVariable("year") int year) {
		ResponseStructure<Class> structure = service.deleteClassBYYear(year);
		return new ResponseEntity<ResponseStructure<Class>>(structure, HttpStatus.OK);
	}

}
