package com.example.demo.daoImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.ClassDao;
import com.example.demo.dao.StudentDao;
import com.example.demo.entity.Class;
import com.example.demo.entity.Student;
import com.example.demo.exceptionalHandling.EntityAlreadyExistException;
import com.example.demo.exceptionalHandling.EntityNotPresentException;
import com.example.demo.repositries.StudentRepositry;

import jakarta.transaction.Transactional;

@Repository
public class StudentDaoImplementation implements StudentDao {

	@Autowired
	private StudentRepositry repository;

	@Autowired
	private ClassDao classDao;

	@Override
	public Student saveStudent(Student s) {
		if (repository.existsByEmail(s.getEmail())) {
			throw new EntityAlreadyExistException("Student is already present with the email " + s.getEmail());
		}
		if (repository.existsByPhoneNo(s.getPhoneNo()))
			throw new EntityAlreadyExistException("Student is already present with the number " + s.getPhoneNo());
		return repository.save(s);
	}

	@Override
	public Student updateStudent(Student s, int id) {
		Student student = fetchStudentByID(id);

		Optional<Student> optional = repository.findByEmail(s.getEmail());

		if (optional.isPresent()) {
			if (optional.get().getId() != id) {
				throw new EntityAlreadyExistException("Student is already present with the email " + s.getEmail());
			}
		}

		optional = repository.findByPhoneNo(s.getPhoneNo());
		if (optional.isPresent()) {
			if (optional.get().getId() != id) {
				throw new EntityAlreadyExistException("Student is already present with the phone " + s.getPhoneNo());
			}
		}
		s.setId(id);
		return repository.save(s);
	}

	@Override
	public boolean deleteStudentByID(int id) {
		Student studentByID = fetchStudentByID(id);
		repository.delete(studentByID);
		return true;
	}

	@Override
	@Transactional
	public boolean deleteStudentByNumber(String number) {
		if (!repository.existsByPhoneNo(number))
			throw new EntityNotPresentException("Student with the number " + number + " is not available to delete");
		repository.deleteByPhoneNo(number);
		return true;
	}

	@Override
	public Student fetchStudentByID(int id) {
		Optional<Student> optional = repository.findById(id);
		return optional.orElseThrow(
				() -> new EntityNotPresentException("Student with the Id " + id + " is not available to Update"));
	}

	@Override
	public Student fetchStudentByNumber(String number) {
		Optional<Student> optional = repository.findByPhoneNo(number);
		return optional.orElseThrow(() -> new EntityNotPresentException(
				"Student with the number " + number + " is not available to Update"));
	}

	@Override
	public List<Student> fetchStudentsByClassName(String className) {
		Class name = classDao.fetchClassByName(className);
		return name.getStudents();
	}
}
