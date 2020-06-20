package sorting;

import java.util.Arrays;

public class QuickSort_Descending {
	
	public static void main(String args[]) {
		int[] inputs = { 6, 5, 3, 1, 8, 7, 2, 4 };
		System.out.println("Unsorted array : " + Arrays.toString(inputs));
		QuickSort_Descending j = new QuickSort_Descending();
		j.sort(inputs);
		System.out.println("Sorted array : " + Arrays.toString(inputs));
	}

	private int array[];
	private int length;

	public void sort(int[] numbers) {
		if (numbers == null || numbers.length == 0) {
			return;
		}
		array = numbers;
		length = numbers.length;
		quickSort(0, length - 1);
	}

/*  
 * This method implements in-place quick-sort recursively. 
 * 
 */
	private void quickSort(int low, int high) {
		int i = low;
		int j = high;
		
		int pivot = array[low + (high - low) / 2]; // pivot is middle index. We can take any element from first,last or middle.
		while (i <= j) {
//starting from low index, we find a lesser element compared to pivot 
			while (array[i] > pivot) {
				i++;
			}
//starting from high index, we find greater	element compared to pivot	
			while (array[j] < pivot) {
				j--;
			}
//now that we have found both the pointer, we simply interchange them.			
			if (i <= j) {
				swap(i, j);
				// move index to next position on both sides
				i++;
				j--;
			}
		} 
// at last, call the method recursively to get all positions right.
		if (low < j) {
			quickSort(low, j);
		}
		if (i > high) {
			quickSort(i, high);
		}
	}

	private void swap(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
