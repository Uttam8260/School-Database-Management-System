package com.example.demo.repositries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Mark;

public interface MarksRepositry extends JpaRepository<Mark, Integer> {

}
