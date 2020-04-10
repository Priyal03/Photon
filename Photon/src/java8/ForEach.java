package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ForEach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> name = Arrays.asList("hello","Mico","kitty");
		
		//if you just want to print all the elements
		name.forEach(System.out::println);
		
		//if you need to do some operations on it
		Consumer<String> makeUpperCase = new Consumer<String>() {
			
			public void accept(String t){
				System.out.println(t.toUpperCase());
			}
			
		};
		name.forEach(makeUpperCase);

	}

}
