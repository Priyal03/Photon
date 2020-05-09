package search;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { -6,-2,1,2,3, 4, 5,6 };
		
		int value = arr[5];
		
		int  start=0, end=arr.length-1, position=0;
		
		// position = find(arr,start,end,value);
		
		position = iterativeFind(arr,value);
		
		System.out.println(position+" "+value);
	}

	private static int iterativeFind(int[] arr, int value) {
		// TODO Auto-generated method stub
		int start =0;
		int end = arr.length;
		
		while(start<end) {
			
			int mid = arr[(start+end)/2];
			
			if(value==arr[mid]) {
				
				return mid;
			}else if(value > arr[mid]) {
				
				start=mid+1;
			}else {
				
				end = mid-1;
			}
		}
		
		return -1;
	}

	//more expensive operation due to overhead involved with method calls in recursive functions.
	private static int find(int[] arr, int start, int end, int value) {
		// TODO Auto-generated method stub
		
		int mid=(start+end)/2;
		int index = 0;
		
		if(value==arr[mid])
			return mid;
		
		if(value>arr[mid]) {
			index = find(arr,mid+1,end,value);
		}else if(value<arr[mid]){
			index = find(arr,start,mid-1,value);
		}else
			return -1;
		return index;
	}

}
