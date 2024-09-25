package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Class;

public interface ClassDao {

	Class saveClass(Class c);

	Class updateClass(Class c, int id);

	Class fetchClassByID(int id);

	List<Class> fetchClassesByAcademiCYear(int year);
	
	Class fetchClassByName(String name);
	

	boolean deleteClassBYId(int id);

	boolean deleteClassBYYear(int year);

}
