package com.example.restws.service.impl;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restws.dao.StudentDAO;
import com.example.restws.entity.Student;
import com.example.restws.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentDAO studentDao;

	@Override
	public List<Student> getStudents() {		
		return studentDao.findAll();
	}

	@Override
	public Student getStudent(Integer id) {
		return studentDao.findById(id).get();
	}

	@Override
	public Response createStudent(Student s) {
		Student savedStudent = studentDao.save(s);
		return Response.ok(savedStudent).build();
	}

	@Override
	public Response updateStudent(Student s) {
		Student updatedStudent = studentDao.save(s);		
		return Response.ok(updatedStudent).build();
	}

}
