package com.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class PatientManager {
	
	private static int idPatient = 1;
	
	public static void addElement(Document document,Patient pPatient) throws JDOMException, IOException {
		
		Element root = null;
		int temp;
		File xmlFile = new File("d:\\Patient.xml");
		FileInputStream fis = new FileInputStream(xmlFile);
		 SAXBuilder sb = new SAXBuilder();
		 document = sb.build(fis);
		 root = document.detachRootElement();
		
		Element Patient = new Element("Patient");
		temp=idPatient++;
		Attribute id = new Attribute("id", String.valueOf(temp));
		pPatient.setId(temp);
	//	idPatient++;
		Patient.setAttribute(id);
	//	Element Patient = document
		
		Element nom = new Element("nom");
		nom.setText(pPatient.getNom());
		
		Element prenom = new Element("prenom");
		prenom.setText(pPatient.getPrenom());
		
		Element age = new Element("age");
		age.setText(String.valueOf(pPatient.getAge()));
		
		Element occupation = new Element("occupation");
		occupation.setText(pPatient.getOccupation());
		
		Element telephone = new Element("telephone");
		telephone.setText(pPatient.getTelephone());
		
		Element date = new Element("date");
		date.setText(pPatient.getDate());
		
		Patient.addContent(nom);
		Patient.addContent(prenom);
		Patient.addContent(age);
		Patient.addContent(occupation);
		Patient.addContent(telephone);
		Patient.addContent(date);

		root = root.detach();
		root.addContent(Patient);
		document.setContent(root);
	//	document.getParent().addContent(Patient);
		
	//	document.getRootElement().getChildren().add(Patient);
	//	document.getRootElement().addContent(Patient);  true
		
		XMLOutputter xmlOutput = new XMLOutputter();

        // display ml
        xmlOutput.setFormat(Format.getPrettyFormat());
        try {
			xmlOutput.output(document, new FileWriter("d:\\Patient.xml"));
			System.out.println("Enregistrer avec succes !!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
	
	public static void updateElement(Document document,Patient pPatient) throws JDOMException, IOException {
		
		Element root = null;
		File xmlFile = new File("d:\\Patient.xml");
		FileInputStream fis = new FileInputStream(xmlFile);
		 SAXBuilder sb = new SAXBuilder();
		 document = sb.build(fis);
		 root = document.getRootElement();
		 
		 List<Element> liste = root.getChildren();
		 
		 for(int i=0;i<liste.size();i++) {
			 
			 Element temp = liste.get(i);
			 
			 if(temp.getAttributeValue("id").equals(String.valueOf(pPatient.getId()))) {
				 
			//	 System.out.println("Helo");
				 temp.getChild("date").setText(pPatient.getDate());
				 temp.getChild("telephone").setText(pPatient.getTelephone());
			//	 System.out.println("Modifications efectuees avec succesw !");
			 }
		 }
		 document.setContent(root);
		 
		 XMLOutputter xmlOutput = new XMLOutputter();

	        // display ml
	        xmlOutput.setFormat(Format.getPrettyFormat());
	        try {
				xmlOutput.output(document, new FileWriter("d:\\Patient.xml"));
				System.out.println("Modifications persistes avec success !!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	}

	public static void deleteElement(Document document,int id) throws JDOMException, IOException {
		
		Element root = null;
		File xmlFile = new File("d:\\Patient.xml");
		FileInputStream fis = new FileInputStream(xmlFile);
		 SAXBuilder sb = new SAXBuilder();
		 document = sb.build(fis);
		 root = document.getRootElement();
		 
		 List<Element> liste = root.getChildren();
		 
		 for(int i=0;i<liste.size();i++) {
			 
			 Element temp = liste.get(i);
			 
			 if(temp.getAttributeValue("id").equals(String.valueOf(id))) {
				 
			//	 System.out.println("Helo");
				 temp.detach();
			//	 System.out.println("Modifications efectuees avec succesw !");
			 }
		 }
		 document.setContent(root);
		 
		 XMLOutputter xmlOutput = new XMLOutputter();

	        // display ml
	        xmlOutput.setFormat(Format.getPrettyFormat());
	        try {
				xmlOutput.output(document, new FileWriter("d:\\Patient.xml"));
				System.out.println("supression effectuee avec success !!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	}
	
	public static void getAllElements(Document document) throws JDOMException, IOException {
		
		Element root = null;
		File xmlFile = new File("d:\\Patient.xml");
		FileInputStream fis = new FileInputStream(xmlFile);
		 SAXBuilder sb = new SAXBuilder();
		 document = sb.build(fis);
		 root = document.getRootElement();
		 
		 List<Element> liste = root.getChildren();
		 List<Patient> patientList = new ArrayList<Patient>();
		 
		 for(int i=0;i<liste.size();i++) {
			 
			 Patient p = new Patient();
			 Element temp = liste.get(i);
			 
			 p.setId(Integer.parseInt(temp.getAttributeValue("id")));
			 p.setNom(temp.getChildText("nom"));
			 p.setPrenom(temp.getChildText("prenom"));
			 p.setAge(Integer.parseInt(temp.getChildText("age")));
			 p.setOccupation(temp.getChildText("occupation"));
			 p.setTelephone(temp.getChildText("telephone"));
			 p.setDate(temp.getChildText("date"));
			 
			 
			 patientList.add(p);
			 
		 }
		 System.out.println(" ");
		 System.out.println("---- Liste des rendez-vous de la semaine-----");
		 System.out.println(" ");
		 for(int i=0;i<patientList.size();i++) {
			 
			 System.out.println("Id du patient:"+patientList.get(i).getId());
			 System.out.println("Nom du patient:"+patientList.get(i).getNom());
			 System.out.println("Prenom du patient:"+patientList.get(i).getPrenom());
			 System.out.println("Age du patient:"+patientList.get(i).getAge());
			 System.out.println("Occupation du patient:"+patientList.get(i).getOccupation());
			 System.out.println("Contact du patient:"+patientList.get(i).getTelephone());
			 System.out.println("Date :"+patientList.get(i).getDate());
			 
			 System.out.println(" ");
			 System.out.println("----------------------------------------------------------------");
 
			 System.out.println(" ");
			 
		 }
	
	}

	
	public static Patient getElementById(Document document,int id) throws JDOMException, IOException {
		
		Element root = null;
		Patient p = new Patient();
		File xmlFile = new File("d:\\Patient.xml");
		FileInputStream fis = new FileInputStream(xmlFile);
		 SAXBuilder sb = new SAXBuilder();
		 document = sb.build(fis);
		 root = document.getRootElement();
		 
		 List<Element> liste = root.getChildren();
		
		 
		 for(int i=0;i<liste.size();i++) {
			 
			 if(String.valueOf(id).equals(liste.get(i).getAttributeValue("id"))) {
				 
				 Element temp = liste.get(i);
				 
				 p.setId(Integer.parseInt(temp.getAttributeValue("id")));
				 p.setNom(temp.getChildText("nom"));
				 p.setPrenom(temp.getChildText("prenom"));
				 p.setAge(Integer.parseInt(temp.getChildText("age")));
				 p.setOccupation(temp.getChildText("occupation"));
				 p.setTelephone(temp.getChildText("telephone"));
				 p.setDate(temp.getChildText("date"));
				 
			 }	 
		 }

			 return p;
		 }
	
}
