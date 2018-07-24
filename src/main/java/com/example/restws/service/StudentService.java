package com.example.restws.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.example.restws.entity.Student;

@Consumes("application/xml,application/json")
@Produces("application/xml,application/json")
@Path("/studentservice")
public interface StudentService {

	@Path("/students")
	@GET
	List<Student> getStudents();
	
	@Path("/student/{id}")
	@GET
	Student getStudent(@PathParam(value = "id") Integer id);
	
	@Path("/student")
	@POST
	Response createStudent(Student s);
	
	@Path("/student")
	@PUT
	Response updateStudent(Student s);
}
