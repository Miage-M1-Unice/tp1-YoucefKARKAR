package fr.miage.m1;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Main  {
	
    public static void main(String[] args) throws ClassNotFoundException, MalformedURLException {
        URL classUrl = new URL("file:///home/deptinfo/Desktop/TPjava/test/");
        URL[] classUrls = {classUrl};
        URLClassLoader urlCL = new URLClassLoader(classUrls);
        Class cl = urlCL.loadClass("fr.miage.m1.Main");
    }
}