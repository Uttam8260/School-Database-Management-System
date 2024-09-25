package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Class {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false,name = "academic_year")
	private int academicYear;
	@OneToMany(mappedBy = "class_name")
	private List<Subject> subjects;
	
	@OneToMany(mappedBy = "c")
	private List<Student> students;
	
	@OneToOne
	private Teacher mentor;
	@ManyToMany
	private List<Teacher> teachers;
	
}
