package com.curso.v0;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.stream.Stream;

public class PrincipalPath {

	public static void main(String[] args) {
		String currentDir = System.getProperty("user.dir");
		Path path = Path.of(currentDir + "/data/texto.txt");
		if (Files.exists(path,LinkOption.NOFOLLOW_LINKS)) {
			System.out.println("Absolute Path: " + path.toAbsolutePath());
			System.out.println("Is Directory: " + Files.isDirectory(path));
			System.out.println("Parent Path: " + path.getParent());
			if (Files.isRegularFile(path)) {
				try {
					System.out.println("Size: " + Files.size(path));
					System.out.println("Last Modified: " + Files.getLastModifiedTime(path));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else {
//				try (Stream<Path> stream = Files.list(path)) {
//					stream.forEach(p -> System.out.println("  " + p.getName(6)));
//				}
				try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
				    for (Path p : directoryStream) {
				        System.out.println(" " + p.getName(6));
				    }
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
		}
	}

}
