package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Mark;

public interface MarksDao {
	
	Mark saveMarks(Mark mark,int studentId,int subjectId);
	Mark updateMarks(Mark mark,int id);
	boolean deleteMarks(int id);
	Mark fetchMarksById(int id);
	List<Mark> fetchMarksByStudentId(int studentId);
	List<Mark> fetchMarksBySubjectId(int subjectId);

}
