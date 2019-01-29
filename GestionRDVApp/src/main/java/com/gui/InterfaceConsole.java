package com.gui;

import java.io.IOException;
import java.util.Scanner;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;

import com.core.ManagerFactory;
import com.core.Patient;
import com.core.PatientManager;

public class InterfaceConsole {

	public static int mainMenu() {

		System.out.println("-------- GESTION DE RENDEZ-VOUS MEDICAL----------");

		System.out.println("1- Ajouter un rendez-vous ");
		System.out.println("2- Modifier un rendez-vous ");
		System.out.println("3- Reporter un rendez-vous ");
		System.out.println("4- Annuler un rendez-vous ");
		System.out.println("5- Afficher tout les rendez-vous");
		System.out.println("6- Quitter");
		System.out.println("Choisir une option ");

		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();

		return s;

}
	
	public static void main(String[] args) {
		
		 Element racine = new Element("patient_list");
		 Document document = new Document(racine);
		 
		 PatientManager manager = ManagerFactory.getUniqueManager();
		 
		 
		 
		 do {
		
			 
			 Scanner sc = new Scanner(System.in);

			 int choice = mainMenu();
			 
			 switch (choice) {
			case 1:
				
					Patient p = new Patient();
					System.out.println("Saisir le nom du patient:");
					p.setNom(sc.nextLine());
					System.out.println("Saisir le prenom du patient:");
					p.setPrenom(sc.nextLine());
					System.out.println("Saisir le numero de telephone du patient:");
					p.setTelephone(sc.nextLine());
					System.out.println("Saisir la date du rendez-vous sous forme jj/mm/aa:");
					p.setDate(sc.nextLine());
					System.out.println("Saisir la profession du patient:");
					p.setOccupation(sc.nextLine());
					System.out.println("Saisir l'age du patient:");
					p.setAge(sc.nextInt());

					
				try {
					manager.addElement(document, p);
					System.out.println("Enregistrer avec success !");
					System.out.println(p);
				} catch (JDOMException e) {
					
					System.out.println("Erreur lors de l'enregistrement,veuiller reessayer !");
					e.printStackTrace();
				} catch (IOException e) {
				
					System.out.println("Erreur lors de l'enregistrement,veuiller reessayer !");
					e.printStackTrace();
				}
				
					break;
				
			case 2:
					
				Patient temp = new Patient();
				System.out.println("Saisir le numero du rendez-vous a modifier:");
				
				try {
					temp = manager.getElementById(document, sc.nextInt());
					System.out.println(temp);
					System.out.println("Mise a jour ");
					temp.setDate(sc.nextLine());// Temporiser.....
					System.out.println("Saisir la nouvelle date du rendez-vous sous forme jj/mm/aa");
					temp.setDate(sc.nextLine());
					System.out.println("Saisir le nouveau telephone");
					temp.setTelephone(sc.nextLine());
					System.out.println("Saisir le nouveau nom");
					temp.setNom(sc.nextLine());
					System.out.println("Saisir le nouveau prenom");
					temp.setPrenom(sc.nextLine());
					System.out.println("Saisir l'age");
					temp.setAge(sc.nextInt());
					System.out.println("Saisir la profession");
					temp.setOccupation(sc.nextLine());
					
					
					manager.updateElement(document, temp);
					System.out.println("Modifier avec success...");
					System.out.println(manager.getElementById(document, temp.getId()));
					
				} catch (JDOMException e) {
					
					System.out.println("Erreur lors de la mise a jour");
					e.printStackTrace();
					
				} catch (IOException e) {
					
					System.out.println("Erreur lors de la mise a jour");
					e.printStackTrace();
					
				}
			
				break;
				
			case 3:
				Patient temp1 = new Patient();
				System.out.println("Saisir le numero du rendez-vous a reporter:");
				
				try {
					
					temp1 = manager.getElementById(document, sc.nextInt());
					System.out.println(temp1);
					System.out.println("Saisir la nouvelle date du rendez-vous sous forme jj/mm/aa");
					temp1.setDate(sc.nextLine());
					manager.updateElement(document, temp1);
					System.out.println("Effectuer avec success...");
					System.out.println(manager.getElementById(document, temp1.getId()));
					
				} catch (JDOMException e) {
					
					System.out.println("Erreur lors de l'enregistrement,reassayer !");
					e.printStackTrace();
					
				} catch (IOException e) {
					
					System.out.println("Erreur lors de l'enregistrement,reassayer !");
					e.printStackTrace();
				}
				
				
				break;
			
			case 4:
					System.out.println("Saisir le numero du rendez-vous a annuler:");
				try {
					manager.deleteElement(document, sc.nextInt());
					System.out.println("Suppimer avec succes !");
				} catch (JDOMException e) {
		
					System.out.println("Erreur lors de la suppression,reessayer !");
					e.printStackTrace();
				} catch (IOException e) {
					
					System.out.println("Erreur lors de la suppression,reessayer !");
					e.printStackTrace();
				}
				
				break;
			
			case 5:
					
					System.out.println("Liste des rendez-vous:");
					System.out.println(" ");
				try {
					manager.getAllElements(document);
				} catch (JDOMException e) {
					System.out.println("Erreur lors de chargement des rendez-vous,reassayer !");
					e.printStackTrace();
				} catch (IOException e) {
					System.out.println("Erreur lors de chargement des rendez-vous,reassayer !");
					e.printStackTrace();
				}
				
				
				break;
			case 6:
				
					System.exit(0);
				
					
			default:
				
				System.out.println("Veullez choisir une option valide !");
				break;
			 }
			
		} while (true);
		
	}
	
}
