package com.curso.v0;

import java.io.File;

public class PrincipalFile {

	public static void main(String[] args) {
		String currentDir = System.getProperty("user.dir");
		//System.out.println(currentDir);
		//File file = new File(currentDir + "/data/AllAI.pdf");
		File file = new File(currentDir + "/data");
		//System.out.println(file);
		if (file.exists()) {
			System.out.println("Absolute Path: " + file.getAbsolutePath());
			System.out.println("Is Directory: " + file.isDirectory());
			System.out.println("Parent Path: " + file.getParent());
			if (file.isFile()) {
				System.out.println("Size: " + file.length());
				System.out.println("Last Modified: " + file.lastModified());
			} else {
				for (File subfile : file.listFiles()) {
					System.out.println(" " + subfile.getName());
				}
			}
		}
	}

}
