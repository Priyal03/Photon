package java8;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Directory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Files.list(Paths.get(".")).forEach(System.out::print);
			System.out.println();

			Files.list(Paths.get(".")).filter(Files::isRegularFile).forEach(System.out::print);
			System.out.println();

			Files.newDirectoryStream(Paths.get(".")).forEach(System.out::print);
			System.out.println();

			Files.newDirectoryStream(Paths.get("."), path -> path.toFile().isFile()).forEach(System.out::print);
			System.out.println();

			Files.newDirectoryStream(Paths.get("."), path -> path.toString().endsWith(".java"))
					.forEach(System.out::print);
			System.out.println();

			// final​ ​File​​[]​ files1 = ​new​ ​File​(​"."​).listFiles(file ->
			// file.isHidden());
			// or
			// final​ ​File​​[]​ files2 = ​new​ ​File​(​"./src/"​);
			// .listFiles(​File​::isHidden);

			List fileNamesList = new ArrayList();
			Files.newDirectoryStream(Paths.get("./src/java8/"), path -> path.toString().endsWith(".java"))
					.forEach(filePath -> fileNamesList.add(filePath.toString()));
			fileNamesList.forEach(x -> System.out.println(x));

			Files.list(Paths.get("./src/")).map(Path::toFile).map(File::getAbsolutePath).collect(Collectors.toList());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
