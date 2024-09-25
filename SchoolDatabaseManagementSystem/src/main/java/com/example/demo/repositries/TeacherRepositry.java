package com.example.demo.repositries;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Teacher;

public interface TeacherRepositry extends JpaRepository<Teacher, Integer> {

	public boolean existsByEmail(String email);

	public boolean existsByPhoneNo(String phoneNo);

	public Optional<Teacher> findByPhoneNo(String phoneNO);

	public Optional<Teacher> findByEmail(String email);
}
