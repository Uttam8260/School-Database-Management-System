package com.example.demo.daoImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.ClassDao;
import com.example.demo.entity.Class;
import com.example.demo.exceptionalHandling.EntityAlreadyExistException;

import com.example.demo.exceptionalHandling.EntityNotPresentException;
import com.example.demo.repositries.ClassRepositry;

import jakarta.transaction.Transactional;

@Repository
public class ClassDaoImplementation implements ClassDao {

	@Autowired
	private ClassRepositry repositry;

	@Override
	public Class saveClass(Class c) {
		checkClassIsPresent(c);
		return repositry.save(c);
	}

	@Override
	public Class updateClass(Class c, int id) {
		checkClassIsPresent(c);
		if (repositry.existsById(id)) {
			c.setId(id);
			return repositry.save(c);
		}
		throw new EntityNotPresentException(
				"Class is not present with the Id " + id + " So we can update this Class details");
	}

	@Override
	public Class fetchClassByID(int id) {
		Optional<Class> optional = repositry.findById(id);
		return optional.orElseThrow(() -> new EntityNotPresentException("Class is not present with the Id " + id));
	}

	@Override
	public List<Class> fetchClassesByAcademiCYear(int year) {
		if(!repositry.existsByAcademicYear(year)) {
			throw new EntityNotPresentException("Classes are not present for the year "+year);
		}
		return repositry.findByAcademicYear(year);
	}

	@Override
	public boolean deleteClassBYId(int id) {
		repositry.delete(fetchClassByID(id));
		return true;
	}

	@Override
	@Transactional
	public boolean deleteClassBYYear(int year) {
		if(repositry.existsByAcademicYear(year)) {
			repositry.deleteByAcademicYear(year);
			return true;
		}
		throw new EntityNotPresentException("Classes are not available with the ACAdemic year : "+year);
		
		
	}

	private void checkClassIsPresent(Class c) {
		boolean year = repositry.existsByAcademicYear(c.getAcademicYear());
		boolean name = repositry.existsByName(c.getName());
		if (year && name) {
			throw new EntityAlreadyExistException(
					"Class data is already exists with year :" + c.getAcademicYear() + " and the name :" + c.getName());
		}
	}

	@Override
	public Class fetchClassByName(String name) {
		Optional<Class> optional = repositry.findByname(name);
		return optional.orElseThrow(()-> new EntityNotPresentException("Classes are not available with the  name : "+name));
	}
}
