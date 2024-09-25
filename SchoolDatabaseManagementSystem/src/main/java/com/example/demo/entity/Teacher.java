package com.example.demo.entity;

import java.sql.Date;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private Date dob;
	private char gender;
	@Column(unique = true,nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(unique = true,name = "phone_no")
	private String phoneNo;
	@OneToOne
	@Cascade(CascadeType.ALL)
	private Address address;
	@OneToOne(mappedBy = "mentor")
	private Class class_name;
	@ManyToMany(mappedBy = "teachers")
	private List<Subject> subjects;
	@ManyToMany(mappedBy = "teachers")
	private List<Class> all_classes;

}
