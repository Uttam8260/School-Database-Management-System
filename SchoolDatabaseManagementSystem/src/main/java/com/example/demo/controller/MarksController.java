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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Mark;
import com.example.demo.service.MarksService;
import com.example.demo.utility.ResponseStructure;

@RestController
@RequestMapping("/marks")
public class MarksController {

	@Autowired
	private MarksService service;
	
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Mark>> saveMarks(@RequestBody Mark marks,@RequestParam("studentId") int studentId,@RequestParam("subjectId")int subjectId){
		ResponseStructure<Mark> structure = service.saveMarks(marks, studentId, subjectId);
		return new ResponseEntity<ResponseStructure<Mark>>(structure, HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseStructure<Mark>> updateMarks(@RequestBody Mark marks,@PathVariable("id") int id){
		ResponseStructure<Mark> structure = service.updateMarks(marks,id);
		return new ResponseEntity<ResponseStructure<Mark>>(structure, HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseStructure<Mark>> deleteMarks(@PathVariable("id") int id){
		ResponseStructure<Mark> structure = service.deleteMarks(id);
		return new ResponseEntity<ResponseStructure<Mark>>(structure, HttpStatus.OK);
	}
	
	@GetMapping("/fetch/{id}")
	public ResponseEntity<ResponseStructure<Mark>> fetchMarksById(@PathVariable("id") int id){
		ResponseStructure<Mark> structure = service.fetchMarksById(id);
		return new ResponseEntity<ResponseStructure<Mark>>(structure, HttpStatus.OK);
	}
	@GetMapping("/fetchByStudent/{id}")
	public ResponseEntity<ResponseStructure<List<Mark>>> fetchMarksByStudentId(@PathVariable("id") int studentId){
		ResponseStructure<List<Mark>> structure = service.fetchMarksByStudentId(studentId);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}
	@GetMapping("/fetchBySubject/{id}")
	public ResponseEntity<ResponseStructure<List<Mark>>> fetchMarksBySubjectId(@PathVariable("id") int subjectId){
		ResponseStructure<List<Mark>> structure = service.fetchMarksBySubjectId(subjectId);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}
	
	
}
