package com.example.demo.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Student;
import com.example.demo.utility.ResponseStructure;

public interface StudentService {

	ResponseStructure<Student> saveStudent(Student s);

	ResponseStructure<Student> updateStudent(Student s, int id);

	ResponseStructure<Student> deleteStudentByID(int id);

	ResponseStructure<Student> deleteStudentByNumber(String number);

	ResponseStructure<Student> fetchStudentByID(int id);

	ResponseStructure<Student> fetchStudentByNumber(String number);

	ResponseStructure<List<Student>> fetchStudentsByClassName(String className);

}
