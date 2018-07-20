package com.example.restws.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restws.entity.Student;

public interface StudentDAO extends JpaRepository<Student, Integer>{

}
