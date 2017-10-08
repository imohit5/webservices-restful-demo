package com.restful.demo.persistent;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name ="Prescription")
public class Prescription {

	private long id;
	private String description;

	Map<Long, Medicine> prescriptions = new HashMap<Long, Medicine>();

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

	public Map<Long, Medicine> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(Map<Long, Medicine> prescriptions) {
		this.prescriptions = prescriptions;
	}
	
	public Medicine getMedicine(int medicineid) {
		System.out.println("----invoking getMedicine with id: " + medicineid);
		Medicine medicine = prescriptions.get(new Long(medicineid));
		return medicine;
	}

	final void init() {
		Medicine medicine = new Medicine();
		medicine.setId(123);
		medicine.setDescription("Medicine 123");
		prescriptions.put(medicine.getId(), medicine);
	}

}
