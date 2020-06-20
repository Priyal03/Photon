package exceptions;

import java.util.*;
import java.util.concurrent.CompletionException;
import java.io.*;
import java.lang.*;
public class Baeldung {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[][] ints = { { 1, 2, 3 }, { null }, { 7, 8, 9 } };

		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 3; j++) {

				try {
					System.out.println("value = " + ints[i][j]);
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Ex happend!!");
				}
			}
		}
		
		Baeldung bl=new Baeldung();
		//try {bl.readFile();} catch (TaskException e) {		}
		
		
		List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
		integers.forEach(i -> {
		    if (i == 0) {
		        throw new IllegalArgumentException("Zero not allowed");
		        
		       
		    }
		    System.out.println(Math.PI / i);
		    
		   
		});

	}
//try catch in lambda
	private void readFile() {
		throw new IllegalAccessError();
		
		// THis IS hOW you DO THE ExcePTION ChainING
//		try {
//			
//			File f=new File("srx/");
//			
//		    //task.readConfigFile();
//		} catch (FileNotFoundException ex) {
//		    throw new TaskException("Could not perform task", ex);
//		}
	}
	
	
	

}
