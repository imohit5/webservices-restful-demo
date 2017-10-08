package com.restful.demo.persistent;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Prescription")
public class Prescription {

	private long id;
	private String description;

	Map<Long, Medicine> medicines = new HashMap<Long, Medicine>();

	public Prescription() {
		init();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Map<Long, Medicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(Map<Long, Medicine> medicines) {
		this.medicines = medicines;
	}

	@GET
	@Path("/medicines/{id}")
	public Medicine getMedicine(@PathParam("id") int medicineid) {
		System.out.println("----Inside getMedicine with id: " + medicineid);
		Medicine medicine = medicines.get(new Long(medicineid));
		return medicine;
	}

	final void init() {
		Medicine medicine = new Medicine();
		medicine.setId(123);
		medicine.setDescription("Medicine 123");
		medicines.put(medicine.getId(), medicine);
	}

}
