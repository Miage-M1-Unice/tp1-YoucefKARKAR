package fr.miage.m1;

import java.io.File;
import java.io.FilenameFilter;

public class MyFiltre implements FilenameFilter {

	private String ext;

	public MyFiltre(String ext) {
		this.ext = ext.toLowerCase();
	}

	public boolean accept(File dir, String name) {
		File f = new File(dir,name);
		return f.getName().toLowerCase().endsWith(ext) || f.isDirectory();
	}
}
