package com.example.demo.repositries;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Student;

public interface StudentRepositry extends JpaRepository<Student, Integer> {

	public boolean existsByEmail(String email);

	public boolean existsByPhoneNo(String phoneNo);
	
	public Optional<Student> findByEmail(String email);
	public Optional<Student> findByPhoneNo(String phoneNo);
	
	public void deleteByPhoneNo(String phoneNo);
}
