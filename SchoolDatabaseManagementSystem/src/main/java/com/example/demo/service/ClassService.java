package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Class;
import com.example.demo.utility.ResponseStructure;

public interface ClassService {

	ResponseStructure<Class> saveClass(Class c);

	ResponseStructure<Class> updateClass(Class c, int id);

	ResponseStructure<Class> fetchClassByID(int id);

	ResponseStructure<List<Class>> fetchClassesByAcademiCYear(int year);

	ResponseStructure<Class> deleteClassBYId(int id);

	ResponseStructure<Class> deleteClassBYYear(int year);
}
