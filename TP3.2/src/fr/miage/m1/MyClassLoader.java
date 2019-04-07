package fr.miage.m1;

import java.io.*;
import java.nio.file.Paths;
import java.security.SecureClassLoader;
import java.util.ArrayList;

import static java.nio.file.Files.readAllBytes;

public class MyClassLoader extends SecureClassLoader {

    private ArrayList<File> path = null;

    public MyClassLoader(ArrayList<File> p) {
        this.path = p;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] b = null;
        try {
            b = loadClassData(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (b == null) {
            throw new ClassNotFoundException();
        }
        System.out.println("name = [" + name + "]");

        //Thread.dumpStack(); //pile d'appels
        return super.defineClass(name, b, 0, b.length);
    }

    private byte[] loadClassData(String name) throws ClassNotFoundException, IOException {

        name  = name.replace(".",File.separator);
        name += ".class";
        System.out.println(name);
        int i;
        for (i = 0; i < this.path.size();i++){

            String s = this.path.get(i) +File.separator + name ;
            File f = new File(s);

            if (f.exists()){
                return readAllBytes(Paths.get(s));
            }
        }

        //transformer name en chemin vers le .class ; utiliser path separator
        //parcourir le chemin et demander si ce fichier existe ou pas
        //ouvrir le fichier et le lire (ouvrir un input Stream)
        //retourner le contenu

        return null;



    }

    public static void main(String[] args) {
        ArrayList<File> al = new ArrayList<File>();
        al.add(new File("/home/deptinfo/Documents/"));
        al.add(new File("/home/deptinfo/Desktop/TPjava/test/"));
        MyClassLoader myCL = new MyClassLoader(al);
        try {
            Class cl = myCL.loadClass("miage.m1.Test");
            System.out.println(cl);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}