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
import com.example.demo.entity.Teacher;
import com.example.demo.service.AddressService;
import com.example.demo.service.StudentService;
import com.example.demo.service.TeacherService;
import com.example.demo.utility.ResponseStructure;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	private TeacherService service;

	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Teacher>> saveTeacher(@RequestBody Teacher s) {
		ResponseStructure<Teacher> structure = service.saveTeacher(s);
		return new ResponseEntity<ResponseStructure<Teacher>>(structure, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseStructure<Teacher>> updateTeacher(@RequestBody Teacher s,
			@PathVariable("id") int id) {
		ResponseStructure<Teacher> structure = service.updateTeacher(s,id);
		return new ResponseEntity<ResponseStructure<Teacher>>(structure, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseStructure<Teacher>> deleteTeacherByID(@PathVariable("id") int id) {
		ResponseStructure<Teacher> structure = service.deleteTeacherByID(id);
		return new ResponseEntity<ResponseStructure<Teacher>>(structure, HttpStatus.OK);
	}

	@DeleteMapping("/deleteByNUmber/{number}")
	public ResponseEntity<ResponseStructure<Teacher>> deleteTeacherByNumber(@PathVariable("number") String number) {
		ResponseStructure<Teacher> structure = service.deleteTeacherByNumber(number);
		return new ResponseEntity<ResponseStructure<Teacher>>(structure, HttpStatus.OK);
	}

	@GetMapping("/fetch/{id}")
	public ResponseEntity<ResponseStructure<Teacher>> fetchTeacherByID(@PathVariable("id") int id) {
		ResponseStructure<Teacher> structure = service.fetchTeacherByID(id);
		return new ResponseEntity<ResponseStructure<Teacher>>(structure, HttpStatus.OK);
	}

	@GetMapping("/fetchByNumber/{number}")
	public ResponseEntity<ResponseStructure<Teacher>> fetchTeacherByNumber(@PathVariable("number") String number) {
		ResponseStructure<Teacher> structure = service.fetchTeacherByNumber(number);
		return new ResponseEntity<ResponseStructure<Teacher>>(structure, HttpStatus.OK);
	}

	@GetMapping("/fetchByClassName/{className}")
	public ResponseEntity<ResponseStructure<List<Teacher>>> fetchTeachersByClassName(
			@PathVariable("className") String classsName) {
		ResponseStructure<List<Teacher>> structure = service.fetchTeachersByClassName(classsName);
		return new ResponseEntity<ResponseStructure<List<Teacher>>>(structure, HttpStatus.OK);
	}

}
