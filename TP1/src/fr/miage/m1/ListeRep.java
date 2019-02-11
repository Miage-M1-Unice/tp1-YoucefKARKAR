package fr.miage.m1;

import java.io.File;
import java.util.ArrayList;

public class ListeRep {
	
    public void listerRepertoire(String repertoire){
        File repert = new File(repertoire);
        String[] listeFichier = repert.list();      
 
        if (listeFichier != null) {         
            for (int i = 0; i < listeFichier.length; i++) {
                System.out.println(listeFichier[i]);
            }
        } else {
            System.err.println("Nom de repertoire invalide");
        }
     }
    
    
    public void listerRepRec(String repertoire){
    	/*
    	 * Si c'est un dossier recommence
    	 * Si c'est un fichier affiche
    	 */
    	
        File repert = new File(repertoire);
        File[] listeFichier = repert.listFiles();
        
        if (listeFichier.isDirectory() != null) {         
            for (int i = 0; i < listeFichier.length; i++) {
                System.out.println(listeFichier[i]);
            }
        }
        
        
        	if (listeFichier.isDirectory()) {
            	for (String s : listeFichier) {
    				
    			}
            }
     }
    
    
    public static void main(String args[]) {
    	ListeRep l = new ListeRep();
    	l.listerRepertoire("/users/etudiant/k/ky800072/Bureau");
    }
}


