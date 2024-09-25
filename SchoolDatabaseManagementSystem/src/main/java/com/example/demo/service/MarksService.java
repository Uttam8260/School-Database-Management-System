package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Mark;
import com.example.demo.utility.ResponseStructure;

public interface MarksService {
	ResponseStructure<Mark> saveMarks(Mark mark,int studentId,int subjectId);
	ResponseStructure<Mark> updateMarks(Mark mark,int id);
	ResponseStructure<Mark> deleteMarks(int id);
	ResponseStructure<Mark> fetchMarksById(int id);
	ResponseStructure<List<Mark>> fetchMarksByStudentId(int studentId);
	ResponseStructure<List<Mark>> fetchMarksBySubjectId(int subjectId);
}
