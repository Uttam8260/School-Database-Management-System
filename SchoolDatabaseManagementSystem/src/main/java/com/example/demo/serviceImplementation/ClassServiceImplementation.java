package com.example.demo.serviceImplementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ClassDao;
import com.example.demo.entity.Class;
import com.example.demo.service.ClassService;
import com.example.demo.utility.ResponseStructure;

@Service
public class ClassServiceImplementation implements ClassService {

	@Autowired
	private ClassDao dao;

	@Override
	public ResponseStructure<Class> saveClass(Class c) {
		Class classWithId = dao.saveClass(c);

		return createResponseStructure(201, "Class details are saved inside the DB sauccesfully",
				classWithId);
	}

	@Override
	public ResponseStructure<Class> updateClass(Class c, int id) {
		Class classWithUpdatedData = dao.updateClass(c, id);
		return createResponseStructure(200, "Class details are Updated inside the DB sauccesfully",classWithUpdatedData);
		
	}

	@Override
	public ResponseStructure<Class> fetchClassByID(int id) {
		Class classByID = dao.fetchClassByID(id);
		return createResponseStructure(200, "Class details are fetched succesfully", classByID);
		
	}

	@Override
	public ResponseStructure<List<Class>> fetchClassesByAcademiCYear(int year) {
		List<Class> list = dao.fetchClassesByAcademiCYear(year);
		return new ResponseStructure<List<Class>>(200, "List of Class details are fetched succesfully", list, LocalDateTime.now());
		
	}

	@Override
	public ResponseStructure<Class> deleteClassBYId(int id) {
		dao.deleteClassBYId(id);
		return createResponseStructure(204, "Class details are deleted succesfully", null);
	}

	@Override
	public ResponseStructure<Class> deleteClassBYYear(int year) {
		dao.deleteClassBYYear(year);
		return createResponseStructure(204, "Class details are deleted succesfully", null);
	}
	
	private ResponseStructure<Class> createResponseStructure(int statusCode,String msg, Class data){
		return new ResponseStructure<>(statusCode, msg,
				data, LocalDateTime.now());
	}
}
