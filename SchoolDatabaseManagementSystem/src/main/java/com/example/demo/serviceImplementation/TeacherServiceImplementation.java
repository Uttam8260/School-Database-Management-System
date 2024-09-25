package com.example.demo.serviceImplementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TeacherDao;
import com.example.demo.entity.Teacher;
import com.example.demo.service.TeacherService;
import com.example.demo.utility.ResponseStructure;

@Service
public class TeacherServiceImplementation implements TeacherService {

	@Autowired
	private TeacherDao dao;

	@Override
	public ResponseStructure<Teacher> saveTeacher(Teacher s) {
		Teacher teacher = dao.saveTeacher(s);
		return new ResponseStructure<Teacher>(201, "Teacher data is saved succesfully", teacher, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Teacher> updateTeacher(Teacher s, int id) {
		Teacher teacher = dao.updateTeacher(s, id);
		return new ResponseStructure<Teacher>(200, "Teacher data is updated succesfully", teacher, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Teacher> deleteTeacherByID(int id) {
		dao.deleteTeacherByID(id);
		return new ResponseStructure<Teacher>(204, "Teacher data is deleted succesfully", null, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Teacher> deleteTeacherByNumber(String number) {
		dao.deleteTeacherByNumber(number);
		return new ResponseStructure<Teacher>(204, "Teacher data is deleted succesfully", null, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Teacher> fetchTeacherByID(int id) {
		Teacher teacher = dao.fetchTeacherByID(id);
		return new ResponseStructure<Teacher>(200, "Teacher data is fetched succesfully", teacher, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Teacher> fetchTeacherByNumber(String number) {
		Teacher teacher = dao.fetchTeacherByNumber(number);
		return new ResponseStructure<Teacher>(200, "Teacher data is fetched succesfully", teacher, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<List<Teacher>> fetchTeachersByClassName(String className) {
		List<Teacher> list = dao.fetchTeachersByClassName(className);
		return new ResponseStructure<List<Teacher>>(200, "Teachers data is fetched succesfully", list, LocalDateTime.now());
	}
}
