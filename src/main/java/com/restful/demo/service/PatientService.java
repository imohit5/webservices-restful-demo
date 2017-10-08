package com.restful.demo.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.restful.demo.persistent.Patient;
import com.restful.demo.persistent.Prescription;

@Produces({"application/xml","application/json"})
public interface PatientService {
	
	@GET
	@Path("/patients/{id}")
	public Patient getPatient(@PathParam("id") String id);

	@PUT
	@Path("/patients/")
	public Response updatePatient(Patient patient);

	@POST
	@Path("/patients/")
	public Response addPatient(Patient patient);

	@DELETE
	@Path("/patients/{id}")
	public Response deletePatients(@PathParam("id") String id);

	@GET
	public Prescription getPrescription(String prescriptionId);

}
