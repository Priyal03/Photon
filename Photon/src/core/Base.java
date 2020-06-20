package core;

public class Base {
	
	public Base() {
		
		System.out.println("No arg constructor of Base class");
	}

	public Base(String x) {
		
		System.out.println("constructor of outer class with "+x);
	}
}
