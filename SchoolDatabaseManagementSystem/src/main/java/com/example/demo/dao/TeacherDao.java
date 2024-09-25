package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Teacher;

public interface TeacherDao {
	Teacher saveTeacher(Teacher s);

	Teacher updateTeacher(Teacher s, int id);

	boolean deleteTeacherByID(int id);

	boolean deleteTeacherByNumber(String number);

	Teacher fetchTeacherByID(int id);

	Teacher fetchTeacherByNumber(String number);

	List<Teacher> fetchTeachersByClassName(String className);

}
