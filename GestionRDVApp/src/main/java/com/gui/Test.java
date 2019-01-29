package com.gui;

import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;

import com.core.Patient;
import com.core.PatientManager;

public class Test {
	
	public static void main(String[] args) {
		
		 Element racine = new Element("patient_list");
		 Document document = new Document(racine);
		Patient temp= new Patient();
		Patient p2 = new Patient("Zale2", "Ndiaye", 19, "Architecte", "0022177937645", "12/10/2019");
		Patient p3 = new Patient("Georges", "Moussa", 19, "Macon", "781227", "12/10/2011");
		p3.setId(1);

		
		try {
			
			
			PatientManager.addElement(document, p2);
		//	PatientManager.addElement(document, p2);
		//	temp.setId(2);
			temp = PatientManager.getElementById(document, 2);
			System.out.println(p2);
		//	PatientManager.deleteElement(document, p3);
		//	PatientManager.getAllElements(document);
		//	System.out.println(p3.getId());
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	;

	}

}
