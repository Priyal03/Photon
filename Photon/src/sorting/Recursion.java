package sorting;

public class Recursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x = 20;

		System.out.println(findfactorial(8));

		System.out.println(factIterative(7));
	}
//iterative runs faster and uses less memory
	private static int factIterative(int i) {
		// TODO Auto-generated method stub

		if (i == 0 || i == 1) {
			return 1;
		}

		int fact = 1;
		for (int k = 2; k <= i; k++) {
			fact = fact * k;
		}
		return fact;
	}
//easy to write for programmer
	private static int findfactorial(int i) {
		// TODO Auto-generated method stub

		int fact = 1;
		if (i == 0)  //base case or breaking condition
			return 1;
		if (i == 1) {
			return fact;
		}

		fact = i * findfactorial(i - 1);

		return fact;
	}
//something is like tail recusrion. again java compiler doesn't use tail recusrion so implementing it is useless while coding in java
}
