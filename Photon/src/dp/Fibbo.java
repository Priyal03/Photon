package dp;

import java.util.HashMap;

public class Fibbo {

	public static void main(String[] args) {

		getFibonacciNumberTopDown(10);
		
		hm.forEach((k,v)->System.out.print(v+" "));

	}

	public static HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

	public static int getFibonacciNumberTopDown(int n) {
		
		if (hm.containsKey(n))
			return hm.get(n);
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		int nthValue = getFibonacciNumberTopDown(n - 1) + getFibonacciNumberTopDown(n - 2);

		hm.put(n, nthValue);

		return nthValue;
	}
}