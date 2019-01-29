package com.core;

public class ManagerFactory {

	public static PatientManager manager=null;
	
	public static PatientManager getUniqueManager() {
		
		if(manager == null)
			manager = new PatientManager();
		return manager;
	}
	
	
}
