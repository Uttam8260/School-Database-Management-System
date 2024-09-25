package com.example.demo.serviceImplementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MarksDao;
import com.example.demo.entity.Mark;
import com.example.demo.service.MarksService;
import com.example.demo.utility.ResponseStructure;

@Service
public class MarksServiceImplementation implements MarksService {
	@Autowired
	private MarksDao dao;

	@Override
	public ResponseStructure<Mark> saveMarks(Mark mark, int studentId, int subjectId) {
		Mark marks = dao.saveMarks(mark, studentId, subjectId);
		return new ResponseStructure<Mark>(201, "Marks object is saved inside the DB succesfully", marks,
				LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Mark> updateMarks(Mark mark, int id) {
		Mark marks = dao.updateMarks(mark, id);
		return new ResponseStructure<Mark>(200, "Marks object is updated inside the DB succesfully", marks,
				LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Mark> deleteMarks(int id) {
		dao.deleteMarks(id);
		return new ResponseStructure<Mark>(204, "Marks object is deleted from the DB succesfully", null,
				LocalDateTime.now());

	}

	@Override
	public ResponseStructure<Mark> fetchMarksById(int id) {
		Mark marks = dao.fetchMarksById(id);
		return new ResponseStructure<Mark>(200, "Marks object is fecthed from the DB succesfully", marks,
				LocalDateTime.now());

	}

	@Override
	public ResponseStructure<List<Mark>> fetchMarksByStudentId(int studentId) {
		List<Mark> marks = dao.fetchMarksByStudentId(studentId);
		return new ResponseStructure<>(200, "List of marks are fecthed from the DB succesfully", marks,
				LocalDateTime.now());
	}

	@Override
	public ResponseStructure<List<Mark>> fetchMarksBySubjectId(int subjectId) {
		List<Mark> marks = dao.fetchMarksBySubjectId(subjectId);
		return new ResponseStructure<>(200, "List of marks are fecthed from the DB succesfully", marks,
				LocalDateTime.now());
	}
}
