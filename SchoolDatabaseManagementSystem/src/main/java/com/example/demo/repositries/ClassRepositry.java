package com.example.demo.repositries;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Class;

public interface ClassRepositry extends JpaRepository<Class, Integer> {

	public Optional<Class> findByname(String name);

	public boolean existsByName(String name);

	public boolean existsByAcademicYear(int year);
	
	public List<Class> findByAcademicYear(int year);
	
	public void deleteByAcademicYear(int year);
	
}

