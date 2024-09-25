package com.example.demo.serviceImplementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentDao;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import com.example.demo.utility.ResponseStructure;

@Service
public class StudentServiceImplementation implements StudentService {

	@Autowired
	private StudentDao dao;

	@Override
	public ResponseStructure<Student> saveStudent(Student s) {
		Student student = dao.saveStudent(s);
		return new ResponseStructure<>(201, "Student data is saved succesfully", student, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Student> updateStudent(Student s, int id) {
		Student student = dao.updateStudent(s, id);
		return new ResponseStructure<>(200, "Student data is updated succesfully", student, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Student> deleteStudentByID(int id) {
		boolean b = dao.deleteStudentByID(id);
		return new ResponseStructure<>(204, "Student is deleted succesfully", null, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Student> deleteStudentByNumber(String number) {
		boolean b = dao.deleteStudentByNumber(number);
		return new ResponseStructure<>(204, "Student is deleted succesfully", null, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Student> fetchStudentByID(int id) {
		Student student = dao.fetchStudentByID(id);
		return new ResponseStructure<>(200, "Student data is fetched succesfully", student, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Student> fetchStudentByNumber(String number) {
		Student student = dao.fetchStudentByNumber(number);
		return new ResponseStructure<>(200, "Student data is fetched succesfully", student, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<List<Student>> fetchStudentsByClassName(String className) {
		List<Student> list = dao.fetchStudentsByClassName(className);
		return new ResponseStructure<>(200, "List of Students data is fetched succesfully", list, LocalDateTime.now());
	}
}
