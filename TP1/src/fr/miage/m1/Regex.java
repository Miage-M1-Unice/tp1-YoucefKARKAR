package fr.miage.m1;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex implements FilenameFilter {

	@Override
	public boolean accept(File dir, String name) {
		File f = new File(dir,name);
		
		if(f.isDirectory()) {
			return true;
		}
		
		Pattern pattern = Pattern.compile("*.ino");
		Matcher matcher = pattern.matcher(dir.getAbsolutePath());
		
		return matcher.matches();
	}

}
