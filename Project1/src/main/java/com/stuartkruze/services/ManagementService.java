package com.stuartkruze.services;

import java.util.List;

import com.stuartkruze.models.Management;

public interface ManagementService {
	
	public Management addManagement(Management m);
	public List<Management> getAllManagements();
	public Management getManagement(int id);
	public Management getManagementByName(String fname, String lname);
	public Management updateManagement(Management change);
	public Management deleteManagement(int id);
}
