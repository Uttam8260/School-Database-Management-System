package com.example.demo.daoImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.MarksDao;
import com.example.demo.dao.StudentDao;
import com.example.demo.dao.SubjectDao;
import com.example.demo.entity.Mark;
import com.example.demo.entity.Student;
import com.example.demo.entity.Subject;
import com.example.demo.exceptionalHandling.EntityNotPresentException;
import com.example.demo.repositries.MarksRepositry;

@Repository
public class MarksDaoImplementation implements MarksDao {

	@Autowired
	private MarksRepositry repository;

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private SubjectDao subjectDao;

	@Override
	public Mark saveMarks(Mark mark, int studentId, int subjectId) {
		Student student = studentDao.fetchStudentByID(studentId);
		Subject subject = subjectDao.fetchSubjectByID(subjectId);
		List<Subject> list = student.getC().getSubjects();
		long count = list.stream().filter(s -> s.getId() == subjectId).count();
		if (count == 0) {
			throw new EntityNotPresentException(
					"Student with the id " + studentId + "is not associated with the subject where id is " + subjectId);
		}
		mark.setStudent(student);
		mark.setSubject(subject);
		return repository.save(mark);
	}

	@Override
	public Mark updateMarks(Mark mark, int id) {
		if (repository.existsById(id)) {
			mark.setId(id);
			return repository.save(mark);
		}
		throw new EntityNotPresentException("Marks with the id " + id + " is not present");
	}

	@Override
	public boolean deleteMarks(int id) {
		Mark marksById = fetchMarksById(id);
		repository.delete(marksById);
		return true;
	}

	@Override
	public Mark fetchMarksById(int id) {
		Optional<Mark> optional = repository.findById(id);
		return optional.orElseThrow(()->new EntityNotPresentException("Marks with the id " + id + " is not present"));
	}

	@Override
	public List<Mark> fetchMarksByStudentId(int studentId) {
		Student student = studentDao.fetchStudentByID(studentId);
		return student.getMarks();
	}

	@Override
	public List<Mark> fetchMarksBySubjectId(int subjectId) {
		Subject subject = subjectDao.fetchSubjectByID(subjectId);
		return subject.getMarks();
	}
}
