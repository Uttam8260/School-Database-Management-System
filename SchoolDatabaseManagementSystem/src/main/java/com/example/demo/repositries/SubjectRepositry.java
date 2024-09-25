package com.example.demo.repositries;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Subject;

public interface SubjectRepositry extends JpaRepository<Subject, Integer> {

	
	public boolean existsByCode(String code);
	
	public Optional<Subject> findByCode(String code);
}
