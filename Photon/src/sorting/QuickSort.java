package sorting;

import java.util.Stack;

/**
 * find a pivot, try to rearrange lower elements to the left and higher elements
 * to the right of pivot. now, we need to do this n number of times with both
 * the subarrays.
 */
public class QuickSort {

	public static void main(String[] args) {

		int array[] = { 3, 5, 2, 8, 0, 1 };

		// quickSort(array, 0, array.length - 1);
		iterativeQS(array, array.length - 1);

		for (int a : array) {
			System.out.print(a);
		}
	}

//	private static void quickSortSpace(int[] array, int i) {
//		
//		Stack<Integer> stack=new Stack<>();
//		
//		
//		
//	}

	private static void quickSort(int[] array, int low, int high) {
		// TODO Auto-generated method stub

		if (low >= high)
			return;

		int pivot = array[high], pivotIndex = low;
		for (int i = low; i < high; i++) {

			if (array[i] <= pivot) {
				swap(array, i, pivotIndex);
				pivotIndex++;
			}
		}
		swap(array, high, pivotIndex);

		quickSort(array, low, pivotIndex - 1);
		quickSort(array, pivotIndex + 1, high);
	}
/*
 * space complexity : O(log n)
 * TC : 
 */
	private static void iterativeQS(int[] array, int high) {

		Stack<Integer> stack = new Stack<>();
		int n = array.length;
		stack.add(array[0]);
		stack.add(array[high]);

		while (!stack.isEmpty()) {

			high = stack.pop();
			int pivot = array[high], low = stack.pop();
			int pivotIndex = low;

			for (int i = low; i < high; i++) {
				if (array[i] <= pivot) {
					swap(array, i, pivotIndex);
					pivotIndex++;
					System.out.print("with low="+low+" with high="+ high+" the pIndex="+pivotIndex);
				}
			}
			swap(array, high, pivotIndex);

			if (pivotIndex>high) {
				stack.add(pivotIndex + 1);
				stack.add(array[n - 1]);
			}
			if(pivotIndex <low ) {
				stack.add(array[0]);
				stack.add(pivotIndex - 1);
			}
		}
	}

	private static void swap(int[] array, int i, int pivotIndex) {
		// TODO Auto-generated method stub
		int temp = array[i];
		array[i] = array[pivotIndex];
		array[pivotIndex] = temp;
	}
}
