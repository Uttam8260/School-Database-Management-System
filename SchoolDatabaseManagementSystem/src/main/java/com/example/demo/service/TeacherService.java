package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Teacher;
import com.example.demo.utility.ResponseStructure;

public interface TeacherService {

	ResponseStructure<Teacher> saveTeacher(Teacher s);

	ResponseStructure<Teacher> updateTeacher(Teacher s, int id);

	ResponseStructure<Teacher> deleteTeacherByID(int id);

	ResponseStructure<Teacher> deleteTeacherByNumber(String number);

	ResponseStructure<Teacher> fetchTeacherByID(int id);

	ResponseStructure<Teacher> fetchTeacherByNumber(String number);

	ResponseStructure<List<Teacher>> fetchTeachersByClassName(String className);

}
