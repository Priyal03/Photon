package collections;

import java.util.LinkedHashMap;

public class LinkedHM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//3rd parameter set access order
		LinkedHashMap<Integer, String> pairs = new LinkedHashMap<>(4, .75f, true);
		 
		pairs.put(1,  "A");
		pairs.put(2,  "B");
		pairs.put(3,  "C");
		pairs.put(4,  "D");
		 
		//Access 3rd pair
		pairs.get(3);
		 
		//Access 2nd pair
		String x = pairs.getOrDefault(2, "Fooo");
		
		System.out.println(x);
		 
		pairs.forEach((key, value) -> {
		    System.out.println("Key:"+ key + ", Value:" + value);
		}); 
		
		
	}

}
