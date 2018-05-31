package com.example.restws;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.example.restws.model.Patient;

@Service
public class PatientServiceImpl implements PatientService{
	Map<Long, Patient> patients = new HashMap<>();
	long currentId = 123;
	
	public PatientServiceImpl() {
		init();
	}
	
	public void init() {
		Patient patient = new Patient();
		patient.setId(currentId);
		patient.setName("John");
		patients.put(patient.getId(), patient);
	}

	@Override
	public List<Patient> getPatients() {
		Collection<Patient> results = patients.values();
		List<Patient> response = new ArrayList<>(results);
		return response;
	}

	@Override
	public Patient getPatient(long id) {		
		if(patients.get(id) == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return patients.get(id);
	}
	
	@Override
	public Response createPatient(Patient patient) {
		patient.setId(++currentId);
		patients.put(patient.getId(), patient);
		return Response.ok(patient).build();
	}
	
	@Override
	public Response updatePatient(Patient patient) {
		Patient currentPatient = patients.get(patient.getId());
		Response response;
		if(currentPatient != null) {
			patients.put(patient.getId(), patient);
			response = Response.ok().build();
		}
		else {
			//response = Response.notModified().build();
			throw new PatientBusinessException();
		}
		return response;
	}
	
	@Override
	public Response deletePatient(long id) {
		//patients.entrySet().stream().
		Patient currentPatient = patients.get(id);		
		if(currentPatient != null) {
			patients.remove(id);
			return Response.ok().build();
		}
		return Response.notModified().build();
	}
	
	
}
