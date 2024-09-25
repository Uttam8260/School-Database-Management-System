package com.example.demo.serviceImplementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SubjectDao;
import com.example.demo.entity.Class;
import com.example.demo.entity.Subject;
import com.example.demo.service.SubjectService;
import com.example.demo.utility.ResponseStructure;

@Service
public class SubjectServiceImplementation implements SubjectService {

	@Autowired
	private SubjectDao dao;

	@Override
	public ResponseStructure<Subject> saveSubject(Subject s, String className) {
		Subject subject = dao.saveSubject(s, className);
		return new ResponseStructure<Subject>(201, "Subject is added to the db succesfully", subject,
				LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Subject> updateSubject(Subject s, int id) {
		Subject subject = dao.updateSubject(s, id);
		return new ResponseStructure<Subject>(200, "Subject is updated to the db succesfully", subject,
				LocalDateTime.now());

	}

	@Override
	public ResponseStructure<Subject> fetchSubjectByID(int id) {
		Subject subject = dao.fetchSubjectByID(id);
		return new ResponseStructure<Subject>(200, "Subject is fetched from the db succesfully", subject,
				LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Subject> fetchSubjectByCode(String code) {
		Subject subject = dao.fetchSubjectByCode(code);
		return new ResponseStructure<Subject>(200, "Subject is fetched from the db succesfully", subject,
				LocalDateTime.now());
	}

	@Override
	public ResponseStructure<List<Subject>> fetchSubjectByClassName(String className) {
		List<Subject> subject = dao.fetchSubjectByClassName(className);
		return new ResponseStructure<List<Subject>>(200, "List of Subjects are fetched from the db succesfully", subject,
				LocalDateTime.now());
	}

	@Override
	public ResponseStructure<List<Subject>> fetchSubjectByStudentId(int id) {
		List<Subject> subject = dao.fetchSubjectByStudentId(id);
		return new ResponseStructure<List<Subject>>(200, "List of Subjects are fetched from the db succesfully", subject,
				LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Subject> deleteSubjectByID(int id) {
		dao.deleteSubjectByID(id);
		return new ResponseStructure<Subject>(204, "Subject is deleted from the db succesfully", null,
				LocalDateTime.now());
	}
}
