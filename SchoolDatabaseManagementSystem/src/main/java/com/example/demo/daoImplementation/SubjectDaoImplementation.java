package com.example.demo.daoImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.ClassDao;
import com.example.demo.dao.StudentDao;
import com.example.demo.dao.SubjectDao;
import com.example.demo.entity.Class;
import com.example.demo.entity.Student;
import com.example.demo.entity.Subject;
import com.example.demo.entity.Teacher;
import com.example.demo.exceptionalHandling.EntityAlreadyExistException;
import com.example.demo.exceptionalHandling.EntityNotPresentException;
import com.example.demo.repositries.SubjectRepositry;

@Repository
public class SubjectDaoImplementation implements SubjectDao {

	@Autowired
	private SubjectRepositry repositry;

	@Autowired
	private ClassDao classDao;

	@Autowired
	private StudentDao studentDao;

	@Override
	public Subject saveSubject(Subject s, String className) {
		Class fetchClassByName = classDao.fetchClassByName(className);
		if (repositry.existsByCode(s.getCode())) {
			throw new EntityAlreadyExistException("Subject is already present with the same code" + s.getCode());
		}
		s.setClass_name(fetchClassByName);
		return repositry.save(s);
	}

	@Override
	public Subject updateSubject(Subject s, int id) {

		fetchSubjectByID(id);
		Optional<Subject> optional = repositry.findByCode(s.getCode());

		if (optional.isPresent()) {
			if (optional.get().getId() != id) {
				throw new EntityAlreadyExistException("subject is already present with the code " + s.getCode());
			}
		}
		s.setId(id);
		return repositry.save(s);

	}

	@Override
	public Subject fetchSubjectByID(int id) {
		Optional<Subject> optional = repositry.findById(id);
		return optional
				.orElseThrow(() -> new EntityNotPresentException("Subject with the id" + id + " is not present"));
	}

	@Override
	public Subject fetchSubjectByCode(String code) {
		Optional<Subject> optional = repositry.findByCode(code);
		return optional
				.orElseThrow(() -> new EntityNotPresentException("Subject with the code" + code + " is not present"));
	}

	@Override
	public List<Subject> fetchSubjectByClassName(String className) {
		Class class1 = classDao.fetchClassByName(className);
		return class1.getSubjects();
	}

	@Override
	public List<Subject> fetchSubjectByStudentId(int id) {
		Student student = studentDao.fetchStudentByID(id);
		return student.getC().getSubjects();
	}

	@Override
	public boolean deleteSubjectByID(int id) {
		Subject subject = fetchSubjectByID(id);
		repositry.delete(subject);
		return true;
	}
}
