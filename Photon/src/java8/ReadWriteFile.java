package java8;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadWriteFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Path file = Paths.get("/Users/coder/git/Photon/Photon/src/java8/","bands.txt");
		
		Path file = Paths.get("./src/java8/bands.txt");
		
		try {
			Stream<String>  lines = Files.lines(file);
			Stream<String> xoxo=Files.lines(file);
			lines.forEach(x->System.out.println(x));
			
			List<String> pass = xoxo.filter(s->s.contains("Elvis")).collect(Collectors.toList());
			pass.forEach(x->System.out.println(x));
 			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
}
