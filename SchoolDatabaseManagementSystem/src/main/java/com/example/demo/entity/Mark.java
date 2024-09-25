package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Mark {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int marks;
	@ManyToOne
	private Subject subject;
	@ManyToOne
	private Student student;
}
