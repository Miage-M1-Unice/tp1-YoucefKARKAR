package fr.miage.m1;

import java.io.File;
import java.io.FilenameFilter;

public class ListeRepertoire {
	
	/********** Exercice 1.a.1 **********/
	public void listRep(String repertoire){ //Avec un tableau de String
    File rep = new File(repertoire); //Creation repertoire type File
    String[] lister = rep.list(); //Tableau de string renvoie contenu repertoire

    if (lister != null) { //On affiche le tableau créé si il a pu se créer
        for (int i = 0; i < lister.length; i++) {
            System.out.println(lister[i]);
        }
    } else { //Sinon erreur
        System.err.println("Nom de repertoire invalide");
        }
	}
	
	
	/********** Exercice 1.a.2 **********/
	public void listRepTot(String repertoire){ //Avec un tableau de String
	    File rep = new File(repertoire); //Creation repertoire type File
	    File[] lister = rep.listFiles(); //Tableau de file renvoie contenu repertoire

	    if (lister != null) { //On affiche le tableau créé si il a pu se créer
	        for (int i = 0; i < lister.length; i++) {
	        	if(lister[i].isDirectory()) {
            		System.out.println(lister[i].getName());//Lister Répertoire
            		System.out.println();//Saut de ligne
            		listRepTot(lister[i].getAbsolutePath()); //Rappel de fonction
	        	}
	        	else {
	        		System.out.println(lister[i].getName());//Lister Fichier
	        	}
	        }
	    }
	}
	

	/********** Exercice 3 -- Classe Interne **********/
	public static class FiltreFichier implements FilenameFilter {

		private String ext;

		public FiltreFichier(String ext) {
			this.ext = ext.toLowerCase();
		}

		public boolean accept(File dir, String name) {
			File f = new File(dir,name);
			return f.getName().toLowerCase().endsWith(ext) || f.isDirectory();
		}
	}
	
	
	public static void listRepFiltr(String repertoire, String mask){
        File rep = new File(repertoire); //Creation repertoire type File
        File[] lister = rep.listFiles(new FiltreFichier(mask));

        if (lister != null) { //On affiche le tableau créé si il a pu se créer
            for (int i = 0; i < lister.length; i++) {
            	if(lister[i].isDirectory()) {
            		System.out.println(lister[i].getName()); //Lister répertoire
            		System.out.println(); //Saut de ligne
            		listRepFiltr(lister[i].getAbsolutePath(),mask); //Rappel de fonction
            	}
            	else {
            		System.out.println(lister[i].getName()); //Lister fichier
            	}
            }
        }
	}
}