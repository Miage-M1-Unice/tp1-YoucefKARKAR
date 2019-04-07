package fr.miage.m1;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex implements FilenameFilter {
	
	private Matcher m ;

	public Regex (String chaine)
    {
        Pattern p = Pattern.compile("*.ino");

    }
	@Override
	public boolean accept(File dir, String name) {
		File f = new File(dir.getPath()+);
		
        File f = new File(dir.getPath()+"/"+name);
        matcher = pattern.matcher(name);
		
		Pattern p = Pattern.compile("*.ino");
		Matcher m = p.matcher(dir.getAbsolutePath());
		
		return m.matches() || f.isDirectory();
	}

}

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
