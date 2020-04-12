package java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ForEach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> name = Arrays.asList("hello","Mico","kitty");
		
		//if you just want to print all the elements
		name.forEach(System.out::println);
		System.out.println("---------------------------------------------");
		
		//if you need to do some operations on it
		Consumer<String> makeUpperCase = new Consumer<String>() {
			
			public void accept(String t){
				System.out.println(t.toUpperCase());
			}
			
		};
		name.forEach(makeUpperCase);
		System.out.println("---------------------------------------------");
		
		//iterating hashmap using foreach
		Map<String, Integer> nameID = new HashMap<String, Integer>();
		
		nameID.put("priyal", 1);
		nameID.put("ninad", 2);
		nameID.put("nidhi", 3);
		nameID.put("hirak", 4);
		
		nameID.forEach((k,v)->System.out.println("Key :"+k+", Value :"+v));
		System.out.println("---------------------------------------------");
		
		//iterating hashmap using foreach and BIConsumer interface.
		BiConsumer<String, Integer> printWithConsumer = (k,v) -> {
			
			System.out.println("key "+ k);
			System.out.println("value "+ v);
		};
		nameID.forEach(printWithConsumer);
		System.out.println("---------------------------------------------");
		
		//using stream API; giving conditions using lambda expressions and then finally using the forEach
		Consumer<String> consumer = System.out::println;
		name.stream().filter(n -> n!=null).forEach(consumer);
		
		
	}

};
