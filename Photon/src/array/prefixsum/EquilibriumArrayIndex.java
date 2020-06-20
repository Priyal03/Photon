package array.prefixsum;

import java.util.stream.IntStream;

/**
 * 
 * @author coder
 *
 *         Equilibrium index of an array is an index such that the sum of
 *         elements at lower indexes is equal to the sum of elements at higher
 *         indexes. IT is one of the applications of Prefix sum.
 */
public class EquilibriumArrayIndex {

	public static void main(String[] args) {

		EquilibriumArrayIndex equi = new EquilibriumArrayIndex();
		int arr[] = { -7, 1, 5, 2, -4, 3, 0 };
		int arr_size = arr.length;
		System.out.println("First equilibrium index is " + equi.equilibrium(arr, arr_size));
	}

	private int equilibrium(int[] arr, int arr_size) {

		long totalSum = IntStream.of(arr).sum();

		int leftSum = 0, index = 0;

		for (int x : arr) {

			totalSum -= x;

			if (leftSum == totalSum)

				break;

			leftSum += x;
			index++;
		}
		return index;
	}
}
