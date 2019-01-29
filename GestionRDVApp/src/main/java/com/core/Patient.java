package com.core;

public class Patient {

	private int id;
	private String nom;
	private String prenom;
	private int age;
	private String occupation;
	private String telephone;
	private String date;
	
	
	
	public Patient() {

	}
	public Patient(String nom, String prenom, int age, String occupation, String telephone, String date) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.occupation = occupation;
		this.telephone = telephone;
		this.date = date;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Patient "+ "\n nom = " + nom + "\n prenom = " + prenom + "\n age = " + age + "\n occupation = "
				+ occupation + "\n telephone = " + telephone + "\n date = " + date + "\n numero rendez-vous = " + id ;
	}

	
	
	
	
	
}
