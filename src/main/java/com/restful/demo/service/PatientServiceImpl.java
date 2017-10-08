package com.restful.demo.service;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;

import com.restful.demo.persistent.Patient;
import com.restful.demo.persistent.Prescription;

public class PatientServiceImpl implements PatientService {

	private long currentId = 12;
	Map<Long, Patient> patients = new HashMap<Long, Patient>();
	Map<Long, Prescription> prescriptions = new HashMap<Long, Prescription>();

	public PatientServiceImpl() {
		init();
	}

	final void init() {
		Patient patient = new Patient();
		patient.setName("John");
		patient.setId(currentId);
		patients.put(patient.getId(), patient);

		Prescription prescription = new Prescription();
		prescription.setDescription("prescription 22");
		prescription.setId(223);
		prescriptions.put(prescription.getId(), prescription);
	}

	@Override
	public Patient getPatient(String id) {
		System.out.println("Inside getPatient - patient name is: " + id);
		long parseLong = Long.parseLong(id);
		Patient patient = patients.get(parseLong);
		return patient;
	}

	@Override
	public Response updatePatient(Patient patient) {
		System.out.println("Inside updatePatient - patient id is: " + patient.getId());
		Patient patient2 = patients.get(patient.getId());

		Response response;

		if (patient2 != null) {
			patients.put(patient.getId(), patient);
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();
		}

		return response;
	}

	@Override
	public Response addPatient(Patient patient) {
		System.out.println("Inside addPatient - patient name is: " + patient.getName());
		patient.setId(++currentId);
		patients.put(patient.getId(), patient);
		return Response.ok(patient).build();
	}

	@Override
	public Response deletePatients(String id) {
		System.out.println("Inside deletePatients - patient id is: " +id);
		long parseLong = Long.parseLong(id);
		Patient patient = patients.get(parseLong);

		Response response;

		if (patient != null) {
			patients.remove(patient.getId());
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();
		}

		return response;
	}

	@Override
	public Prescription getPrescription(String prescriptionId) {
		// TODO Auto-generated method stub
		return null;
	}

}
