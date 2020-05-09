package sorting;

public class Bubble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 1, 4, 3, -2, -6, 5 };

		int separationIndex = arr.length;
		
		for (int i = separationIndex-1; i >=0 ; i--) {//for n times

			for (int j = 0; j < i; j++) {//adj swapping one time

				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
			//each time sorted partition is increasing.. bcoz of that sorting partition index is reducing.
		}
		for (int i : arr) {
			System.out.println(i);
		}
	}

	public static void swap(int[] arr, int i, int j) {

		if(i==j)
			return;
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
