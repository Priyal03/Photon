package sorting;

public class Selection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = { 1, 4, 3, 2, -6, 5 };

		int separationIndex = arr.length;

		for(int i=separationIndex-1;i>0;i--) { //starting with separateIndex 
			
			int max=0;
			
			for(int j=1;j<=i;j++) {//finding a max for one iteration; go till lastIndex of the unsoreted List
				
				if(arr[j]>arr[max]) {
					max=j;
				}
			}
			swap(arr,max,i);//then swap it with Last Index of the unsorted list.
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
