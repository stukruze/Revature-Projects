package com.stuartkruze.services;

import java.util.List;

import com.stuartkruze.models.Management;
import com.stuartkruze.repositories.ManagementRepo;

public class ManagementServiceImpl implements ManagementService {

	public ManagementRepo mr;

	public ManagementServiceImpl(ManagementRepo mr) {
		this.mr = mr;
	}
	
	@Override
	public Management addManagement(Management m) {
		return mr.addManagement(m);
	}

	@Override
	public List<Management> getAllManagements() {
		return mr.getAllManagements();
	}

	@Override
	public Management getManagement(int id) {
		return mr.getManagement(id);
	}

	@Override
	public Management getManagementByName(String fname, String lname) {
		return mr.getManagementByName(fname, lname);
	}

	@Override
	public Management updateManagement(Management change) {
		return mr.updateManagement(change);
	}

	@Override
	public Management deleteManagement(int id) {
		return mr.deleteManagement(id);
	}

}
