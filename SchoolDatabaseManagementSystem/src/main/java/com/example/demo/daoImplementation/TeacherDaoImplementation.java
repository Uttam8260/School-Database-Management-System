package com.example.demo.daoImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.ClassDao;
import com.example.demo.dao.TeacherDao;
import com.example.demo.entity.Class;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.exceptionalHandling.EntityAlreadyExistException;
import com.example.demo.exceptionalHandling.EntityNotPresentException;
import com.example.demo.repositries.TeacherRepositry;

@Repository
public class TeacherDaoImplementation implements TeacherDao {

	@Autowired
	private TeacherRepositry repository;

	@Autowired
	private ClassDao dao;

	@Override
	public Teacher saveTeacher(Teacher s) {
		if (repository.existsByEmail(s.getEmail())) {
			throw new EntityAlreadyExistException("TEacher is already present with the email " + s.getEmail());
		}
		if (repository.existsByPhoneNo(s.getPhoneNo()))
			throw new EntityAlreadyExistException("TEacher is already present with the number " + s.getPhoneNo());
		return repository.save(s);
	}

	@Override
	public Teacher updateTeacher(Teacher s, int id) {
		Teacher student = fetchTeacherByID(id);

		Optional<Teacher> optional = repository.findByEmail(s.getEmail());

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
	public boolean deleteTeacherByID(int id) {
		repository.delete(fetchTeacherByID(id));
		return true;
	}

	@Override
	public boolean deleteTeacherByNumber(String number) {
		repository.delete(fetchTeacherByNumber(number));
		return true;
	}

	@Override
	public Teacher fetchTeacherByID(int id) {
		Optional<Teacher> optional = repository.findById(id);
		return optional.orElseThrow(() -> new EntityNotPresentException("Teacher with id " + id + " is not present"));
	}

	@Override
	public Teacher fetchTeacherByNumber(String number) {
		Optional<Teacher> optional = repository.findByPhoneNo(number);
		return optional
				.orElseThrow(() -> new EntityNotPresentException("Teacher with number " + number + " is not present"));
	}

	@Override
	public List<Teacher> fetchTeachersByClassName(String className) {
		Class classByName = dao.fetchClassByName(className);
		return classByName.getTeachers();
	}
}
