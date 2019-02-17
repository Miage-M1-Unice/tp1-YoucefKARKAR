package fr.miage.m1;

import java.io.File;

public class ListeRepertoire {
	
    public void listRep(String repertoire){
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
    
    
    public void listRepTot(String repertoire){
        File rep = new File(repertoire); //Creation repertoire type File
        String[] lister = rep.list(); //Tableau de string renvoie contenu repertoire

        if (lister != null) { //On affiche le tableau créé si il a pu se créer
            for (int i = 0; i < lister.length; i++) {
            	if(rep.isFile()) {
            		System.out.println(lister[i]);
            	}
            	else {
            		String dir = repertoire + "/" + lister[i];
            		System.out.println(dir);
            		listRepTot(dir);
            	}
            }
        } else { //Sinon erreur
            //System.err.println("Nom de repertoire invalide");
            }
    }
    
    
    public static void main(String args[]) {
    	ListeRepertoire l = new ListeRepertoire(); //Création l de type ListeRepertoire
    	//l.listRep("/home/deptinfo/Bureau/TPjava");
    	
    	l.listRepTot("/home/deptinfo/Bureau/TP_Arduino/TP1");
    }
    
}
