package com.stuartkruze.repositories;

import java.util.List;

import com.stuartkruze.models.Management;

public interface ManagementRepo {
	
	public Management addManagement(Management m);
	public List<Management> getAllManagements();
	public Management getManagement(int id);
	public Management getManagementByName(String fname, String lname);
	public Management updateManagement(Management change);
	public Management deleteManagement(int id);
}
