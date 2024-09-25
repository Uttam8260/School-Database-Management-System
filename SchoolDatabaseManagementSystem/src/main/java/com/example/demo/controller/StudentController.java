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

import com.example.demo.entity.Student;
import com.example.demo.service.AddressService;
import com.example.demo.service.StudentService;
import com.example.demo.utility.ResponseStructure;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService service;

	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student s) {
		ResponseStructure<Student> structure = service.saveStudent(s);

		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseStructure<Student>> updateStudent(@RequestBody Student s,
			@PathVariable("id") int id) {
		ResponseStructure<Student> structure = service.updateStudent(s, id);
		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseStructure<Student>> deleteStudentByID(@PathVariable("id") int id) {
		ResponseStructure<Student> structure = service.deleteStudentByID(id);
		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
	}

	@DeleteMapping("/deleteByNUmber/{number}")
	public ResponseEntity<ResponseStructure<Student>> deleteStudentByNumber(@PathVariable("number") String number) {
		ResponseStructure<Student> structure = service.deleteStudentByNumber(number);
		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
	}

	@GetMapping("/fetch/{id}")
	public ResponseEntity<ResponseStructure<Student>> fetchStudentByID(@PathVariable("id") int id) {
		ResponseStructure<Student> structure = service.fetchStudentByID(id);
		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
	}

	@GetMapping("/fetchByNumber/{number}")
	public ResponseEntity<ResponseStructure<Student>> fetchStudentByNumber(@PathVariable("number") String number) {
		ResponseStructure<Student> structure = service.fetchStudentByNumber(number);
		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
	}

	@GetMapping("/fetchByClassName/{className}")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchStudentsByClassName(
			@PathVariable("className") String classsName) {
		ResponseStructure<List<Student>> structure = service.fetchStudentsByClassName(classsName);
		return new ResponseEntity<ResponseStructure<List<Student>>>(structure, HttpStatus.OK);
	}

}
