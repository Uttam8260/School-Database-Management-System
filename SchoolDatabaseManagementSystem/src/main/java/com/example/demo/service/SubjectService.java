package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Subject;
import com.example.demo.utility.ResponseStructure;

public interface SubjectService {

	ResponseStructure<Subject> saveSubject(Subject s,String className);

	ResponseStructure<Subject> updateSubject(Subject s, int id);

	ResponseStructure<Subject> fetchSubjectByID(int id);

	ResponseStructure<Subject> fetchSubjectByCode(String code);

	ResponseStructure<List<Subject>> fetchSubjectByClassName(String className);

	ResponseStructure<List<Subject>> fetchSubjectByStudentId(int id);

	ResponseStructure<Subject> deleteSubjectByID(int id);
}
