package collections;

import java.util.HashMap;

public class CharFrequency {
	
	public static void main(String[] args) {
	      
		String str = "hey yo Iam having fun";
	      
	    HashMap<Character,Integer> frequency = new HashMap<Character,Integer>(); 
	    
	    for(int i=0;i<str.length();i++) {
	    	
	    	frequency.computeIfPresent(str.charAt(i), (g,c)->c+1);
	    	
	    	frequency.computeIfAbsent(str.charAt(i), (c)->1);
	    }
	    System.out.println(frequency+ " freq");
	}
}
