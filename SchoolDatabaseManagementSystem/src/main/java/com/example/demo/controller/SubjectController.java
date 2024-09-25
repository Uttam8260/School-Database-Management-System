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

import com.example.demo.entity.Subject;
import com.example.demo.service.AddressService;
import com.example.demo.service.SubjectService;
import com.example.demo.utility.ResponseStructure;

@RestController
@RequestMapping("/subject")
public class SubjectController {

	@Autowired
	private SubjectService service;

	@PostMapping("/save/{className}")
	public ResponseEntity<ResponseStructure<Subject>> saveSubject(@RequestBody Subject s,
			@PathVariable("className") String className) {
		ResponseStructure<Subject> structure = service.saveSubject(s, className);
		return new ResponseEntity<ResponseStructure<Subject>>(structure, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseStructure<Subject>> updateSubject(@RequestBody Subject s,
			@PathVariable("id") int id) {
		ResponseStructure<Subject> structure = service.updateSubject(s, id);
		return new ResponseEntity<ResponseStructure<Subject>>(structure, HttpStatus.OK);
	}

	@GetMapping("/fetch/{id}")
	public ResponseEntity<ResponseStructure<Subject>> fetchSubjectByID(@PathVariable("id") int id) {
		ResponseStructure<Subject> structure = service.fetchSubjectByID(id);
		return new ResponseEntity<ResponseStructure<Subject>>(structure, HttpStatus.OK);
	}

	@GetMapping("/fetchByCode/{code}")
	public ResponseEntity<ResponseStructure<Subject>> fetchSubjectByCode(@PathVariable("code") String code) {
		ResponseStructure<Subject> structure = service.fetchSubjectByCode(code);
		return new ResponseEntity<ResponseStructure<Subject>>(structure, HttpStatus.OK);
	}

	@GetMapping("/fetchByClassName/{className}")
	public ResponseEntity<ResponseStructure<List<Subject>>> fetchSubjectByClassName(
			@PathVariable("className") String className) {
		ResponseStructure<List<Subject>> structure = service.fetchSubjectByClassName(className);
		return new ResponseEntity<ResponseStructure<List<Subject>>>(structure, HttpStatus.OK);
	}

	@GetMapping("/fetchByStudentId/{id}")
	public ResponseEntity<ResponseStructure<List<Subject>>> fetchSubjectByStudentId(@PathVariable("id") int id) {
		ResponseStructure<List<Subject>> structure = service.fetchSubjectByStudentId(id);
		return new ResponseEntity<ResponseStructure<List<Subject>>>(structure, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseStructure<Subject>> deleteSubjectByID(@PathVariable("id") int id) {
		ResponseStructure<Subject> structure = service.deleteSubjectByID(id);
		return new ResponseEntity<ResponseStructure<Subject>>(structure, HttpStatus.OK);
	}

}
