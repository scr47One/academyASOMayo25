package io_nio2;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Principal {

	public static void main(String[] args) {

		// ** IO **
		File zooFile1 = new File("/home/tiger/data/stripes.txt"); 
		File zooFile2 = new File("/home/tiger", "data/stripes.txt");
		
		File parent = new File("/home/tiger"); 
		File zooFile3 = new File(parent, "data/stripes.txt");

		System.out.println(zooFile3.exists());
		
		// ** NIO2 **
		Path zooPath1 = Path.of("/home/tiger/data/stripes.txt"); 
		Path zooPath2 = Path.of("/home", "tiger", "data", "stripes.txt");

		Path zooPath3 = Paths.get("/home/tiger/data/stripes.txt"); 
		Path zooPath4 = Paths.get("/home", "tiger", "data", "stripes.txt");

		System.out.println(Files.exists(zooPath1));
		
		Path zooPath5 = FileSystems.getDefault().getPath("/home/tiger/data/stripes.txt"); 
		
		FileSystem fs = FileSystems.getDefault();
		Path zooPath6 = fs.getPath("/home", "tiger", "data", "stripes.txt");
	}

}
