package com.curso.v0;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class PrincipalPath {

	public static void main(String[] args) throws IOException {
		String currentDir = System.getProperty("user.dir");
		var path = Path.of(currentDir + "/data/");
		if (Files.exists(path)) {
			System.out.println("Absolute Path: " + path.toAbsolutePath());
			System.out.println("Is Directory: " + Files.isDirectory(path));
			System.out.println("Parent Path: " + path.getParent());
			if (Files.isRegularFile(path)) {
				System.out.println("Size: " + Files.size(path));
			}
			System.out.println("Last Modified: " + Files.getLastModifiedTime(path));
		} else {
			try (Stream<Path> stream = Files.list(path)) {
				stream.forEach(p -> System.out.println("  " + p.getNameCount()));
			}
		}
	}

}
